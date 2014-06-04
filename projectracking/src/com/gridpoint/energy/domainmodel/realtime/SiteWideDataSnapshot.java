package com.gridpoint.energy.domainmodel.realtime;

import com.gridpoint.energy.domainmodel.Channel;
import com.gridpoint.energy.domainmodel.Device;
import com.gridpoint.energy.util.tree.AbstractDomainIndexTreeNode;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * A real-time snapshot of data for a site that has been supplied by channels on devices on endpoints.
 *
 * @author dhorlick
 */
public class SiteWideDataSnapshot extends AbstractDomainIndexTreeNode<Long, EndpointWideDataSnapshot>
{
    private long gpupSiteId;

    private static final Logger log = Logger.getLogger(SiteWideDataSnapshot.class);

    public SiteWideDataSnapshot()
    {
    }

    /**
     * Constructs a new instance with no actual real-time data, but device-specific
     * placeholders for it.
     */
    public static SiteWideDataSnapshot buildFrom(Iterable<Device> devices)
    {
        final SiteWideDataSnapshot siteWideDataSnapshot = new SiteWideDataSnapshot();
        siteWideDataSnapshot.load(devices);
        return siteWideDataSnapshot;
    }

    /**
     * Loads a template shell of devices, but no data.
     */
    public void load(final Iterable<Device> devices) {
        if (devices == null) {
            return;
        }
        for (final Device device : devices) {
            if (device.getEndpointId() == null)
                throw new IllegalArgumentException("No endpoint ID specified for device.");

            getOrCreate(device.getEndpointId());
            if (device.getAddress() == null) {
                // The device address may be null for virtual devices or non-GEEP devices.
                // There is no real-time data to be had for those devices, so skip them.
                return;
            }

            final DeviceWideDataSnapshot snapshot = getOrCreate(device.getEndpointId()).getOrCreate(device.getAddress());
            for (final Channel channel : device.getChannels()) {
                // Is this a GPEC or EVSE channel rather than an ADM one?
                if (channel.getReferenceId() != null && channel.getReferenceId().length() > 0) {
                    if (channel.getChannelName() == null || channel.getChannelName().isEmpty()) {
                        throw new IllegalArgumentException("No name on channel: " + ReflectionToStringBuilder.reflectionToString(channel));
                    }
                    final long geepChannelReferenceId = Long.parseLong(channel.getReferenceId());

                    // We want the channel type's name, which is clearer.
                    // The channel's name is a actually a stringified data-structure. A real name could be teased-out
                    // from this, but one that might be specific to a particular device, and therefore impossible
                    // to aggregate across many devices.
                    snapshot.getOrCreate(geepChannelReferenceId).setChannelName(channel.getChannelName());
                }
            }
        }
    }

    public long getGpupSiteId()
    {
        return gpupSiteId;
    }

    public void setGpupSiteId(final long gpupSiteId)
    {
        this.gpupSiteId = gpupSiteId;
    }

    /**
     * @return Makes a determination whether this snapshot is current and full enough to be worth displaying to
     * users. If no, should send start instant data message to the result of
     * {@link #catalogueDevicesWithoutFreshData}, build a start instant data message command for each,
     * send it to the dispatcher, and wait an appropriate amount of time.
     */
    public boolean isFresh()
    {
        clearOldData();
        final long deviceCount = countDevices();

        if (deviceCount==0L)
        {
            // degenerate case... we should return true to give auto-provisioning a chance to run.
            return true;
        }

        final double staleFraction = (double) catalogueDevicesWithoutFreshData().size() / (double) deviceCount;
        log.debug("staleFraction="+staleFraction);
        return (staleFraction < 0.75);
    }

    public void clearOldData()
    {
        clearOldData(5L * 60L * 1000L); // 5 minutes
    }

    public void clearOldData(final long oldestTolerableAgeInMillis)
    {
        final long NOW = System.currentTimeMillis();

        for (final EndpointWideDataSnapshot endpointWideDataSnapshot : this)
        {
            for (final DeviceWideDataSnapshot deviceWideDataSnapshot : endpointWideDataSnapshot)
            {
                for (final GeepChannelData geepChannelData : deviceWideDataSnapshot)
                {
                    if (geepChannelData.getEndpointTimestamp()==null
                            || (NOW - geepChannelData.getEndpointTimestamp().getTime()>oldestTolerableAgeInMillis))
                    {
                        geepChannelData.setValue(null);
                    }
                }
            }
        }
    }

    /**
     * @return a Collection of devices that exist, but have stale of no data. Various non-identifying details may
     * not be populated on the return objects.
     */
    public Collection<Device> catalogueDevicesWithoutFreshData()
    {
        final List<Device> devicesWithoutUsableData = new ArrayList<Device> ();

        for (final EndpointWideDataSnapshot endpointWideDataSnapshot : this)
        {
            for (final DeviceWideDataSnapshot deviceWideDataSnapshot : endpointWideDataSnapshot)
            {
                if (deviceWideDataSnapshot.countData()==0)
                {
                    devicesWithoutUsableData.add(deviceWideDataSnapshot.getDevice());
                }
            }
        }

        return devicesWithoutUsableData;
    }

    public long countDevices()
    {
        long deviceCount = 0L;

        for (final EndpointWideDataSnapshot endpointWideDataSnapshot : this)
        {
            deviceCount += endpointWideDataSnapshot.size();
        }

        return deviceCount;
    }

    public void registerDeviceData(final long endpointId, final long deviceId, final Map<String, ?> dataSnapshot)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public Document toDocument()
    {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try
        {
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.newDocument();

            final Element realTimeDataElement = document.createElement("realTimeData");
            document.appendChild(realTimeDataElement);

            for (final EndpointWideDataSnapshot endpointWideDataSnapshot : this)
            {
                final Element controllerElement = document.createElement("controller");
                controllerElement.setAttribute("endpoint_id", String.valueOf(
                        endpointWideDataSnapshot.getGpupEndpointId()));
                // TODO serialnumber? siteID?

                for (final DeviceWideDataSnapshot deviceWideDataSnapshot : endpointWideDataSnapshot)
                {
                    final Element deviceElement = document.createElement("device"); // TODO revisit element naming... make them more like ADM-backed service?

                    deviceElement.setAttribute("device_id", deviceWideDataSnapshot.getDevice().getAddress());
                    if (deviceWideDataSnapshot.getDevice().getName()!=null)
                        deviceElement.setAttribute("device_name", deviceWideDataSnapshot.getDevice().getName());

                    for (final GeepChannelData geepChannelData : deviceWideDataSnapshot)
                    {
                        if (geepChannelData.getChannelName()==null || geepChannelData.getChannelName().length()==0)
                            throw new IllegalStateException("No channel name: "+geepChannelData);

                        final Object value = geepChannelData.getValue();
                        final String stringifiedValue = (value!=null)?String.valueOf(value):"";

                        final String perspectiveAttributeName = makeSafeForAttributeName(geepChannelData.getChannelName());
                        
                        if (perspectiveAttributeName.length() == 0)
                        	throw new IllegalStateException("Channel Attribute Name invalid " + perspectiveAttributeName);
                        
                        if (!deviceElement.hasAttribute(perspectiveAttributeName)) {
                            deviceElement.setAttribute(perspectiveAttributeName, stringifiedValue);
                        }
                    }
                    controllerElement.appendChild(deviceElement);
                }

                realTimeDataElement.appendChild(controllerElement);
            }

            return document;
        }
        catch (ParserConfigurationException e)
        {
            throw new IllegalStateException(e);
        }
    }

    public static String makeSafeForAttributeName(final String string)
    {
    	final String formattedName = string.replaceAll("[^a-zA-Z0-9_\\s]", "").replaceAll("\\s", "_").toLowerCase();
    	final StringBuilder stringBuilder = new StringBuilder();
    	boolean removeStartingDigits = false;
        for (int i=0; i<formattedName.length(); i++) {
            final char theChar = formattedName.charAt(i);
            if(i == 0) {
                if(!Character.isDigit(formattedName.charAt(i))) {
            		stringBuilder.append(theChar);
            	} else {
            		removeStartingDigits = true;
            	}
            } else {
            	if(removeStartingDigits && !Character.isDigit(formattedName.charAt(i))) {
            		removeStartingDigits = false;
            	}
            	if(!removeStartingDigits) {
            		stringBuilder.append(theChar);
            	}
            }
        }
        
        if(stringBuilder.toString().matches("^[^_].*$")) {
        	return stringBuilder.toString();
        } else {
        	return "";
        }
    }

    public Long key()
    {
        return gpupSiteId;
    }

    public EndpointWideDataSnapshot newElementInstance(final Long identificationNumber)
    {
        final EndpointWideDataSnapshot endpointWideDataSnapshot = new EndpointWideDataSnapshot();
        endpointWideDataSnapshot.setGpupEndpointId(identificationNumber);
        return endpointWideDataSnapshot;
    }

    public Date lastUpdated()
    {
        Date mostRecentUpdate = null;

        for (final EndpointWideDataSnapshot endpointWideDataSnapshot : this)
        {
            for (final DeviceWideDataSnapshot deviceWideDataSnapshot : endpointWideDataSnapshot)
            {
                for (final GeepChannelData geepChannelData : deviceWideDataSnapshot)
                {
                    if (mostRecentUpdate==null
                            || (geepChannelData.getEndpointTimestamp()!=null && mostRecentUpdate.before(geepChannelData.getEndpointTimestamp())))
                    {
                        mostRecentUpdate = geepChannelData.getEndpointTimestamp();
                    }
                }
            }
        }

        return mostRecentUpdate;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

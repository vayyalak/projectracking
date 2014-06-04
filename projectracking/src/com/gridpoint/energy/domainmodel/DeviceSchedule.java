package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.JavaBeanToMapAdapter;
import com.gridpoint.energy.util.collection.PropertyCatalogue;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A device schedule that can encompass both ADM's and GPEC's model.
 *
 * @author dhorlick
 */
public class DeviceSchedule
{
    private Set<DeviceScheduleEntry> entries = new LinkedHashSet<DeviceScheduleEntry> ();
    private String deviceAddress;

    public DeviceSchedule(final String designatedDeviceAddress)
    {
        setDeviceAddress(designatedDeviceAddress);
    }

    /**
     * @return The string ID that gpec uses to uniquely identify a device within an endpoint. In ADM, this roughly
     * corresponds to lightingLevel or HVAC zoneName.
     */
    public String getDeviceAddress()
    {
        return deviceAddress;
    }

    public void setDeviceAddress(final String designatedDeviceAddress)
    {
        if (designatedDeviceAddress==null || designatedDeviceAddress.length()==0)
            throw new IllegalArgumentException("No device address provided");

        deviceAddress = designatedDeviceAddress;

    }

    public Set<DeviceScheduleEntry> getEntries()
    {
        return entries;
    }

    public void setEntries(final Set<DeviceScheduleEntry> entries)
    {
        this.entries = entries;
    }

    public PropertyCatalogue toPropertyCatalog()
    {
        final PropertyCatalogue propertyCatalogue = new JavaBeanToMapAdapter(this);
        return propertyCatalogue;
    }

    public Element toGpecConfigElement(final Document doc)
    {
        /*
           example:

           <Device name="LCP-1">
               <Period hours="Main" start="00:30" startOffset="0" end="01:00" endOffset="0">
                    <Illumination group="1" value="100" />
               </Period>
           </Device>
           <Device name="HVAC-3">
                <Period hours="Main" start="sunrise" startOffset="0" end="sunset" endOffset="0">
                    <CoolSetpoint value="76" />
                    <HeatSetpoint value="72" />
                    <HVACMode value="2" />
                    <FanMode value="1" />
                </Period>
           </Device>
         */

        final Element deviceElement = doc.createElement("Device");
        if (deviceAddress!=null) // (and it shouldn't be null)
        {
            deviceElement.setAttribute("name", deviceAddress);

            for (final DeviceScheduleEntry entry : entries)
            {
                deviceElement.appendChild(entry.toGpecConfigElement(doc));
            }
        }
        return deviceElement;
    }

    public void addEntry(final DeviceScheduleEntry deviceScheduleEntry)
    {
        entries.add(deviceScheduleEntry);
    }

    public DeviceScheduleEntry findEntryWith(final Class<? extends DeviceScheduleState> scheduleStateClass,
                                             final Object opening, final Object closing)
    {
        for (final DeviceScheduleEntry entry : entries)
        {
            final Period period = entry.getPeriod();

            if (period.getStartTime()==opening && period.getEndTime()==closing
                    && entry.getClass().equals(scheduleStateClass)
                    && period.getStartOffsetInMinutes()==0
                    && period.getEndOffsetInMinutes()==0) // TODO check times, too
            {
                return entry;
            }
        }

        return null;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

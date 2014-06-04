package com.gridpoint.energy.domainmodel.realtime;

import com.gridpoint.energy.domainmodel.Device;
import com.gridpoint.energy.util.tree.AbstractDomainIndexTreeNode;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * A snapshot of all available real-time data for a device.
 *
 * Devices are keyed on GEEP Device Address rather than GPUP Device ID, so that we can record data for
 * devices that may not have been auto-provisioned yet.
 *
 * @author dhorlick
 */
public class DeviceWideDataSnapshot extends AbstractDomainIndexTreeNode<Long, GeepChannelData>
{
    private Device device;

    public long countData()
    {
        long data = 0;

        for (final GeepChannelData geepChannelData : this)
        {
            if (geepChannelData.getValue()!=null)
            {
                data++;
            }
        }

        return data;
    }

    public long channelCount()
    {
        return size();
    }

    public void setDevice(final Device designatedDevice)
    {
        device = designatedDevice;
    }

    public Device getDevice()
    {
        return device;
    }

    public Long key()
    {
        return device.getDeviceId();
    }

    public GeepChannelData newElementInstance(final Long geepChannelReferenceNumber)
    {
        final GeepChannelData channelData = new GeepChannelData();
        channelData.setGeepReferenceId(geepChannelReferenceNumber);
        return channelData;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

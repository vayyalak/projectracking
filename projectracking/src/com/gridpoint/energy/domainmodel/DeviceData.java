package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.ConcretePropertyCatalogue;
import com.gridpoint.energy.util.collection.PropertyCatalogue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains one or more channels for a single device.
 */
public class DeviceData
{
    private String deviceAddress;

    private List<ChannelData> channelDataList = new ArrayList<ChannelData> ();

    /**
     * The GridPoint-specific string ID for the device. This must uniquely identify a device within an endpoint.
     */
    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public List<ChannelData> getChannelDataList() {
        return channelDataList;
    }

    public void setChannelDataList(List<ChannelData> channelDataList) {
        this.channelDataList = channelDataList;
    }

    public PropertyCatalogue toPropertyCatalog()
    {
        final PropertyCatalogue propertyCatalogue = new ConcretePropertyCatalogue();
        propertyCatalogue.put("deviceAddress", getDeviceAddress());

        final List<PropertyCatalogue> channels = new ArrayList<PropertyCatalogue> ();

        for (final ChannelData channelData : channelDataList)
        {
            channels.add(channelData.toPropertyCatalogue());
        }

        propertyCatalogue.put("channels", channels);

        return propertyCatalogue;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object other)
    {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(97, 1111, this);
    }
}

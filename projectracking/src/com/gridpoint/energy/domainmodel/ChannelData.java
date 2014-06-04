package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.ConcretePropertyCatalogue;
import com.gridpoint.energy.util.collection.PropertyCatalogue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * Represents a single channel of data for a particular device.
 */
public class ChannelData
{
    private int channelType;
    private Object value;

    /**
     * The GridPoint-specific ID for the channel type. This would indicate, for example, if the channel represents a
     * thermostat heat setpoint.
     */
    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public PropertyCatalogue toPropertyCatalogue()
    {
        final PropertyCatalogue propertyCatalogue = new ConcretePropertyCatalogue();
        propertyCatalogue.put("channelType", channelType);
        propertyCatalogue.put("value", value);
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
        return HashCodeBuilder.reflectionHashCode(529, 891, this);
    }
}

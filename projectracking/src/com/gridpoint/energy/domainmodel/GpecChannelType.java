package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * @author dhorlick
 */
public class GpecChannelType
{
    private String name;
    private long geepReferenceId;
    private long deviceTypeId;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setGeepReferenceId(long geepReferenceId)
    {
        this.geepReferenceId = geepReferenceId;
    }

    public long getGeepReferenceId()
    {
        return geepReferenceId;
    }

    public long getDeviceTypeId()
    {
        return deviceTypeId;
    }

    public void setDeviceTypeId(long deviceTypeId)
    {
        this.deviceTypeId = deviceTypeId;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

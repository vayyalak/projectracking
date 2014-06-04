package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class EndpointType
{
    private long endpointTypeId;

    private String name;

    private String description;

    public long getEndpointTypeId()
    {
        return endpointTypeId;
    }

    public void setEndpointTypeId(long endpointTypeId)
    {
        this.endpointTypeId = endpointTypeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

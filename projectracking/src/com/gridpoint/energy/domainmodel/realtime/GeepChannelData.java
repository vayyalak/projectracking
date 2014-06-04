package com.gridpoint.energy.domainmodel.realtime;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * @author dhorlick
 */
public class GeepChannelData
{
    private long gpupChannelId;
    private long geepReferenceId;
    private String channelName;
    private Object value;
    private Date endpointTimestamp;

    public long getGpupChannelId()
    {
        return gpupChannelId;
    }

    public void setGpupChannelId(final long designatedGpupChannelId)
    {
        gpupChannelId = designatedGpupChannelId;
    }

    public long getGeepReferenceId()
    {
        return geepReferenceId;
    }

    public void setGeepReferenceId(final long designatedGeepReferenceId)
    {
        geepReferenceId = designatedGeepReferenceId;
    }

    public String getChannelName()
    {
        return channelName;
    }

    public void setChannelName(final String designatedChannelName)
    {
        channelName = designatedChannelName;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(final Object designatedValue)
    {
        value = designatedValue;
    }

    public void setEndpointTimestamp(final Date designatedEndpointTimestamp)
    {
        endpointTimestamp = designatedEndpointTimestamp;
    }

    public Date getEndpointTimestamp()
    {
        return endpointTimestamp;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

package com.gridpoint.energy.domainmodel.datarepository.datanormalizer.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * NormalData is an instantaneous reading of channels and is contained by NormalEvents
 */
public class NormalData implements Serializable, Normal
{
	private static final long serialVersionUID = -4788923246557509617L;

	private final long                  channelId;
    private final long                  date;
    private final Object                object;

    public NormalData ( long channelId, long date, Object object) {
        this.channelId  = channelId;
        this.date       = date;
        this.object     = object;
    }

    public long getChannelId () {
        return channelId;
    }

    public long getDate () {
        return date;
    }

    public Object getObject () {
        return object;
    }

    public Double getObjectAsDouble () {
        return ((Number)object).doubleValue();
    }
    public long getTime() {
        return( getDate() );
    }

    @Override
    public String toString () {
        return "NormalData{" + "channelId=" + channelId + ", date=" + new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format( new Date(date)) + ", object=" + object + '}';
    }
}

package com.gridpoint.energy.domainmodel.datarepository.datanormalizer.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A NormalEvent is an Instantaneous event and possibly data readings.
 */
public class NormalEvent implements Serializable, Normal {
	private static final long serialVersionUID = -1125140382257312538L;

    private final long              deviceId;
	private final long              timeStamp;
    private final int               eventType;
    private final List<NormalData>  eventData;

    public NormalEvent (long deviceId, long timeStamp, int eventType, List<NormalData> eventData) {
        this.deviceId = deviceId;
        this.timeStamp = timeStamp;
        this.eventType = eventType;
        this.eventData = eventData;
    }

    public List<NormalData> getEventData () {
        return eventData;
    }

    public long getTimeStamp () {
        return timeStamp;
    }

    public int getEventType () {
        return eventType;
    }

    public long getDeviceId () {
        return deviceId;
    }

    public static NormalEvent fromBytes (byte[] value) {
    	NormalEvent normalEvent = null;
    	GZIPInputStream gzipIn = null;
    	ObjectInputStream inObject = null;
    	try {
	    	ByteArrayInputStream inBytes     = new ByteArrayInputStream( value );
	        gzipIn = new GZIPInputStream( inBytes );
	        inObject = new ObjectInputStream( gzipIn );
	        normalEvent = (NormalEvent) ( inObject.readObject() );
    	} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			if (gzipIn != null) {
				try {gzipIn.close();} catch (IOException ignored) {}
			}
			if (inObject != null) {
				try {inObject.close();} catch (IOException ignored) {}
			}
		}
        return normalEvent;
    }

    public byte[] toBytes () {
    	byte[] result = null;
    	GZIPOutputStream      gzipOut     = null;
        ObjectOutputStream    outObject   = null;
    	try {
	    	ByteArrayOutputStream outBytes    = new ByteArrayOutputStream();
	        gzipOut     = new GZIPOutputStream( outBytes );
	        outObject   = new ObjectOutputStream( gzipOut );
	        outObject.writeObject( this );
	        outObject.close();
	        result =  outBytes.toByteArray();
    	} catch (IOException e) {
    		throw new RuntimeException(e);
		} finally {
			if (gzipOut != null) {
				try {gzipOut.close();} catch (IOException ignored) {}
			}
			if (outObject != null) {
				try {outObject.close();} catch (IOException ignored) {}
			}
		}
    	return result;
    }

    public long getTime() {
        return( timeStamp );
    }

    @Override
    public String toString () {
        if( eventData != null ) {
            return "NormalEvent{" + "deviceId=" + deviceId + ", timeStamp=" + new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format(new Date(timeStamp)) + ", eventType=" + eventType + ", Values:" + Arrays.toString(eventData.toArray()) +'}';
        }
        else {
            return "NormalEvent{" + "deviceId=" + deviceId + ", timeStamp=" + new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format(new Date(timeStamp)) + ", eventType=" + eventType + ", Values:Null"+'}';
        }
    }
}

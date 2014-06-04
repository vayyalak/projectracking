package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * domainModel form of an externally-produced alarm.
 */
public class ExternalAlarm implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long classificationId;
    private long channelId;
    private String alarmName;
    private Date start;
    private Date recognition;
    private Date preEnd;
    private Date end;

    /**
     * Empty-parameter constructor required by GSON serializer.
     */
    public ExternalAlarm() {}

    public long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(long classificationId) {
        this.classificationId = classificationId;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public Date getRecognition() {
        return recognition;
    }

    public void setRecognition(Date recognition) {
        this.recognition = recognition;
    }

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public Date getPreEnd() {
        return preEnd;
    }

    public void setPreEnd(Date preEnd) {
        this.preEnd = preEnd;
    }

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        ExternalAlarm that = (ExternalAlarm)o;

        if (classificationId != that.classificationId) return false;
        if (channelId != that.channelId) return false;
        if (alarmName != null ? !alarmName.equals(that.alarmName) : that.alarmName != null) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (recognition != null ? !recognition.equals(that.recognition) : that.recognition != null) return false;
        if (preEnd != null ? !preEnd.equals(that.preEnd) : that.preEnd != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)(classificationId ^ (classificationId >>> 32));
        result = (31 * result) + (int)(channelId ^ (channelId >>> 32));
        result = (31 * result) + (alarmName != null ? alarmName.hashCode() : 0);
        result = (31 * result) + (start != null ? start.hashCode() : 0);
        result = (31 * result) + (recognition != null ? recognition.hashCode() : 0);
        result = (31 * result) + (preEnd != null ? preEnd.hashCode() : 0);
        result = (31 * result) + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                    "{classificationId=%d, channelId=%d, alarmName=%s, start=%s, recognition=%s, preEnd=%s, end=%s}",
                    classificationId,
                    channelId,
                    alarmName,
                    start == null ? null : Long.toString(start.getTime()),
                    recognition == null ? null : Long.toString(recognition.getTime()),
                    preEnd == null ? null : Long.toString(preEnd.getTime()),
                    end == null ? null : Long.toString(end.getTime())
                    );
    }
}

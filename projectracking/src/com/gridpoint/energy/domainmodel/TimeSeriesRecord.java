package com.gridpoint.energy.domainmodel;

import java.util.Date;
import java.util.TimeZone;

import com.gridpoint.energy.domainmodel.CalcType;

public class TimeSeriesRecord {

    private long channelId;
    private Double val = 0D;
    private Double min = 0D;
    private Double max = 0D;
    private CalcType calcType;
    private Date time;
    private TimeZone timeZone;

    public TimeSeriesRecord() {
    }

    public TimeSeriesRecord(long channelId, Double val, Double min, Double max, CalcType type, Date time, TimeZone timeZone) {
        this.channelId = channelId;
        this.val = val;
        this.min = min;
        this.max = max;
        this.calcType = type;
        this.time = time;
        this.timeZone = timeZone;
        assert ( this.timeZone != null );
    }

    public long getChannelId() {
        return channelId;
    }

    public Double getValue() {
        return val;
    }

    public Double getMaxValue() {
        return max;
    }

    public Double getMinValue() {
        return min;
    }

    public CalcType getCalcType() {
        return calcType;
    }

    public Date getTime() {
        return time;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public void setCalcType(CalcType calcType) {
        this.calcType = calcType;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) ( channelId ^ ( channelId >>> 32 ) );
        result = prime * result + ( ( time == null ) ? 0 : time.hashCode() );
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        TimeSeriesRecord other = (TimeSeriesRecord) obj;
        if (channelId != other.channelId) return false;
        if (time == null) {
            if (other.time != null) return false;
        } else if (!time.equals(other.time)) return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TimeSeriesRecord [calcType=" + calcType + ", channelId=" + channelId + ", localTime=" + time + ", max=" + max + ", min="
                + min + ", timeZone=" + ( timeZone == null ? null : timeZone.getDisplayName() ) + ", utcTime=" + time + ", val=" + val
                + "]";
    }

}

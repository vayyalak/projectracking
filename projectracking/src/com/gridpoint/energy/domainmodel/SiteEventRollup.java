package com.gridpoint.energy.domainmodel;


public class SiteEventRollup {
    private String eventType;
    private long time;
    private long count;

    //GSON constructor
    public SiteEventRollup() {
    }

    public SiteEventRollup(String eventType, long time, long count) {
        this.eventType = eventType;
        this.time = time;
        this.count = count;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteEventRollup that = (SiteEventRollup) o;

        if (count != that.count) return false;
        if (time != that.time) return false;
        if (eventType != null ? !eventType.equals(that.eventType) : that.eventType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventType != null ? eventType.hashCode() : 0;
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (int) (count ^ (count >>> 32));
        return result;
    }
}

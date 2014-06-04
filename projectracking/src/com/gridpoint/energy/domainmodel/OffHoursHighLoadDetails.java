package com.gridpoint.energy.domainmodel;

public class OffHoursHighLoadDetails {
    private long channelId;
    private String channelName;
    private long utcDay;
    private double dayAvgPower;
    private double pastAvgPower;
    private String unit;
    private boolean isOverFactor;
    private boolean isMainLoad;

    public OffHoursHighLoadDetails(long channelId, String channelName, long utcDay, double dayAvgPower, double pastAvgPower, String unit, boolean isOverFactor, boolean isMainLoad) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.utcDay = utcDay;
        this.dayAvgPower = dayAvgPower;
        this.pastAvgPower = pastAvgPower;
        this.unit = unit;
        this.isOverFactor = isOverFactor;
        this.isMainLoad = isMainLoad;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public long getUtcDay() {
        return utcDay;
    }

    public void setUtcDay(long utcDay) {
        this.utcDay = utcDay;
    }

    public double getDayAvgPower() {
        return dayAvgPower;
    }

    public void setDayAvgPower(double dayAvgPower) {
        this.dayAvgPower = dayAvgPower;
    }

    public double getPastAvgPower() {
        return pastAvgPower;
    }

    public void setPastAvgPower(double pastAvgPower) {
        this.pastAvgPower = pastAvgPower;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isOverFactor() {
        return isOverFactor;
    }

    public void setOverFactor(boolean overFactor) {
        isOverFactor = overFactor;
    }

    public boolean isMainLoad() {
        return isMainLoad;
    }

    public void setMainLoad(boolean mainLoad) {
        isMainLoad = mainLoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffHoursHighLoadDetails that = (OffHoursHighLoadDetails) o;

        if (Double.compare(that.dayAvgPower, dayAvgPower) != 0) return false;
        if (channelId != that.channelId) return false;
        if (isMainLoad != that.isMainLoad) return false;
        if (isOverFactor != that.isOverFactor) return false;
        if (Double.compare(that.pastAvgPower, pastAvgPower) != 0) return false;
        if (utcDay != that.utcDay) return false;
        if (channelName != null ? !channelName.equals(that.channelName) : that.channelName != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (int) (channelId ^ (channelId >>> 32));
        result = 31 * result + (channelName != null ? channelName.hashCode() : 0);
        result = 31 * result + (int) (utcDay ^ (utcDay >>> 32));
        return result;
    }
}

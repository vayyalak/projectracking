package com.gridpoint.energy.domainmodel;

public class OffHoursHighLoadInfo {

    private long premisesId;
    private String premisesName;
    private String premisesAddress;
    private String premisesCity;
    private String premisesState;
    private String premisesZipcode;
    private long utcDay;
    private String unit;
    private double dayAvgPower;
    private long pastDays;
    private double pastAvgPower;
    private double pastMinPower;
    private double pastMaxPower;

    public long getPremisesId() {
        return premisesId;
    }

    public void setPremisesId(long premisesId) {
        this.premisesId = premisesId;
    }

    public String getPremisesName() {
        return premisesName;
    }

    public void setPremisesName(String premisesName) {
        this.premisesName = premisesName;
    }

    public String getPremisesAddress() {
        return premisesAddress;
    }

    public void setPremisesAddress(String premisesAddress) {
        this.premisesAddress = premisesAddress;
    }

    public String getPremisesCity() {
        return premisesCity;
    }

    public void setPremisesCity(String premisesCity) {
        this.premisesCity = premisesCity;
    }

    public String getPremisesState() {
        return premisesState;
    }

    public void setPremisesState(String premisesState) {
        this.premisesState = premisesState;
    }

    public String getPremisesZipcode() {
        return premisesZipcode;
    }

    public void setPremisesZipcode(String premisesZipcode) {
        this.premisesZipcode = premisesZipcode;
    }

    public long getUtcDay() {
        return utcDay;
    }

    public void setUtcDay(long utcDay) {
        this.utcDay = utcDay;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getDayAvgPower() {
        return dayAvgPower;
    }

    public void setDayAvgPower(double dayAvgPower) {
        this.dayAvgPower = dayAvgPower;
    }

    public long getPastDays() {
        return pastDays;
    }

    public void setPastDays(long pastDays) {
        this.pastDays = pastDays;
    }

    public double getPastAvgPower() {
        return pastAvgPower;
    }

    public void setPastAvgPower(double pastAvgPower) {
        this.pastAvgPower = pastAvgPower;
    }

    public double getPastMinPower() {
        return pastMinPower;
    }

    public void setPastMinPower(double pastMinPower) {
        this.pastMinPower = pastMinPower;
    }

    public double getPastMaxPower() {
        return pastMaxPower;
    }

    public void setPastMaxPower(double pastMaxPower) {
        this.pastMaxPower = pastMaxPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffHoursHighLoadInfo that = (OffHoursHighLoadInfo) o;

        if (Double.compare(that.dayAvgPower, dayAvgPower) != 0) return false;
        if (Double.compare(that.pastAvgPower, pastAvgPower) != 0) return false;
        if (pastDays != that.pastDays) return false;
        if (Double.compare(that.pastMaxPower, pastMaxPower) != 0) return false;
        if (Double.compare(that.pastMinPower, pastMinPower) != 0) return false;
        if (premisesId != that.premisesId) return false;
        if (utcDay != that.utcDay) return false;
        if (premisesAddress != null ? !premisesAddress.equals(that.premisesAddress) : that.premisesAddress != null)
            return false;
        if (premisesCity != null ? !premisesCity.equals(that.premisesCity) : that.premisesCity != null) return false;
        if (premisesName != null ? !premisesName.equals(that.premisesName) : that.premisesName != null)
            return false;
        if (premisesState != null ? !premisesState.equals(that.premisesState) : that.premisesState != null)
            return false;
        if (premisesZipcode != null ? !premisesZipcode.equals(that.premisesZipcode) : that.premisesZipcode != null)
            return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (premisesId ^ (premisesId >>> 32));
        result = 31 * result + (int) (utcDay ^ (utcDay >>> 32));
        temp = dayAvgPower != +0.0d ? Double.doubleToLongBits(dayAvgPower) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

package com.gridpoint.energy.domainmodel;

public class DeviceOverrideSummary {

    private Long premisesId;
    private String siteName;
    private String location;
    private int sundayOverrides;
    private int mondayOverrides;
    private int tuesdayOverrides;
    private int wednesdayOverrides;
    private int thursdayOverrides;
    private int fridayOverrides;
    private int saturdayOverrides;
    private DeviceOverrideType type;
    private int totalOverrides;
    private double avgOverridesPerDay;

    public DeviceOverrideSummary() {
        this.sundayOverrides = 0;
        this.mondayOverrides = 0;
        this.tuesdayOverrides = 0;
        this.wednesdayOverrides = 0;
        this.thursdayOverrides = 0;
        this.fridayOverrides = 0;
        this.saturdayOverrides = 0;
    }

    public DeviceOverrideSummary(Long premisesId, String siteName, String location, int sundayOverrides, int mondayOverrides,
            int tuesdayOverrides, int wednesdayOverrides, int thursdayOverrides, int fridayOverrides, int saturdayOverrides,
            DeviceOverrideType type, int totalOverrides, double avgOverridesPerDay) {
        this.premisesId = premisesId;
        this.siteName = siteName;
        this.location = location;
        this.sundayOverrides = sundayOverrides;
        this.mondayOverrides = mondayOverrides;
        this.tuesdayOverrides = tuesdayOverrides;
        this.wednesdayOverrides = wednesdayOverrides;
        this.thursdayOverrides = thursdayOverrides;
        this.fridayOverrides = fridayOverrides;
        this.saturdayOverrides = saturdayOverrides;
        this.type = type;
        this.totalOverrides = totalOverrides;
        this.avgOverridesPerDay = avgOverridesPerDay;
    }

    public Long getPremisesId() {
        return premisesId;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getLocation() {
        return location;
    }

    public int getSundayOverrides() {
        return sundayOverrides;
    }

    public int getMondayOverrides() {
        return mondayOverrides;
    }

    public int getTuesdayOverrides() {
        return tuesdayOverrides;
    }

    public int getWednesdayOverrides() {
        return wednesdayOverrides;
    }

    public int getThursdayOverrides() {
        return thursdayOverrides;
    }

    public int getFridayOverrides() {
        return fridayOverrides;
    }

    public int getSaturdayOverrides() {
        return saturdayOverrides;
    }

    public DeviceOverrideType getType() {
        return type;
    }

    public int getTotalOverrides() {
        return totalOverrides;
    }

    public double getAvgOverridesPerDay() {
        return avgOverridesPerDay;
    }

    public void setPremisesId(Long premisesId) {
        this.premisesId = premisesId;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSundayOverrides(int sundayOverrides) {
        this.sundayOverrides = sundayOverrides;
    }

    public void setMondayOverrides(int mondayOverrides) {
        this.mondayOverrides = mondayOverrides;
    }

    public void setTuesdayOverrides(int tuesdayOverrides) {
        this.tuesdayOverrides = tuesdayOverrides;
    }

    public void setWednesdayOverrides(int wednesdayOverrides) {
        this.wednesdayOverrides = wednesdayOverrides;
    }

    public void setThursdayOverrides(int thursdayOverrides) {
        this.thursdayOverrides = thursdayOverrides;
    }

    public void setFridayOverrides(int fridayOverrides) {
        this.fridayOverrides = fridayOverrides;
    }

    public void setSaturdayOverrides(int saturdayOverrides) {
        this.saturdayOverrides = saturdayOverrides;
    }

    public void setType(DeviceOverrideType type) {
        this.type = type;
    }

    public void setTotalOverrides(int totalOverrides) {
        this.totalOverrides = totalOverrides;
    }

    public void setAvgOverridesPerDay(double avgOverridesPerDay) {
        this.avgOverridesPerDay = avgOverridesPerDay;
    }

}

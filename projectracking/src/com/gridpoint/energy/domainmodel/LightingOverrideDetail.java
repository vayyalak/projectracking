package com.gridpoint.energy.domainmodel;

public class LightingOverrideDetail {

    private final long premisesId;
    private final String siteName;
    private final String location;
    private final String time;
    private final String description;
    private final String zoneName;
    private final double durationHours;

    public LightingOverrideDetail(long premisesId, String siteName, String location, String time, String description, String zoneName, double durationHours) {
        this.premisesId = premisesId;
        this.siteName = siteName;
        this.location = location;
        this.time = time;
        this.description = description;
        this.zoneName = zoneName;
        this.durationHours = durationHours;
    }

    public long getPremisesId() {
        return premisesId;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }
    
    public String getDescription() {
        return description;
    }

    public String getZoneName() {
        return zoneName;
    }

    public double getDurationHours() {
        return durationHours;
    }

}

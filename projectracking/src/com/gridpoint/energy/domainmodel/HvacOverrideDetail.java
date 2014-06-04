package com.gridpoint.energy.domainmodel;

public class HvacOverrideDetail {

    private long premisesId;
    private String siteName;
    private String location;
    private String date;
    private Double manualHeat;
    private Double configuredHeat;
    private Double manualCool;
    private Double configuredCool;
    private Integer unitNumber;
    private String channelName;
    private String description;

    public HvacOverrideDetail() {}
    
    public HvacOverrideDetail(long premisesId, String siteName, String location, String date, Integer unitNumber, String channelName, String description) {
        this.premisesId = premisesId;
        this.siteName = siteName;
        this.location = location;
        this.date = date;
        this.unitNumber = unitNumber;
        this.channelName = channelName;
        this.description = description;
    }
    
    public HvacOverrideDetail(long premisesId, String siteName, String location, String date, Double manualHeat, Double configuredHeat,
            Double manualCool, Double configuredCool, Integer unitNumber, String channelName, String description) {
        this.premisesId = premisesId;
        this.siteName = siteName;
        this.location = location;
        this.date = date;
        this.manualHeat = manualHeat;
        this.configuredHeat = configuredHeat;
        this.manualCool = manualCool;
        this.configuredCool = configuredCool;
        this.unitNumber = unitNumber;
        this.channelName = channelName;
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public Double getManualHeat() {
        return manualHeat;
    }

    public Double getConfiguredHeat() {
        return configuredHeat;
    }

    public Double getManualCool() {
        return manualCool;
    }

    public Double getConfiguredCool() {
        return configuredCool;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getDescription() {
        return description;
    }

    public void setPremisesId(long premisesId) {
        this.premisesId = premisesId;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setManualHeat(Double manualHeat) {
        this.manualHeat = manualHeat;
    }

    public void setConfiguredHeat(Double configuredHeat) {
        this.configuredHeat = configuredHeat;
    }

    public void setManualCool(Double manualCool) {
        this.manualCool = manualCool;
    }

    public void setConfiguredCool(Double configuredCool) {
        this.configuredCool = configuredCool;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( date == null ) ? 0 : date.hashCode() );
        result = prime * result + ( ( siteName == null ) ? 0 : siteName.hashCode() );
        result = prime * result + ( ( unitNumber == null ) ? 0 : unitNumber.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        HvacOverrideDetail other = (HvacOverrideDetail) obj;
        if (date == null) {
            if (other.date != null) return false;
        } else if (!date.equals(other.date)) return false;
        if (siteName == null) {
            if (other.siteName != null) return false;
        } else if (!siteName.equals(other.siteName)) return false;
        if (unitNumber == null) {
            if (other.unitNumber != null) return false;
        } else if (!unitNumber.equals(other.unitNumber)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "HvacOverrideDetail [premisesId=" + premisesId + ", date=" + date + ", unitNumber=" + unitNumber + ", channelName="
                + channelName + "]";
    }
    
    
}

package com.gridpoint.energy.domainmodel;

import java.util.Date;

import com.gridpoint.energy.util.json.GsonIgnoredField;
import com.gridpoint.energy.util.json.ReportField;

public class TabularEnergySession {

    @ReportField(title = "Device ID", position = 1)
    private Long deviceId;

    @ReportField(title = "Device Name", position = 2)
    private String deviceName;

    @ReportField(title = "Site Name", position = 3)
    private String siteName;

    @ReportField(title = "Start Time", position = 4)
    private String startTime;

    @ReportField(title = "End Time", position = 5)
    private String endTime;

    @ReportField(title = "Net Energy", position = 6)
    private String netEnergy;

    @ReportField(title = "Session ID", position = 7)
    private Long sessionId;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    @ReportField(title = "State", position = 8)
    private String state;

    @GsonIgnoredField
    private Date startDate;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNetEnergy() {
        return netEnergy;
    }

    public void setNetEnergy(String netEnergy) {
        this.netEnergy = netEnergy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

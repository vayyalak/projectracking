package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.json.ReportField;
import com.gridpoint.energy.util.json.ReportField.Justification;

public class AlarmReportDetail {

    @ReportField(title = "Site ID", position = 1, justification = Justification.LEFT)
    private String siteId;
    
    @ReportField(title = "Site Name", position = 2, justification = Justification.LEFT)
    private String siteName;

    @ReportField(title = "Alarm Name", position = 3, justification = Justification.LEFT)
    private String alarmName;

    @ReportField(title = "Alarm Id", position = 4, justification = Justification.LEFT)
    private Long alarmId;

    @ReportField(title = "Device Name", position = 5, justification = Justification.LEFT)
    private String device;

    @ReportField(title = "Device Id", position = 6, justification = Justification.LEFT)
    private Long deviceId;

    @ReportField(title = "Channel Name", position = 7, justification = Justification.LEFT)
    private String channelName;

    @ReportField(title = "Channel Id", position = 8, justification = Justification.LEFT)
    private Long channelId;
    
    @ReportField(title = "Threshold", position = 9, justification = Justification.LEFT)
    private String threshold;
    
    @ReportField(title = "Data Category", position = 10, justification = Justification.LEFT)
    private String dataCategory;
    
    @ReportField(title = "Comment", position = 11, justification = Justification.LEFT)
    private String comment;
    
    @ReportField(title = "Start Date", position = 12, justification = Justification.LEFT)
    private String startDate;

    @ReportField(title = "Close Date", position = 13, justification = Justification.LEFT)
    private String closeDate;

    @ReportField(title = "Duration", position = 14, justification = Justification.LEFT)
    private String duration;

    @ReportField(title = "State", position = 15, justification = Justification.LEFT)
    private String state;

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    public String getSiteId() {
        return siteId;
    }

    
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    
    public String getThreshold() {
        return threshold;
    }

    
    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    
    public String getDataCategory() {
        return dataCategory;
    }

    
    public void setDataCategory(String dataCategory) {
        this.dataCategory = dataCategory;
    }

    
    public String getComment() {
        return comment;
    }

    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
}

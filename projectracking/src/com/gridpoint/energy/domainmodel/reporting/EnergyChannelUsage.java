package com.gridpoint.energy.domainmodel.reporting;

import java.util.Date;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;

public class EnergyChannelUsage {

    private String siteId;
    private String siteName;
    private Date commissionDate;
    private DateTZ startDate;
    private DateTZ endDate;
    private String channelType;
    private String channelName;
    private Integer subChannelCount;

    private Double peakDemand;
    private DateTZ peakOccurrence;

    private DateTZ coincidentPeakOccurrence;
    private Double coincidentPeak;
    private String peakUnit = "kW";
    private Double percentOfTotalPeak;

    private Double totalUsage;
    private Double avgDailyUsage;
    private String totalUsageUnit = "kWh";
    private Double percentOfTotalUsage;

    private Double area;
    private String areaUnit = "SQFT";
    private Double dailyUsagePerArea;

    private Integer daysInMonth;
    private Integer totalDays;
    private Integer totalIntervals;
    private Integer missingIntervals = 0;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Date getCommissionDate() {
        return commissionDate;
    }

    public void setCommissionDate(Date commissionDate) {
        this.commissionDate = commissionDate;
    }

    public DateTZ getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTZ startDate) {
        this.startDate = startDate;
    }

    public DateTZ getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTZ endDate) {
        this.endDate = endDate;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getSubChannelCount() {
        return subChannelCount;
    }

    public void setSubChannelCount(Integer subChannelCount) {
        this.subChannelCount = subChannelCount;
    }

    public Double getPeakDemand() {
        return peakDemand;
    }

    public void setPeakDemand(Double peakDemand) {
        this.peakDemand = peakDemand;
    }

    public DateTZ getPeakOccurrence() {
        return peakOccurrence;
    }

    public void setPeakOccurrence(DateTZ peakOccurrence) {
        this.peakOccurrence = peakOccurrence;
    }

    public DateTZ getCoincidentPeakOccurrence() {
        return coincidentPeakOccurrence;
    }

    public void setCoincidentPeakOccurrence(DateTZ coincidentPeakOccurrence) {
        this.coincidentPeakOccurrence = coincidentPeakOccurrence;
    }

    public Double getCoincidentPeak() {
        return coincidentPeak;
    }

    public void setCoincidentPeak(Double coincidentPeak) {
        this.coincidentPeak = coincidentPeak;
    }

    public String getPeakUnit() {
        return peakUnit;
    }

    public void setPeakUnit(String peakUnit) {
        this.peakUnit = peakUnit;
    }

    public Double getPercentOfTotalPeak() {
        return percentOfTotalPeak;
    }

    public void setPercentOfTotalPeak(Double percentOfTotalPeak) {
        this.percentOfTotalPeak = percentOfTotalPeak;
    }

    public Double getTotalUsage() {
        return totalUsage;
    }

    public void setTotalUsage(Double totalUsage) {
        this.totalUsage = totalUsage;
    }

    public Double getAvgDailyUsage() {
        return avgDailyUsage;
    }

    public void setAvgDailyUsage(Double avgDailyUsage) {
        this.avgDailyUsage = avgDailyUsage;
    }

    public String getTotalUsageUnit() {
        return totalUsageUnit;
    }

    public void setTotalUsageUnit(String totalUsageUnit) {
        this.totalUsageUnit = totalUsageUnit;
    }

    public Double getPercentOfTotalUsage() {
        return percentOfTotalUsage;
    }

    public void setPercentOfTotalUsage(Double percentOfTotalUsage) {
        this.percentOfTotalUsage = percentOfTotalUsage;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getAreaUnit() {
        return areaUnit;
    }

    public void setAreaUnit(String areaUnit) {
        this.areaUnit = areaUnit;
    }

    public Double getDailyUsagePerArea() {
        return dailyUsagePerArea;
    }

    public void setDailyUsagePerArea(Double dailyUsagePerArea) {
        this.dailyUsagePerArea = dailyUsagePerArea;
    }

    public Integer getDaysInMonth() {
        return daysInMonth;
    }

    public void setDaysInMonth(Integer daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Integer getTotalIntervals() {
        return totalIntervals;
    }

    public void setTotalIntervals(Integer totalIntervals) {
        this.totalIntervals = totalIntervals;
    }

    public Integer getMissingIntervals() {
        return missingIntervals;
    }

    public void setMissingIntervals(Integer missingIntervals) {
        this.missingIntervals = missingIntervals;
    }

}

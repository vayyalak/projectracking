package com.gridpoint.energy.domainmodel;

import java.util.Date;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;


public class SolarSummary {

	private String siteName;
	private Double peakProduction = 0.0;
	private DateTZ solarPeakOccurrence;
	private Double peakMainLoad = 0.0;
	private DateTZ mainPeakOccurence;
	private Double totalGeneration = 0.0;
	private Double totalUsage = 0.0;
	private String siteId;
    private Date startDate;
    private Date endDate;
    private Date commissionDate;
    private String address;
    private String city;
    private String state;
    private Long premisesId;
    private Integer missingIntervals = 0;
    private Integer foundIntervals = 0;
    private Integer channelCount = 0;
    private String channelName;
    private Double percentOfTotalPeak;
    private Double coincidentPeak;
	
	public Integer getChannelCount() {
		return channelCount;
	}

	public void setChannelCount(Integer channelCount) {
		this.channelCount = channelCount;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Double getPeakProduction() {
		return peakProduction;
	}

	public void setPeakProduction(Double peakProduction) {
		this.peakProduction = peakProduction;
	}
	
	public Double getPeakMainLoad() {
		return peakMainLoad;
	}

	public void setPeakMainLoad(Double peakMainLoad) {
		this.peakMainLoad = peakMainLoad;
	}

	public DateTZ getMainPeakOccurence() {
		return mainPeakOccurence;
	}

	public void setMainPeakOccurence(DateTZ mainPeakOccurence) {
		this.mainPeakOccurence = mainPeakOccurence;
	}

	public DateTZ getSolarPeakOccurrence() {
		return solarPeakOccurrence;
	}

	public void setSolarPeakOccurrence(DateTZ solarPeakOccurrence) {
		this.solarPeakOccurrence = solarPeakOccurrence;
	}

	public Double getTotalGeneration() {
		return totalGeneration;
	}

	public void setTotalGeneration(Double totalGeneration) {
		this.totalGeneration = totalGeneration;
	}

	public Double getTotalUsage() {
		return totalUsage;
	}

	public void setTotalUsage(Double totalUsage) {
		this.totalUsage = totalUsage;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteId() {
		return siteId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCommissionDate() {
		return commissionDate;
	}

	public void setCommissionDate(Date commissionDate) {
		this.commissionDate = commissionDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPremisesId() {
		return premisesId;
	}

	public void setPremisesId(Long premisesId) {
		this.premisesId = premisesId;
	}

	public Integer getMissingIntervals() {
		return missingIntervals;
	}

	public void setMissingIntervals(Integer missingIntervals) {
		this.missingIntervals = missingIntervals;
	}

	public Integer getFoundIntervals() {
		return foundIntervals;
	}

	public void setFoundIntervals(Integer foundIntervals) {
		this.foundIntervals = foundIntervals;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Double getPercentOfTotalPeak() {
		return percentOfTotalPeak;
	}

	public void setPercentOfTotalPeak(Double percentOfTotalPeak) {
		this.percentOfTotalPeak = percentOfTotalPeak;
	}

	public Double getCoincidentPeak() {
		return coincidentPeak;
	}

	public void setCoincidentPeak(Double coincidentPeak) {
		this.coincidentPeak = coincidentPeak;
	}

}

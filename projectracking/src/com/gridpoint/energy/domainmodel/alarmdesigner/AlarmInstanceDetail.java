package com.gridpoint.energy.domainmodel.alarmdesigner;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class AlarmInstanceDetail{
	
	private static final AtomicLong atomicCounter = new AtomicLong(0);

    private Long siteId;
    
    private String siteName; // "name" in database, displayed site id
    
    private String displayedSiteName; // "discription" in database
    
    private String province;
    
    private String city;
    
    private String address;

    private Collection<Long> channelIds;
    
    private Collection<String> channelNames;

    private Date startTime;

    private Date endTime; //The exact timestamp where close condition is triggered
    
    private Date archiveTime;
    
    private Status status;
    
    private Long tempInstanceId;
    
    private TimeZone timezone;
    
    public enum Status{
        DETECTED{
        	@Override
            public String toString() {
                return "Detected";
            }
        },     //When opened but not yet satisfying FOR clause
        PENDING_OPEN{
        	@Override
            public String toString() {
                return "Pending Open";
            }
        },    //Detected but CLEAR clause satisfied before FOR clause
        ALARMING{
        	@Override
            public String toString() {
                return "Alarming";
            }
        },     //After FOR clause satisfied
        CLEARED{
        	@Override
            public String toString() {
                return "Closed";
            }
        },       //CLEAR clause conditions met and time enough
        PENDING_CLOSE{
        	@Override
            public String toString() {
                return "Pending Close";
            }
        }; //CLEAR clause conditions met but time not enough
        
    }

	public AlarmInstanceDetail() {
		super();
	}
	
	

	public AlarmInstanceDetail(String displayedSiteName, String province,
			String city, String address, TimeZone timezone) {
		super();
		this.displayedSiteName = displayedSiteName;
		this.province = province;
		this.city = city;
		this.address = address;
		this.timezone = timezone;
	}



	//constructor for an instance, designed to be used by a group instance
	//through createInstanceFromGroup() method
	public AlarmInstanceDetail(Long siteId, String siteName,
			Collection<Long> channelIds, Collection<String> channelNames,
			Date startTime, Status status, Long tempInstanceId, String displayedSiteName, String province,
			String city, String address, TimeZone timezone) {
		this();
		this.siteId = siteId;
		this.siteName = siteName;
		this.channelIds = channelIds;
		this.channelNames = channelNames;
		this.startTime = startTime;
		this.status = status;
		this.tempInstanceId = tempInstanceId;
		this.displayedSiteName = displayedSiteName;
		this.province = province;
		this.city = city;
		this.address = address;
		this.timezone = timezone;
	}
	
	//constructor for a group
	public AlarmInstanceDetail(Long siteId, String siteName,
			Collection<Long> channelIds, Collection<String> channelNames, String displayedSiteName, String province,
			String city, String address, TimeZone timezone) {
		this();
		this.siteId = siteId;
		this.siteName = siteName;
		this.channelIds = channelIds;
		this.channelNames = channelNames;
		this.tempInstanceId = atomicCounter.incrementAndGet();
		this.displayedSiteName = displayedSiteName;
		this.province = province;
		this.city = city;
		this.address = address;
		this.timezone = timezone;

	}
	
	//constructor for archiving
	public AlarmInstanceDetail(Long siteId, String siteName,
			Collection<Long> channelIds, Collection<String> channelNames,
			Date startTime, Date endTime, Date archiveTime, Status status,
			Long tempInstanceId, String displayedSiteName, String province,
			String city, String address, TimeZone timezone) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.channelIds = channelIds;
		this.channelNames = channelNames;
		this.startTime = startTime;
		this.endTime = endTime;
		this.archiveTime = archiveTime;
		this.status = status;
		this.tempInstanceId = tempInstanceId;
		this.displayedSiteName = displayedSiteName;
		this.province = province;
		this.city = city;
		this.address = address;
		this.timezone = timezone;

	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getDisplayedSiteName() {
		return displayedSiteName;
	}

	public void setDisplayedSiteName(String displayedSiteName) {
		this.displayedSiteName = displayedSiteName;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTempInstanceId(Long tempInstanceId) {
		this.tempInstanceId = tempInstanceId;
	}

	public Collection<Long> getChannelIds() {
		return channelIds;
	}

	public void setChannelIds(Collection<Long> channelIds) {
		this.channelIds = channelIds;
	}

	public Collection<String> getChannelNames() {
		return channelNames;
	}

	public void setChannelNames(Collection<String> channelNames) {
		this.channelNames = channelNames;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Date getArchiveTime() {
		return archiveTime;
	}

	public void setArchiveTime(Date archiveTime) {
		this.archiveTime = archiveTime;
	}

	public Date getStatusEndTime() {
		switch (status){
		case PENDING_OPEN:
			return getArchiveTime();
		case PENDING_CLOSE:
			return getArchiveTime();
		default: 
			return getEndTime();
		}
	}
	
	public Calendar getStatusEndCalendar(){
		return convertByTimeZone(getStatusEndTime());
	}
	
	public Date getStatusStartTime(){
		switch (status){
		case PENDING_CLOSE:
			return getEndTime();
		default: 
			return getStartTime();
		}
	}
	
	public Calendar getStatusStartCalendar(){
		return convertByTimeZone(getStatusStartTime());
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TimeZone getTimezone() {
		return timezone;
	}


	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}


	public Long getTempInstanceId() {
		return tempInstanceId;
	}

	public String getDuration(){
		switch (status){
		case CLEARED: 
			return format((this.getEndTime().getTime()-this.getStartTime().getTime())/1000);
		case PENDING_OPEN:
			return format((this.getStatusEndTime().getTime()-this.getStartTime().getTime())/1000);
		case PENDING_CLOSE:
			return format((this.getStatusEndTime().getTime()-this.getEndTime().getTime())/1000);
		default: 
			return "";
		}
	}
	
	public String displayChannels(){
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		for(String name:new LinkedHashSet<String>(channelNames)){
			if(!first)sb.append(", ");
			first = false;
			sb.append(name);
		}
		return sb.toString();
	}
	
	public String displayStatus(){
		return this.status.toString();
	}
	
	private String format(long durationInSec){
		return String.format("%d:%02d:%02d", durationInSec/3600, (durationInSec%3600)/60, (durationInSec%60));
	}
	
	public AlarmInstanceDetail cloneAsArchive(Date archiveTime){
		AlarmInstanceDetail clonedInstance = new AlarmInstanceDetail(this.siteId, this.siteName,
				this.channelIds, this.channelNames,
				this.startTime, this.endTime, archiveTime, this.status, this.tempInstanceId, 
				this.displayedSiteName, this.province, this.city, this.address, this.timezone);
		return clonedInstance;
	}
	
	public AlarmInstanceDetail createInstanceFromGroup(Date startTime, Status status){
		AlarmInstanceDetail clonedInstance = new AlarmInstanceDetail(this.siteId, this.siteName,
				this.channelIds, this.channelNames,
				startTime, status, this.tempInstanceId, 
				this.displayedSiteName, this.province, this.city, this.address, this.timezone);
		return clonedInstance;
	}
	
	private Calendar convertByTimeZone(Date date){
		Calendar calendar = Calendar.getInstance(this.getTimezone());
		calendar.setTime(date);
		return calendar;
	}
}

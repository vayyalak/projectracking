package com.gridpoint.energy.domainmodel;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;
import com.gridpoint.energy.domainmodel.monetization.MonetaryAmount;

public class AlarmDetail implements Comparable<AlarmDetail> {

    private Long alarmId;
    
    private String alarmName;

    private String channelName;

    private String channelDisplayName;

    private String dataType;

    private String dataTypeName;

    private Long premisesId;

    private Long channelId;

    private List<Long> channelIds;
    
    private Long endpointId;

    private Long deviceId;

    private String deviceName;

    private String timeZone;

    private MonetaryAmount monetaryAmount;
    
    private Double threshold;

    private String triggerCondition;
    
    private String closeCondition;
    
    private boolean isNewAlarm;
    
    private String interval;
    
    private Long duration;
    
    public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getInterval(){
    	return interval;
    }
    
    public void setInterval(String interval){
    	this.interval = interval;
    }

    public boolean isNewAlarm() {
		return isNewAlarm;
	}

	public void setNewAlarm(boolean isNewAlarm) {
		this.isNewAlarm = isNewAlarm;
	}

	public List<Long> getChannelIds() {
		return channelIds;
	}

	public void setChannelIds(List<Long> channelIds) {
		this.channelIds = channelIds;
	}

	public String getTriggerCondition() {
		return triggerCondition;
	}

	public void setTriggerCondition(String triggerCondition) {
		this.triggerCondition = triggerCondition;
	}

	public String getCloseCondition() {
		return closeCondition;
	}

	public void setCloseCondition(String closeCondition) {
		this.closeCondition = closeCondition;
	}

	private DateTZ start;

    private DateTZ end;

    /**
     * comments about the alarm used to clarifying its meaning.  These are typically set by the processes that log alarms but may have been modified by data analysts and Enterprise Manager users.
     */
    private String alarmComment;

    /**
     * Default GSON constructor. Needed
     */
    public AlarmDetail() {
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDisplayName() {
        return channelDisplayName;
    }

    public void setChannelDisplayName(String channelDisplayName) {
        this.channelDisplayName = channelDisplayName;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public MonetaryAmount getMonetaryAmount() {
        return monetaryAmount;
    }

    public void setMonetaryAmount(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

    public void setPremisesId(Long premisesId) {
        this.premisesId = premisesId;
    }

    public Long getPremisesId() {
        return premisesId;
    }

    public void setEndpointId(Long endpointId) {
        this.endpointId = endpointId;
    }

    public Long getEndpointId() {
        return endpointId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public DateTZ getStart() {
        return start;
    }

    public void setStart(DateTZ start) {
        this.start = start;
    }

    public DateTZ getEnd() {
        return end;
    }

    public void setEnd(DateTZ end) {
        this.end = end;
    }
        
    public Long getAlarmId() {
        return alarmId;
    }
    
    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    /**
     * Gets comments about the alarm used to clarifying its meaning.  These are typically set by the processes that log alarms but may have been modified by data analysts and Enterprise Manager users.
     * @return comments about the alarm used to clarifying its meaning
     */
    public String getAlarmComment() {
        return alarmComment;
    }

    /**
     * Sets comments about the alarm used to clarifying its meaning.  These are typically set by the processes that log alarms but may have been modified by data analysts and Enterprise Manager users.
     * @param alarmComment comments about the alarm used to clarifying its meaning
     */
    public void setAlarmComment(String alarmComment) {
        this.alarmComment = alarmComment;
    }
    
    public String displayChannelIds(){
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		if(null==getChannelIds()){
			sb.append(this.getChannelId());
		}
		else{
	    	for(long id : getChannelIds()){
				if(!first)sb.append(", ");
				first = false;
				sb.append(id);
			}
		}
		return sb.toString();
    }

    @Override
    public int compareTo(AlarmDetail o) {

        if (getEnd() == null) {
            if (o.getEnd() != null) {
                return -1;
            }
        }

        if (o.getEnd() == null) {
            if (getEnd() != null) {
                return 1;
            }
        }

        return -( getStart().compareTo(o.getStart()) );
    }

}

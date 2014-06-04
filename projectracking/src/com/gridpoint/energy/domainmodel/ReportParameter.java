package com.gridpoint.energy.domainmodel;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * An instance of a parameter to pass to a report.
 * @author mrochon
 *
 */
public class ReportParameter {
    static final String INTERVAL = "interval";
    static final String START_TIME = "startTime";
    static final String END_TIME = "endTime";
    static final String END_TIME_END = "cDateE";
    static final String START_TIME_END = "sDateE";
    static final String START_TIME_BEGIN = "sDateB";
    static final String END_TIME_BEGIN = "cDateB";
    static final String THRESHOLD = "threshold";
    static final String PREMISES_IDS = "premisesIds";
    static final String PREMISES_LIST = "premisesList";
    static final String QUERY_ID = "queryId";
    static final String ALARM_ID = "alarmId";
    static final String ALARM_TYPE = "alarmType";
    static final String ACTIVE_ALARMS = "useActiveAlarms";
    static final String CLOSED_ALARMS = "useClosedAlarms";
    static final String EXCEPTION_REPORTS = "useExceptionReports";
    static final String GROUP_SUMMARY = "reportSummary";
    static final String EXPORT_ALARMS = "reportAlarms";
    static final String EXPORT_EXCEPTIONS = "reportExceptions";
    static final String STATE = "state";
    static final String ALARM_NAME = "alarmName";
    
    static final String INCLUDE_SITE_HOURS = "includeSiteHours";
    static final String INCLUDE_HOLIDAY_SCHEDULES = "includeHolidaySchedules";
    static final String INCLUDE_LIGHTING_SCHEDULES = "includeLightingSchedules";
    static final String INCLUDE_HVAC_SCHEDULES = "includeHvacSchedules";
    static final String INCLUDE_CONFIG_HISTORY = "includeConfigHistory";
    static final String IS_DAILY_DETAIL = "dailyDetail";
    static final String IS_DAILY_CHANNELS = "dailyChannels";
    static final String IS_DAILY_CHANNELS_FOR_SOLAR = "dailyChannelsForSolar";
    
    private String name;
	
	private ReportParameterType type;
	
	private Object value;
	
	public ReportParameter() {}
	
	public ReportParameter(String name, Object value) {
		this.name = name;
		this.setValue(value);
	}
	
	public ReportParameter(String name, Object value, ReportParameterType type) {
	    this.name = name;
	    this.value = value;
	    this.type = type;
	}

	@JsonIgnore
	public boolean isDailyInterval(){
	    return isInterval() && (Interval.DAY == Interval.valueOf(String.valueOf(value)));
	}

    @JsonIgnore
	public boolean isInterval(){
	    return INTERVAL.equals(this.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setType(ReportParameterType type) {
		this.type = type;
	}

	public ReportParameterType getType() {
		return type;
	}

}

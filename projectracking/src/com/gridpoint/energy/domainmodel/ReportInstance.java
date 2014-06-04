package com.gridpoint.energy.domainmodel;

import static com.gridpoint.energy.domainmodel.AlarmStateFilterType.ALL;
import static com.gridpoint.energy.domainmodel.AlarmStateFilterType.CLOSED;
import static com.gridpoint.energy.domainmodel.AlarmStateFilterType.OPEN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.gridpoint.energy.domainmodel.reporting.AlarmsAndExceptionsReportParameters;
import com.gridpoint.energy.domainmodel.reporting.AlarmsReportParameters;
import com.gridpoint.energy.domainmodel.reporting.DailyEnergy3TableReportParameters;
import com.gridpoint.energy.domainmodel.reporting.DeviceOverrideReportParameters;
import com.gridpoint.energy.domainmodel.reporting.ExceptionReportParameters;
import com.gridpoint.energy.domainmodel.reporting.SolarTableReportParameters;
import com.gridpoint.energy.domainmodel.reporting.VoltageImbalanceReportParameters;
import com.gridpoint.energy.domainmodel.reporting.SiteSchedulesReportParameters;
import com.gridpoint.energy.util.date.LocalDateTime;

/**
 * An instance of a report to run.
 * 
 * @author mrochon
 * 
 */
public class ReportInstance {

    private String name;

    private String type;
    private String path;

    private List<ReportParameter> params = new ArrayList<ReportParameter>();

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void addParams(ReportParameter param) {
        this.params.add(param);
    }

    public List<ReportParameter> getParams() {
        return params;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public <T> T getReportParam(String param, Class<T> type) {
        for (ReportParameter reportParam : this.getParams()) {
            String paramName = reportParam.getName();
            boolean matchingNames = param.equals(paramName);
            Object paramValue = reportParam.getValue();
            boolean matchingTypes = type.isInstance(paramValue);
            if (matchingNames && matchingTypes) {
                T result = type.cast(reportParam.getValue());
                return result;
            }
        }
        return null;
    }

    @JsonIgnore
    public Long getStartTime() {
        Long startTime = getReportParam(ReportParameter.START_TIME, Long.class);
        return startTime;
    }

    @JsonIgnore
    private LocalDateTime getLocalDateTimeFor(String paramName){
        /*
         * TODO: DWC- Are we using the ReportParameter.TYPE field for anything?
         */
        LocalDateTime ldt = getReportParam(paramName, LocalDateTime.class);
        if(null == ldt){
            String ldtStr = getReportParam(paramName, String.class);
            if(null != ldtStr){
                ldt = LocalDateTime.valueOf(ldtStr);
            } else {
                Long ldtLong = getReportParam(paramName, Long.class);
                if(null != ldtLong){
                    ldt = LocalDateTime.forUtc(ldtLong);
                }
            }
        }
        return ldt;
    }

    @JsonIgnore
    public LocalDateTime getStartLocalDateTime() {
        LocalDateTime startLocalDateTime = getLocalDateTimeFor(ReportParameter.START_TIME);
        return startLocalDateTime;
    }

    @JsonIgnore
    public Long getEndTime() {
        Long endTime = getReportParam(ReportParameter.END_TIME, Long.class);
        return endTime;
    }

    @JsonIgnore
    public LocalDateTime getEndLocalDateTime() {
        LocalDateTime endLocalDateTime = getLocalDateTimeFor(ReportParameter.END_TIME);
        return endLocalDateTime;
    }

    @JsonIgnore
    public Long getQueryId() {
        Long queryId = getReportParam(ReportParameter.QUERY_ID, Long.class);
        return queryId;
    }

    @JsonIgnore
    public List<Long> getPremisesIds() {
        @SuppressWarnings("unchecked")
        List<Long> premisesIds = getReportParam(ReportParameter.PREMISES_IDS, List.class);

        if (null == premisesIds) {
            @SuppressWarnings("unchecked")
            List<Long> premisesIdsList = getReportParam(ReportParameter.PREMISES_LIST, List.class);
            premisesIds = premisesIdsList;

            if (null == premisesIds) {
                return Collections.emptyList();
            }
        }
        return premisesIds;
    }

    @JsonIgnore
    public String getAlarmId() {
        String alarmId = getReportParam(ReportParameter.ALARM_ID, String.class);
        return alarmId;
    }

    @JsonIgnore
    public String getAlarmType() {
        String alarmType = getReportParam(ReportParameter.ALARM_TYPE, String.class);
        return alarmType;
    }

    @JsonIgnore
    public String getState() {
        String state = getReportParam(ReportParameter.STATE, String.class);
        return state;
    }

    @JsonIgnore
    public String getAlarmName() {
        String alarmName = getReportParam(ReportParameter.ALARM_NAME, String.class);
        return alarmName;
    }

    @JsonIgnore
    public String getEndTimeEnd() {
        String endTimeEnd = getReportParam(ReportParameter.END_TIME_END, String.class);
        return endTimeEnd;
    }

    @JsonIgnore
    public String getStartTimeEnd() {
        String startTimeEnd = getReportParam(ReportParameter.START_TIME_END, String.class);
        return startTimeEnd;
    }

    @JsonIgnore
    public String getEndTimeBegin() {
        String endTimeBegin = getReportParam(ReportParameter.END_TIME_BEGIN, String.class);
        return endTimeBegin;
    }

    @JsonIgnore
    public String getStartTimeBegin() {
        String startTimeBegin = getReportParam(ReportParameter.START_TIME_BEGIN, String.class);
        return startTimeBegin;
    }

    @JsonIgnore
    public Double getThreshold() {
        Double threshold = getReportParam(ReportParameter.THRESHOLD, Double.class);
        return threshold;
    }

    @JsonIgnore
    public boolean isUseActiveAlarms() {
        Boolean activeAlarms = getReportParam(ReportParameter.ACTIVE_ALARMS, Boolean.class);
        if(null == activeAlarms){
            String stateStr = getReportParam(ReportParameter.STATE, String.class);
            if(ALL.hasValue(stateStr) || OPEN.hasValue(stateStr)){
                activeAlarms = Boolean.TRUE;
            }
        }
        return falseIfNull(activeAlarms);
    }

    @JsonIgnore
    public boolean isUseClosedAlarms() {
        Boolean closedAlarms = getReportParam(ReportParameter.CLOSED_ALARMS, Boolean.class);
        if(null == closedAlarms){
            String stateStr = getReportParam(ReportParameter.STATE, String.class);
            if(ALL.hasValue(stateStr) || CLOSED.hasValue(stateStr)){
                closedAlarms = Boolean.TRUE;
            }
        }
        return falseIfNull(closedAlarms);
    }

    @JsonIgnore
    private boolean isUseExceptionReports() {
        Boolean exceptionReports = getReportParam(ReportParameter.EXCEPTION_REPORTS, Boolean.class);
        return falseIfNull(exceptionReports);
    }

    @JsonIgnore
    private boolean isGroupSummary() {
        Boolean groupSummary = getReportParam(ReportParameter.GROUP_SUMMARY, Boolean.class);
        return falseIfNull(groupSummary);
    }

    @JsonIgnore
    private boolean isExportExceptions() {
        Boolean isExportExceptions = getReportParam(ReportParameter.EXPORT_EXCEPTIONS, Boolean.class);
        return falseIfNull(isExportExceptions);
    }

    @JsonIgnore
    private boolean isExportAlarms() {
        Boolean isExportAlarms = getReportParam(ReportParameter.EXPORT_ALARMS, Boolean.class);
        return falseIfNull(isExportAlarms);
    }

    @JsonIgnore
    private boolean isIncludeSiteHours() {
        Boolean includeSiteHours = getReportParam(ReportParameter.INCLUDE_SITE_HOURS, Boolean.class);
        return falseIfNull(includeSiteHours);
    }

    @JsonIgnore
    private boolean isIncludeHolidaySchedules() {
        Boolean includeHolidaySchedules = getReportParam(ReportParameter.INCLUDE_HOLIDAY_SCHEDULES, Boolean.class);
        return falseIfNull(includeHolidaySchedules);
    }

    @JsonIgnore
    private boolean isIncludeLightingSchedules() {
        Boolean includeLightingSchedules = getReportParam(ReportParameter.INCLUDE_LIGHTING_SCHEDULES, Boolean.class);
        return falseIfNull(includeLightingSchedules);
    }

    @JsonIgnore
    private boolean isIncludeHvacSchedules() {
        Boolean includeHvacSchedules = getReportParam(ReportParameter.INCLUDE_HVAC_SCHEDULES, Boolean.class);
        return falseIfNull(includeHvacSchedules);
    }

    @JsonIgnore
    private boolean isIncludeConfigHistory() {
        Boolean includeConfigHistory = getReportParam(ReportParameter.INCLUDE_CONFIG_HISTORY, Boolean.class);
        return falseIfNull(includeConfigHistory);
    }

    @JsonIgnore
    private boolean isDailyDetail() {
        Boolean isDailyDetail = getReportParam(ReportParameter.IS_DAILY_DETAIL, Boolean.class);
        return falseIfNull(isDailyDetail);
    }

    @JsonIgnore
    private boolean isDailyChannels() {
    	Boolean dailyChannels = getReportParam(ReportParameter.IS_DAILY_CHANNELS, Boolean.class);
    	return falseIfNull(dailyChannels);
    }
    
    @JsonIgnore
    private boolean isDailyChannelsForSolar() {
      Boolean dailyChannelsForSolar = getReportParam(ReportParameter.IS_DAILY_CHANNELS_FOR_SOLAR, Boolean.class);
      return falseIfNull(dailyChannelsForSolar);
    }

    @JsonIgnore
    public boolean isDailyIntervalReport() {
        for (ReportParameter param : params) {
            if (param.isDailyInterval()) {
                return true;
            }
        }
        return false;
    }

    private boolean falseIfNull(Boolean b){
        boolean result = (b == null) ? false : b.booleanValue();
        return result;
    }

    @JsonIgnore
    public DeviceOverrideReportParameters getDeviceOverrideReportParameters(){
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));
        final LocalDateTime start = getStartLocalDateTime();
        final LocalDateTime  end = getEndLocalDateTime();
        final boolean dailyDetail = falseIfNull(isDailyDetail());

        return new DeviceOverrideReportParameters(){

            @Override
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }

            @Override
            public LocalDateTime getStart() {
                return start;
            }

            @Override
            public LocalDateTime getEnd() {
                return end;
            }

            @Override
            public boolean isDailyDetail() {
                return dailyDetail;
            }
        };
    }

    @JsonIgnore
    public AlarmsReportParameters getAlarmsReportParameters(){
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));
        final LocalDateTime startTime = getStartLocalDateTime();
        final LocalDateTime endTime = getEndLocalDateTime();
        final String alarmName = getAlarmName();
        final String state = getState();
        final String alarmType = getAlarmType();
        final String alarmId = getAlarmId();
        final boolean useActiveAlarms = isUseActiveAlarms();
        final boolean useClosedAlarms = isUseClosedAlarms();

        return new AlarmsReportParameters(){

            @Override
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }

            @Override
            public LocalDateTime getStart() {
                return startTime;
            }

            @Override
            public LocalDateTime getEnd() {
                return endTime;
            }

            @Override
            public String getAlarmName() {
                return alarmName;
            }

            @Override
            public boolean isUseActiveAlarms() {
                return useActiveAlarms;
            }

            @Override
            public boolean isUseClosedAlarms() {
                return useClosedAlarms;
            }

            @Override
            public String getAlarmType() {
                return alarmType;
            }

            @Override
            public String getAlarmState() {
                return state;
            }

            @Override
            public String getAlarmId() {
                return alarmId;
            }
        };
    }

    @JsonIgnore
    public AlarmsAndExceptionsReportParameters getAlarmsAndExceptionsReportParameters() {
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));
        final LocalDateTime startLocalDateTime = getStartLocalDateTime();
        final LocalDateTime endLocalDateTime = getEndLocalDateTime();
        final boolean useActiveAlarms = isUseActiveAlarms();
        final boolean useClosedAlarms = isUseClosedAlarms();
        final boolean useExceptionReports = falseIfNull(isUseExceptionReports());
        final boolean groupSummary = falseIfNull(isGroupSummary());
        final boolean exportAlarms = falseIfNull(isExportAlarms());
        final boolean exportExceptions = falseIfNull(isExportExceptions());

        return new AlarmsAndExceptionsReportParameters() {
            public LocalDateTime getStart() {
                return startLocalDateTime;
            }

            public LocalDateTime getEnd() {
                return endLocalDateTime;
            }

            @Override
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }

            @Override
            public boolean isUseActiveAlarms() {
                return useActiveAlarms;
            }

            @Override
            public boolean isUseClosedAlarms() {
                return useClosedAlarms;
            }

            @Override
            public boolean isUseExceptionReports() {
                return useExceptionReports;
            }

            @Override
            public boolean isGroupSummary() {
                return groupSummary;
            }

            @Override
            public boolean isExportAlarms() {
                return exportAlarms;
            }

            @Override
            public boolean isExportExceptions() {
                return exportExceptions;
            }
        };
    }

    @JsonIgnore
    public DailyEnergy3TableReportParameters getDailyEnergy3TableReportParameters(){
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));
        final LocalDateTime startTime = getStartLocalDateTime();
        final LocalDateTime endTime = getEndLocalDateTime();
        final boolean includeDailyDetail = falseIfNull(isDailyDetail());
        final boolean includeDailyChannels = falseIfNull(isDailyChannels());

        return new DailyEnergy3TableReportParameters(){

            @Override
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }

            @Override
            public LocalDateTime getStart() {
                return startTime;
            }

            @Override
            public LocalDateTime getEnd() {
                return endTime;
            }
            
            @Override
            public boolean isIncludeDailyDetail() {
                return includeDailyDetail;
            }

            @Override
            public boolean isIncludeDailyChannels() {
                return includeDailyChannels;
            }
        };
    }
    
    @JsonIgnore
    public SolarTableReportParameters getSolarTableReportParameters(){
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));
        final LocalDateTime startTime = getStartLocalDateTime();
        final LocalDateTime endTime = getEndLocalDateTime();
        final boolean includeDailyDetail = falseIfNull(isDailyDetail());
        final boolean includeDailyChannelsForSolar = falseIfNull(isDailyChannelsForSolar());

        return new SolarTableReportParameters(){

            @Override
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }
            @Override
            public LocalDateTime getStart() {
                return startTime;
            }
            @Override
            public LocalDateTime getEnd() {
                return endTime;
            }
            @Override
            public boolean isIncludeDailyDetail() {
                return includeDailyDetail;
            }
            @Override
            public boolean isIncludeDailyChannelsForSolar() {
                return includeDailyChannelsForSolar;
            }
        };
    }

    @JsonIgnore
    public VoltageImbalanceReportParameters getVoltageImbalanceReportParameters(){
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));
        final LocalDateTime startTime = getStartLocalDateTime();
        final LocalDateTime endTime = getEndLocalDateTime();
        final Double threshold = getThreshold();

        return new VoltageImbalanceReportParameters(){

            @Override
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }

            @Override
            public LocalDateTime getStart() {
                return startTime;
            }

            @Override
            public LocalDateTime getEnd() {
                return endTime;
            }

            @Override
            public Double getThreshold() {
                return threshold;
            }
        };
    }

    @JsonIgnore
    public ExceptionReportParameters getExceptionReportParameters(){
        
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));

        final LocalDateTime startDateTime = getStartLocalDateTime();
        final LocalDateTime endDateTime = getEndLocalDateTime();
        final Long queryId = getQueryId();

        return new ExceptionReportParameters() {
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }

            public LocalDateTime getStart() {
                return startDateTime;
            }

            public LocalDateTime getEnd() {
                return endDateTime;
            }

            public Long getQueryId() {
                return queryId;
            }
        };
    }

    @JsonIgnore
    public SiteSchedulesReportParameters getSiteSchedulesReportParameters(){
        final Set<Long> premisesIds = Collections.unmodifiableSet(new HashSet<Long>(getPremisesIds()));
        final LocalDateTime startTime = getStartLocalDateTime();
        final LocalDateTime endTime = getEndLocalDateTime();

        final boolean includeSiteHours = falseIfNull(isIncludeSiteHours());
        final boolean includeHolidaySchedules = falseIfNull(isIncludeHolidaySchedules());
        final boolean includeLightingSchedules = falseIfNull(isIncludeLightingSchedules());
        final boolean includeHvacSchedules = falseIfNull(isIncludeHvacSchedules());
        final boolean includeConfigHistory = falseIfNull(isIncludeConfigHistory());

        return new SiteSchedulesReportParameters(){

            @Override
            public boolean isIncludeSiteHours() {
                return includeSiteHours;
            }

            @Override
            public Set<Long> getPremisesIds() {
                return premisesIds;
            }

            @Override
            public boolean isIncludeLightingSchedules(){
                return includeLightingSchedules;
            }

            @Override
            public boolean isIncludeHolidaySchedules() {
                return includeHolidaySchedules;
            }

            @Override
            public boolean isIncludeHvacSchedules() {
                return includeHvacSchedules;
            }

            @Override
            public boolean isIncludeConfigHistory() {
                return includeConfigHistory;
            }

            @Override
            public LocalDateTime getStart() {
                return startTime;
            }

            @Override
            public LocalDateTime getEnd() {
                return endTime;
            }
        };
    }
}

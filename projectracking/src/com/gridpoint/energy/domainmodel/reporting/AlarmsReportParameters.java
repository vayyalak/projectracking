package com.gridpoint.energy.domainmodel.reporting;

import java.util.Set;

import com.gridpoint.energy.util.date.LocalDateTime;

public interface AlarmsReportParameters {
    Set<Long> getPremisesIds();

    LocalDateTime getStart();

    LocalDateTime getEnd();

    String getAlarmName();

    String getAlarmType();

    String getAlarmState();

    String getAlarmId();

    boolean isUseActiveAlarms();

    boolean isUseClosedAlarms();
}

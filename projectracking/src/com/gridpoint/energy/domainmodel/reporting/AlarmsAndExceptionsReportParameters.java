package com.gridpoint.energy.domainmodel.reporting;

import java.util.Set;

import com.gridpoint.energy.util.date.LocalDateTime;

public interface AlarmsAndExceptionsReportParameters {
    Set<Long> getPremisesIds();

    LocalDateTime getStart();

    LocalDateTime getEnd();

    boolean isUseActiveAlarms();

    boolean isUseClosedAlarms();

    boolean isUseExceptionReports();

    boolean isGroupSummary();

    boolean isExportAlarms();

    boolean isExportExceptions();
}

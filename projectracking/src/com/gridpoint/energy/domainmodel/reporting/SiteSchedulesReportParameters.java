package com.gridpoint.energy.domainmodel.reporting;

import java.util.Set;

import com.gridpoint.energy.util.date.LocalDateTime;

public interface SiteSchedulesReportParameters {
    boolean isIncludeSiteHours();

    Set<Long> getPremisesIds();

    boolean isIncludeLightingSchedules();

    boolean isIncludeHolidaySchedules();

    boolean isIncludeHvacSchedules();

    boolean isIncludeConfigHistory();

    LocalDateTime getStart();

    LocalDateTime getEnd();
}

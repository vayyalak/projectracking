package com.gridpoint.energy.domainmodel.reporting;

import java.util.Set;

import com.gridpoint.energy.util.date.LocalDateTime;


public interface DailyEnergy3TableReportParameters {
    Set<Long> getPremisesIds();
    LocalDateTime getStart();
    LocalDateTime getEnd();
    boolean isIncludeDailyDetail();
    boolean isIncludeDailyChannels();
}

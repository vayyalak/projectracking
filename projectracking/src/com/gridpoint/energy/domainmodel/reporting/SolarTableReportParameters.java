package com.gridpoint.energy.domainmodel.reporting;

import java.util.Set;

import com.gridpoint.energy.util.date.LocalDateTime;

public interface SolarTableReportParameters {

	Set<Long> getPremisesIds();
    LocalDateTime getStart();
    LocalDateTime getEnd();
    boolean isIncludeDailyDetail();
    boolean isIncludeDailyChannelsForSolar();
}

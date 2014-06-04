package com.gridpoint.energy.domainmodel.reporting;

import java.util.Set;

import com.gridpoint.energy.util.date.LocalDateTime;

public interface DeviceOverrideReportParameters {

    Set<Long> getPremisesIds();

    LocalDateTime getStart();

    LocalDateTime getEnd();

    boolean isDailyDetail();
}

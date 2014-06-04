package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.function.Option;

public enum Report {
    ALARMS("jasper/getAlarmReportByLocalDateTime"), //
    EXCEPTIONS("jasper/exportExceptionReport"), //
    ALARMS_AND_EXCEPTIONS("jasper/getAlarmsAndExceptions"), //
    SOLAR_REPORT("solar_report"), //
    VOLTAGE_IMBALANCE("data/getPviReport"), //
    SITE_SCHEDULES("storeSchedulesReport"), //
    DEVICE_OVERRIDES("deviceOverrideReport"), //
    DAILY_ENERGY_3TABLE("dailyEnergy3Table"),
    BILLING_COMPARISON("billingComparisonReport");

    public final String path;

    private Report(String path) {
        this.path = path;
    }

    public static Option<Report> findByPath(String path) {
        for (Report report : Report.values()) {
            if (report.path.equals(path)) {
                return Option.option(report);
            }
        }
        return Option.none();
    }
}

package com.gridpoint.energy.domainmodel;

/**
 * Alarm Summary represents statistical information for a group of premises including total active alarms, and other meaningful information
 * over a period including the last month from time now.
 */
public class AlarmSummary {

    private int activeAlarms;
    private int alarmsThisMonth;
    private int numberOfSitesWithAlarms;
    private int alarmsThisWeek;
    private int alarmsToday;
    private int alarmsPreviousWeek;

    private double alarmsTodayVsLastWeekAvg;

    public int getActiveAlarms() {
        return activeAlarms;
    }

    public void setActiveAlarms(int activeAlarms) {
        this.activeAlarms = activeAlarms;
    }

    public int getAlarmsThisMonth() {
        return alarmsThisMonth;
    }

    public void setAlarmsThisMonth(int alarmsThisMonth) {
        this.alarmsThisMonth = alarmsThisMonth;
    }

    public int getNumberOfSitesWithAlarms() {
        return numberOfSitesWithAlarms;
    }

    public void setNumberOfSitesWithAlarms(int numberOfSitesWithAlarms) {
        this.numberOfSitesWithAlarms = numberOfSitesWithAlarms;
    }

    public int getAlarmsThisWeek() {
        return alarmsThisWeek;
    }

    public void setAlarmsThisWeek(int alarmsThisWeek) {
        this.alarmsThisWeek = alarmsThisWeek;
    }

    public double getAlarmsTodayVsLastWeekAvg() {
        return alarmsTodayVsLastWeekAvg;
    }

    public void setAlarmsTodayVsLastWeekAvg(double alarmsTodayVsLastWeekAvg) {
        this.alarmsTodayVsLastWeekAvg = alarmsTodayVsLastWeekAvg;
    }

    public int getAlarmsToday() {
        return this.alarmsToday;
    }

    public void setAlarmsToday(int alarmsToday) {
        this.alarmsToday = alarmsToday;
    }

    public int getAlarmsPreviousWeek() {
        return this.alarmsPreviousWeek;
    }

    public void setAlarmsPreviousWeek(int alarmsPreviousWeek) {
        this.alarmsPreviousWeek = alarmsPreviousWeek;
    }
}

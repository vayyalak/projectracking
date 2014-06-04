package com.gridpoint.energy.domainmodel;

import java.util.Date;

public class BillingPeriod {
    private double rate;
    private double avgDailyUsage;
    private double avgDailyPredictedUsage;
    private String unit;
    private Date start;
    private Date end;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAvgDailyUsage() {
        return avgDailyUsage;
    }

    public void setAvgDailyUsage(double avgDailyUsage) {
        this.avgDailyUsage = avgDailyUsage;
    }

    public double getAvgDailyPredictedUsage() {
        return avgDailyPredictedUsage;
    }

    public void setAvgDailyPredictedUsage(double avgDailyPredictedUsage) {
        this.avgDailyPredictedUsage = avgDailyPredictedUsage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "BillingPeriod{" +
                "rate=" + rate +
                ", avgDailyUsage=" + avgDailyUsage +
                ", avgDailyPredictedUsage=" + avgDailyPredictedUsage +
                ", unit='" + unit + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

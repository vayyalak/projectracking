package com.gridpoint.energy.domainmodel;

/**
 *
 */
public class IntervalSummary
{
    private final       long            summaryStartTime;
    private final       long            lastSampleTime;
    private final       double          min;
    private final       double          max;
    private final       int             count;
    private final       double          sum;

    public IntervalSummary (long summaryStartTime, long lastSampleTime, double min, double max, int count, double sum)
    {
        this.summaryStartTime = summaryStartTime;
        this.lastSampleTime = lastSampleTime;
        this.min = min;
        this.max = max;
        this.count = count;
        this.sum = sum;
    }

    public long getSummaryStartTime () {
        return summaryStartTime;
    }

    public long getLastSampleTime () {
        return lastSampleTime;
    }

    public double getMin () {
        return min;
    }

    public double getMax () {
        return max;
    }

    public int getCount () {
        return count;
    }

    public double getSum () {
        return sum;
    }
}

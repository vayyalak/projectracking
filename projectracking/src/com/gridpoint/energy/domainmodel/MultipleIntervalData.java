package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Logs device data over multiple periods of time. The message can contain one or more Interval Data objects.
 *
 * For more information, see {@link IntervalData}.
 *
 * @author dhorlick
 */
public class MultipleIntervalData
{
    private List<IntervalData> intervals = new ArrayList<IntervalData> ();

    public List<IntervalData> getIntervals()
    {
        return intervals;
    }

    public void setIntervals(final List<IntervalData> designatedIntervals)
    {
        intervals = designatedIntervals;
    }

    /**
     * @throws IllegalStateException if any of the interval data sets would be inherently un-loggable.
     */
    public void validate()
    {
        for (final IntervalData intervalData : intervals)
        {
            intervalData.validate();
        }
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

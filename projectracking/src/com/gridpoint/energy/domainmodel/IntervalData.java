package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.ConcretePropertyCatalogue;
import com.gridpoint.energy.util.collection.PropertyCatalogue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.json.JSONObject;

import java.lang.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Logs device data over periods of time. The message can contain one or more devices where each device can have one
 * or more channels. If communications with the server are lost, all interval data must be buffered. If the endpoint
 * runs out of buffer space, the oldest data must be deleted first.
 *
 * Interval data messages must be aligned to the current time on interval boundaries. For example, if the interval is
 * 15 minutes, this message must be from 11:00 to 11:15 and not 11:02 to 11:17. Partial intervals are allowed, but they
 * must still start or end on an interval boundary, as appropriate. Intervals do not need to sent to the server on
 * interval boundaries, so they can be queued and sent whenever possible.
 */
public class IntervalData
{
    private long endTime;
    private int durationMsecs;
    private List<DeviceData> deviceDataList = new ArrayList<DeviceData> ();

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getDurationMsecs() {
        return durationMsecs;
    }

    public void setDurationMsecs(int durationMsecs) {
        this.durationMsecs = durationMsecs;
    }

    public List<DeviceData> getDeviceDataList() {
        return deviceDataList;
    }

    public void setDeviceDataList(List<DeviceData> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }

    /**
     * @throws IllegalStateException if this interval data would be inherently un-loggable.
     */
    public void validate()
    {

        switch (getDurationMsecs())
        {
            case 60000:
            case 300000:
            case 900000:
            case 3600000:
                // good
                break;
            default:
                throw new IllegalStateException("Duration in millis, "+getDurationMsecs()
                        +", must be 1 minute, 5 minutes, 15 minutes, or 1 hour.");
        }

        if (getEndTime() % getDurationMsecs() != 0)
        {
            throw new IllegalStateException("End time epoch, "+getEndTime()
                    +", must be a whole-number multiple of duration in millis, "+getDurationMsecs());
        }

        final Calendar twoYearsAgoCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        final long NOW = java.lang.System.currentTimeMillis();
        twoYearsAgoCal.setTimeInMillis(NOW);
        twoYearsAgoCal.add(Calendar.YEAR, -2);

        if (endTime < twoYearsAgoCal.getTimeInMillis())
            throw new IllegalStateException("End time cannot be more than two years in the past: "+endTime);

        final Calendar twoDaysFromToday = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        twoDaysFromToday.setTimeInMillis(NOW);
        twoDaysFromToday.set(Calendar.HOUR, 0);
        twoDaysFromToday.set(Calendar.MINUTE, 0);
        twoDaysFromToday.set(Calendar.SECOND, 0);
        twoDaysFromToday.set(Calendar.MILLISECOND, 0);
        twoDaysFromToday.add(Calendar.DAY_OF_YEAR, 2);

        if (endTime > twoDaysFromToday.getTimeInMillis())
            throw new IllegalStateException("End time cannot be more than two days from today in the future: "+endTime);
    }

    public JSONObject toJson()
    {
        return new JSONObject(toPropertyCatalog());
    }

    public PropertyCatalogue toPropertyCatalog()
    {
        final PropertyCatalogue propertyCatalogue = new ConcretePropertyCatalogue();
        propertyCatalogue.put("endTime", endTime);
        propertyCatalogue.put("durationMsecs", durationMsecs);
        final List<PropertyCatalogue> devices = new ArrayList<PropertyCatalogue> ();
        for (final DeviceData deviceData : deviceDataList)
        {
            devices.add(deviceData.toPropertyCatalog());
        }
        propertyCatalogue.put("devices", devices);
        return propertyCatalogue;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object other)
    {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(117, 19, this);
    }
}

package com.gridpoint.energy.domainmodel;

import java.util.TimeZone;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;


public class CoincidentTime implements Comparable<CoincidentTime> {
    private final LocalDateTime localDateTime;
    private final boolean isFallback;

    public CoincidentTime (long actualTime, TimeZone timeZone) {
        DateTimeZone dtz = DateTimeZone.forTimeZone(timeZone);
        DateTime dateTime = new DateTime(actualTime, dtz);
        localDateTime = new LocalDateTime(actualTime, dtz);
        isFallback = dateTime.getHourOfDay() == dateTime.plusHours(-1).getHourOfDay();
    }

    // Check if a coincident time can be mapped to the given TimeZone, i.e. is in a daylight savings gap
    // or is fallback going to a non-fallback time on the other end
    public boolean isMappableTo(TimeZone timeZone) {
        DateTimeZone dtz = DateTimeZone.forTimeZone(timeZone);
        if (dtz.isLocalDateTimeGap(localDateTime)) return false;
        if (isFallback) {
            DateTime destinationDateTime = getEarlierDateTime(dtz);
            if (destinationDateTime.getHourOfDay() != destinationDateTime.plusHours(1).getHourOfDay()) return false;
        }
        return true;
    }

    public DateTZ getDateTZ (TimeZone timeZone) {
        DateTimeZone dtz = DateTimeZone.forTimeZone(timeZone);
        return new DateTZ(getEarlierDateTime(dtz).plusHours(isFallback ? 1 : 0).toDate(), timeZone.getID());
    }

    private DateTime getEarlierDateTime(DateTimeZone dtz) {
        DateTime lateTime = localDateTime.toDateTime(dtz);
        DateTime earlyTime = lateTime.plusHours(-1);
        return (lateTime.getHourOfDay() == earlyTime.getHourOfDay()) ?  earlyTime : lateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public boolean isFallback() {
        return isFallback;
    }

    @Override
    public String toString() {
        String result = new ToStringBuilder(this) //
                .append(String.valueOf(localDateTime.toDateTime(DateTimeZone.UTC).getMillis()), localDateTime.toString()) //
                .append("isFallback", isFallback) //
                .toString();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoincidentTime that = (CoincidentTime) o;

        if (isFallback != that.isFallback) return false;
        if (!localDateTime.equals(that.localDateTime)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = localDateTime != null ? localDateTime.hashCode() : 0;
        result = 31 * result + (isFallback ? 1 : 0);
        return result;
    }

    @Override
    // Compare up to the hour, then use fallback (fallback hours are greater than non-fallback) then just compare the dates
    public int compareTo(CoincidentTime that) {
        int result = this.localDateTime.hourOfDay().roundFloorCopy().compareTo(that.localDateTime.hourOfDay().roundFloorCopy());
        if (result != 0) return result;
        if (this.isFallback && !that.isFallback) return 1;
        if (!this.isFallback && that.isFallback) return -1;

        return this.localDateTime.compareTo(that.localDateTime);
    }
}

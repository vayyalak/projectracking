package com.gridpoint.energy.domainmodel.datetime;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.gridpoint.energy.util.DateFormats;
import com.gridpoint.energy.util.TimeUtil;
import com.gridpoint.energy.util.date.LocalDateTime.LocalDateTime;


/**
 * DateTZ holds a long value, timezone, and a boolean flag which is interpreted by the GSON registered adapter to determine when printing
 * the String whether timezone is appended or not. In the latter case, any UI will parse the String and assume that time is in local time so
 * we can line up data from several different time zones.
 * @deprecated DWC- use LocalDateTime to represent site local times or Longs to represent instants.
 */
@Deprecated
public class DateTZ implements Comparable<DateTZ> {
    private static transient final  TimeZone DEFAULT_TZ = TimeZone.getTimeZone("GMT");

    protected Date date;

    protected String tz;

    protected Boolean showTz = true;

    public DateTZ(LocalDateTime ldt){
        this.date = new Date(ldt.instantInUtc());
        this.tz = "GMT";
    }

    public DateTZ(Date date, String tz) {
        this.date = date;
        this.tz = tz;
    }

    public DateTZ(Date date, String tz, Boolean showTz) {
        this.date = date;
        this.tz = tz;
        this.showTz = showTz;
    }

    public DateTZ(Date date) {
        this(date, "GMT");
    }

    public DateTZ(Long date) {
        this(new Date(date), "GMT");
    }

    public DateTZ(Long date, String tz) {
        this(new Date(date), tz);
    }

    public DateTZ(long date, boolean showTz) {
        this(new Date(date), "GMT", showTz);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime asLdt(){
        if(null == this.tz){
            return LocalDateTime.forUtc(this.date);
        } else {
            TimeZone timeZone = TimeZone.getTimeZone((this.tz == null) ? "UTC" : this.tz);
            return new LocalDateTime(this.date.getTime(), timeZone);
        }
    }

    public static <V> Map<LocalDateTime, V> convertMap(Map<DateTZ, V> input){
        Map<LocalDateTime, V> result = new HashMap<LocalDateTime, V>();
        for(DateTZ keyTZ : input.keySet()){
            LocalDateTime keyLdt = keyTZ.asLdt();
            V value = input.get(keyTZ);
            result.put(keyLdt, value);
        }
        return result;
    }

    // Thread Local Static formats
    private static final ThreadLocal<DateFormat> tzFormat = new ThreadLocal<DateFormat>() {
        @Override protected DateFormat initialValue() {return new SimpleDateFormat(DateFormats.DATE_FORMAT_TZ); }
    };
    private static final ThreadLocal<DateFormat> noTzFormat = new ThreadLocal<DateFormat>() {
        @Override protected DateFormat initialValue() {return new SimpleDateFormat(DateFormats.DATE_FORMAT_NOTZ); }
    };
    private static final ThreadLocal<DateFormat> alarmFormat = new ThreadLocal<DateFormat>() {
        @Override protected DateFormat initialValue() {return new SimpleDateFormat(DateFormats.DATE_FORMAT_ALARM_REPORT); }
    };

    public String format() {
        /**
         * Determine the timezone.
         */

        TimeZone timezone;

        if (tz == null) {
            timezone = DEFAULT_TZ;
        } else {
            timezone = TimeZone.getTimeZone(tz);
        }

        /**
         * Chase down the appropriate format object.
         */

    	DateFormat format = null;

    	if (showTz) {
	    	format = tzFormat.get();
    	} else {
	    	format = noTzFormat.get();
    	}
    	
    	format.setTimeZone(timezone);
        return format.format(date);
    }

    public static DateTZ parseDateTZ(String dateStr) {
        try {
            //try to parse with tz first
            Date d = tzFormat.get().parse(dateStr);
            TimeZone tz = TimeZone.getTimeZone(dateStr.substring(dateStr.length() - 13, dateStr.length() - 5));
            return new DateTZ(d, tz.getID());
        } catch (ParseException pe) {}

        try {
            TimeZone tz = TimeZone.getTimeZone("GMT");
            noTzFormat.get().setTimeZone(tz);
            Date d = noTzFormat.get().parse(dateStr);
            return new DateTZ(d, tz.getID());
        } catch (ParseException pe) {}

        try {
            Date d = alarmFormat.get().parse(dateStr);
            TimeZone tz = TimeZone.getTimeZone(dateStr.substring(dateStr.length() - 8, dateStr.length()));
            return new DateTZ(d, tz.getID());
        } catch(ParseException pe) {}

        try {
            Date d = new Date(Long.parseLong(dateStr));
            TimeZone tz = TimeZone.getTimeZone("GMT");
            return new DateTZ(d, tz.getID());
        } catch (NumberFormatException nfe) {}

        try{
            LocalDateTime ldt = LocalDateTime.valueOf(dateStr);
            long l = ldt.instantInUtc();
            TimeZone tz = TimeZone.getTimeZone("GMT");
            return new DateTZ(l, tz.getID());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Unable to parse Date with TimeZone, without TimeZone, as long, or as LocalDateTime: " + dateStr);
        }
    }

    public Date getDate() {
        return date;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getTz() {
        return tz;
    }

    public void setShowTz(Boolean showTz) {
        this.showTz = showTz;
    }

    public Boolean getShowTz() {
        return showTz;
    }


    @Override
    public int compareTo(final DateTZ other) {
        if (date == null ^ other.date == null) {
            return (date == null) ? -1 : 1;
        }
        if( this.date == null ) {
            return( 0 );
        }
        //we know date is not null for both.
        TimeZone tz1 = null;
        TimeZone tz2 = null;
        if( tz != null ) {
            tz1 = TimeUtil.getTimeZoneStrict( tz );
        }
        if( other.tz != null ) {
            tz2 = TimeUtil.getTimeZoneStrict( other.tz );
        }
        if( tz1 == null ) {
            tz1 = DEFAULT_TZ;
        }
        if( tz2 == null ) {
            tz2 = DEFAULT_TZ;
        }
        Long val1 = date.getTime() + tz1.getOffset(date.getTime());
        Long val2 = other.date.getTime() + tz2.getOffset(other.date.getTime());

        return( val1.compareTo( val2 ) );
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DateTZ other = (DateTZ) o;

        if (date == null ^ other.date == null) {
            return ( false );
        }
        if( this.date == null ) {
            return( true );
        }
        //we know date is not null for both.
        TimeZone tz1 = null;
        TimeZone tz2 = null;
        if( tz != null ) {
            tz1 = TimeUtil.getTimeZoneStrict( tz );
        }
        if( other.tz != null ) {
            tz2 = TimeUtil.getTimeZoneStrict( other.tz );
        }
        if( tz1 == null ) {
            tz1 = DEFAULT_TZ;
        }
        if( tz2 == null ) {
            tz2 = DEFAULT_TZ;
        }
        long val1 = date.getTime() + tz1.getOffset(date.getTime());
        long val2 = other.date.getTime() + tz2.getOffset(other.date.getTime());

        return( val1 == val2 );
    }

    @Override
    public int hashCode () {
        Long timeVal = date != null ? date.getTime() : 0;

        TimeZone timeZone = null;
        if( tz != null ) {
            timeZone = TimeUtil.getTimeZoneStrict(tz);
        }
        if( timeZone == null ) {
            timeZone = DEFAULT_TZ;
        }
        timeVal = timeVal + timeZone.getOffset(timeVal);

        return( timeVal.hashCode() );
    }

    public static class DateTZFormat extends Format {
        public static final long serialVersionUID = 0;
        private final SimpleDateFormat format;

        public DateTZFormat(String formatString) {
            this.format = new SimpleDateFormat(formatString);
        }

        @Override
        public StringBuffer format(Object o, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            if (!(o instanceof DateTZ)) {
                throw new IllegalArgumentException ("Object must be of type DateTZ to be formatted");
            }
            DateTZ dateTz = (DateTZ) o;
            TimeZone tz = dateTz.getTz() == null ? DEFAULT_TZ : TimeZone.getTimeZone(dateTz.getTz());
            format.setTimeZone(tz);
            return format.format(dateTz.getDate(), stringBuffer, fieldPosition);
        }

        @Override
        public Object parseObject(String s, ParsePosition parsePosition) {
            throw new UnsupportedOperationException("DateTZ does not support parsing");
        }
    }
}

package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.date.LocalTimeHelper;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.joda.time.LocalTime;

public class SiteHours {

	private long premisesId;
	private String premisesName;
	private String siteOpen;
	private String siteClose;
	private String dayOfWeek;
	private String type;
	private Integer numericDayOfWeek;

	public long getPremisesId() {
		return premisesId;
	}

	public void setPremisesId(long premisesId) {
		this.premisesId = premisesId;
	}
	
	public String getPremisesName() {
	    return premisesName;
	}
	
	public void setPremisesName(String premisesName) {
	    this.premisesName = premisesName;
	}

	public String getSiteOpen() {
		return siteOpen;
	}

	public void setSiteOpen(String siteOpen) {
		this.siteOpen = siteOpen;
	}

	public String getSiteClose() {
		return siteClose;
	}

	public void setSiteClose(String siteClose) {
		this.siteClose = siteClose;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public String getType() {
	    return type;
	}
	
	public void setType(String type) {
	    this.type = type;
	}

	public void setNumericDayOfWeek(int numericDayOfWeek) {
		this.numericDayOfWeek = numericDayOfWeek;
	}
	
	public Integer getNumericDayOfWeek() {
		return numericDayOfWeek;
	}

    public boolean closedAllDay()
    {
        final Object siteOpenTime = siteOpenTime();
        final Object siteCloseTime = siteCloseTime();

        if (siteOpenTime==null && siteCloseTime==null)
            return true;

        if (siteOpenTime==siteCloseTime)
            return true;

        if (siteOpenTime instanceof LocalTime && siteCloseTime instanceof LocalTime)
        {
            final LocalTime siteOpenLocalTime = (LocalTime) siteOpenTime;
            final LocalTime siteCloseLocalTime = (LocalTime) siteCloseTime;

            if (siteOpenLocalTime.getMillisOfDay()==siteCloseLocalTime.getMillisOfDay())
                return true;
        }

        return false;
    }

    /**
     * @return a {@link QualitativeDailyTime}, a {@link org.joda.time.LocalTime}, or null.
     *
     * Only ADM uses qualitative daily times. GPEC does not.
     */
    public Object siteOpenTime()
    {
        return harvestTime(siteOpen);
    }

    /**
     * @return a {@link QualitativeDailyTime}, a {@link org.joda.time.LocalTime}, or null.
     *
     * Only ADM uses qualitative daily times. GPEC does not.
     */
    public Object siteCloseTime()
    {
        return harvestTime(siteClose);
    }

    /**
     * @return a {@link QualitativeDailyTime}, a {@link org.joda.time.LocalTime}, or null.
     *
     * Only ADM uses qualitative daily times. GPEC does not.
     */
    public static Object harvestTime(final String value)
    {
        if (value==null || value.length()==0)
            return null;

        if ("open".equals(value))
            return QualitativeDailyTime.OPENING_TIME;
        else if ("close".equals(value))
            return QualitativeDailyTime.CLOSING_TIME;
        else if ("sunrise".equals(value))
            return QualitativeDailyTime.SUNRISE;
        else if ("sunset".equals(value))
            return QualitativeDailyTime.SUNSET;
        else
            return LocalTimeHelper.parseLocalTime(value);
    }

    public static SiteHours closed(final long premisesId, final String premisesName, int weekdayIndex,
                                   final String storeHoursType)
    {
        final SiteHours closed = new SiteHours();
        closed.setSiteOpen("00:00");
        closed.setSiteClose("00:00");
        closed.setNumericDayOfWeek(weekdayIndex);
        closed.setDayOfWeek(String.valueOf(weekdayIndex));
        closed.setPremisesId(premisesId);
        closed.setPremisesName(premisesName);
        closed.setType(storeHoursType);
        return closed;
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( dayOfWeek == null ) ? 0 : dayOfWeek.hashCode() );
        result = prime * result + ( ( numericDayOfWeek == null ) ? 0 : numericDayOfWeek.hashCode() );
        result = prime * result + (int) ( premisesId ^ ( premisesId >>> 32 ) );
        result = prime * result + ( ( premisesName == null ) ? 0 : premisesName.hashCode() );
        result = prime * result + ( ( siteClose == null ) ? 0 : siteClose.hashCode() );
        result = prime * result + ( ( siteOpen == null ) ? 0 : siteOpen.hashCode() );
        result = prime * result + ( ( type == null ) ? 0 : type.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SiteHours other = (SiteHours) obj;
        if (dayOfWeek == null) {
            if (other.dayOfWeek != null) return false;
        } else if (!dayOfWeek.equals(other.dayOfWeek)) return false;
        if (numericDayOfWeek == null) {
            if (other.numericDayOfWeek != null) return false;
        } else if (!numericDayOfWeek.equals(other.numericDayOfWeek)) return false;
        if (premisesId != other.premisesId) return false;
        if (premisesName == null) {
            if (other.premisesName != null) return false;
        } else if (!premisesName.equals(other.premisesName)) return false;
        if (siteClose == null) {
            if (other.siteClose != null) return false;
        } else if (!siteClose.equals(other.siteClose)) return false;
        if (siteOpen == null) {
            if (other.siteOpen != null) return false;
        } else if (!siteOpen.equals(other.siteOpen)) return false;
        if (type == null) {
            if (other.type != null) return false;
        } else if (!type.equals(other.type)) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Models custom or holiday hours. Primarily used in conjunction with GPEC right now, but could just as easily be
 * used with ADM.
 *
 * @author dhorlick
 */
public class CustomHours
{
    private String uniqueName;
    private String displayName;
    private int month;
    private int day;
    private int year;
    private String siteOpen;
    private String siteClose;
    private boolean override;

    public CustomHours(final String designatedUniqueName, final String designatedDisplayName, final
                       int designatedMonth, final int designatedDay,
                       final int designatedYear, final String designatedSiteOpen, final String designatedSiteClose,
                       final boolean designatedOverride)
    {
        setUniqueName(designatedUniqueName);
        setDisplayName(designatedDisplayName);
        setMonth(designatedMonth);
        setDay(designatedDay);
        setYear(designatedYear);
        setSiteOpen(designatedSiteOpen);
        setSiteClose(designatedSiteClose);
        setOverride(designatedOverride);
    }

    /**
     * @return The name stored in GPEC.
     */
    public String getUniqueName()
    {
        return uniqueName;
    }

    public void setUniqueName(final String designatedUniqueName)
    {
        if (designatedUniqueName==null || designatedUniqueName.length()==0)
            throw new IllegalArgumentException("No unique name provided.");

        uniqueName = designatedUniqueName;
    }

    /**
     * @return The name display by portal.
     */
    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(final String designatedDisplayName)
    {
        if (designatedDisplayName==null || designatedDisplayName.length()==0)
            throw new IllegalArgumentException("No display name provided.");

        displayName = designatedDisplayName;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(final int designatedMonth)
    {
        if (designatedMonth<1 || designatedMonth>12)
            throw new IllegalArgumentException("Invalid month "+designatedMonth);

        month = designatedMonth;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(final int designatedDay)
    {
        if (designatedDay<1 || designatedDay>31)
            throw new IllegalArgumentException("Invalid day "+designatedDay);

        day = designatedDay;
    }

    /**
     * @return The calendar year. By an unfortunate convention, the number zero has been set aside to mean "every year".
     */
    public int getYear()
    {
        return year;
    }

    public void setYear(final int designatedYear)
    {
        year = designatedYear;
    }

    public boolean everyYear()
    {
        return (year==0);
    }

    public String getSiteOpen()
    {
        return siteOpen;
    }

    public void setSiteOpen(final String designatedSiteOpen)
    {
        if (designatedSiteOpen==null || designatedSiteOpen.length()==0)
            throw new IllegalArgumentException("No site open provided.");
        siteOpen = designatedSiteOpen;
    }

    public String getSiteClose()
    {
        return siteClose;
    }

    public void setSiteClose(final String designatedSiteClose)
    {
        if (designatedSiteClose==null)
            throw new IllegalArgumentException("No site close provided.");

        siteClose = designatedSiteClose;
    }

    public boolean isOverride()
    {
        return override;
    }

    public void setOverride(boolean override)
    {
        this.override = override;
    }

    public Element toGpecConfigElement(final Document doc)
    {
        final Element element = doc.createElement("Custom");
        // examples:
        // <Custom name="Christmas" month="12" day="25" year="0" open="12:11" close="12:13" />
        // <Custom name="User-Override" type="override" month="11" day="27" year="2012" open="13:07" close="14:55" />
        element.setAttribute("name", uniqueName);
        element.setAttribute("month", String.valueOf(month));
        element.setAttribute("day", String.valueOf(day));
        element.setAttribute("year", String.valueOf(year));
        element.setAttribute("open", siteOpen);
        element.setAttribute("close", siteClose);
        if (override)
            element.setAttribute("type", "override");
        return element;
    }

    public static String uniqueifyLegacyHoursName(final int month, final int day)
    {
        final StringBuilder result = new StringBuilder();
        result.append("Other");
        if (month<10)
            result.append('0');
        result.append(month);
        result.append('/');
        if (day<10)
            result.append('0');
        result.append(day);
        return result.toString();
    }

    public static boolean hackedLegacyHoursName(String uniqueCustomHoursName, final int month, final int day)
    {
        return (uniqueCustomHoursName.equals(uniqueifyLegacyHoursName(month, day)));
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

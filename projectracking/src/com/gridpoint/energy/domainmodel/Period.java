package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.JavaBeanToMapAdapter;
import com.gridpoint.energy.util.collection.PropertyCatalogue;
import com.gridpoint.energy.util.date.LocalTimeHelper;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.joda.time.LocalTime;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Period
{
    private LocalTime startTime;
    private QualitativeDailyTime qualitativeStartTime;
    private LocalTime endTime;
    private QualitativeDailyTime qualitativeEndTime;
    private Integer startOffsetInMinutes;
    private Integer endOffsetInMinutes;
    private Boolean occupied;

    public LocalTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(final LocalTime designatedStartTime)
    {
        startTime = designatedStartTime;
    }

    public LocalTime getEndTime()
    {
        return endTime;
    }

    public void setEndTime(final LocalTime designatedEndTime)
    {
        endTime = designatedEndTime;
    }

    public QualitativeDailyTime getQualitativeStartTime()
    {
        return qualitativeStartTime;
    }

    public void setQualitativeStartTime(final QualitativeDailyTime designatedQualitativeStartTime)
    {
        qualitativeStartTime = designatedQualitativeStartTime;
    }

    public QualitativeDailyTime getQualitativeEndTime()
    {
        return qualitativeEndTime;
    }

    public void setQualitativeEndTime(final QualitativeDailyTime designatedQualitativeEndTime)
    {
        qualitativeEndTime = designatedQualitativeEndTime;
    }

    public Integer getStartOffsetInMinutes()
    {
        return startOffsetInMinutes;
    }

    public void setStartOffsetInMinutes(final Integer designatedStartOffsetInMinutes)
    {
        startOffsetInMinutes = designatedStartOffsetInMinutes;
    }

    public Integer getEndOffsetInMinutes()
    {
        return endOffsetInMinutes;
    }

    public void setEndOffsetInMinutes(final Integer designatedEndOffsetInMinutes)
    {
        endOffsetInMinutes = designatedEndOffsetInMinutes;
    }

    public Boolean getOccupied()
    {
        return occupied;
    }

    public void setOccupied(Boolean occupied)
    {
        this.occupied = occupied;
    }

    public String formatStartTime()
    {
        return LocalTimeHelper.formatLocalTime(startTime, false);
    }

    public String formatEndTime()
    {
        return LocalTimeHelper.formatLocalTime(endTime, true);
    }

    public PropertyCatalogue toPropertyCatalog()
    {
        final PropertyCatalogue propertyCatalogue = new JavaBeanToMapAdapter(this);
        return propertyCatalogue;
    }

    public static Period parseJson(final JSONObject json) throws JSONException
    {
        final Period period = new Period();

        if (json.has("onValue"))
            period.setStartTime(LocalTimeHelper.parseLocalTime((String)json.get("onValue"))); // TODO support numerical offsets from qualitative times, too
        if (json.has("offValue"))
            period.setEndTime(LocalTimeHelper.parseLocalTime((String)json.get("offValue"))); // TODO support numerical offsets from qualitative times, too

        if (json.has("onCondition"))
            period.setQualitativeStartTime(QualitativeDailyTime.parse((String)json.get("onCondition")));
        if (json.has("offCondition"))
            period.setQualitativeEndTime(QualitativeDailyTime.parse((String) json.get("offCondition")));

        return period;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    /**
     * @return The rough skeleton of a Period element. // TODO correct?
     */
    public Element toGpecConfigElement(final Document doc)
    {
        /*
         Example 1:

         <Period hours="Main" start="00:30" startOffset="0" end="01:00" endOffset="0" occupied="yes">
             <Illumination group="1" value="100" />
         </Period>


         Example 2:

         <Period hours="Main" start="sunrise" startOffset="0" end="sunset" endOffset="0" occupied="yes">
            <CoolSetpoint value="76" />
            <HeatSetpoint value="72" />
            <HVACMode value="2" />
            <FanMode value="1" />
         </Period>
         */

        final Element periodElement = doc.createElement("Period");

        if (qualitativeStartTime!=null)
        {
            periodElement.setAttribute("start", gpecQualitativeDailyTimeString(qualitativeStartTime));
        }
        else if (startTime!=null)
        {
            periodElement.setAttribute("start", LocalTimeHelper.formatLocalTime(startTime, false));
        }

        if (startOffsetInMinutes!=null)
        {
            periodElement.setAttribute("startOffset", String.valueOf(startOffsetInMinutes));
        }

        if (qualitativeEndTime!=null)
        {
            periodElement.setAttribute("end", gpecQualitativeDailyTimeString(qualitativeEndTime));
        }
        else if (endTime!=null)
        {
            periodElement.setAttribute("end", LocalTimeHelper.formatLocalTime(endTime, true));
        }

        if (endOffsetInMinutes!=null)
        {
            periodElement.setAttribute("endOffset", String.valueOf(endOffsetInMinutes));
        }

        if (occupied==Boolean.TRUE)
            periodElement.setAttribute("occupied", "yes");
        else if (occupied==Boolean.FALSE)
            periodElement.setAttribute("occupied", "no");

        periodElement.setAttribute("hours", "Main");

        return periodElement;
    }

    public static String gpecQualitativeDailyTimeString(final QualitativeDailyTime qualitativeDailyTime)
    {
        switch (qualitativeDailyTime)
        {
            case SUNRISE:
                return "sunrise";
            case SUNSET:
                return "sunset";
            case OPENING_TIME:
                return "open";
            case CLOSING_TIME:
                return "close";
            default:
                throw new UnsupportedOperationException("No support here for qualitative daily time "+qualitativeDailyTime);
        }
    }
}

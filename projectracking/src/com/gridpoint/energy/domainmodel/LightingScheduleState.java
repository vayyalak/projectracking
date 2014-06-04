package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * A scheduled set of lighting conditions.
 *
 * @author dhorlick
 */
public class LightingScheduleState implements DeviceScheduleState
{
    private Integer illumination = 100;

    /**
     * @return The illumination level. 0 is off, and 100 is full-on.
     */
    public Integer getIllumination()
    {
        return illumination;
    }

    public void setIllumination(final Integer designatedIllumination)
    {
        if (designatedIllumination!=null)
        {
            if (designatedIllumination<0)
                throw new IllegalArgumentException("Illumination cannot be below zero: "+designatedIllumination);

            if (designatedIllumination>100)
                throw new IllegalArgumentException("Illumination cannot exceed 100: "+designatedIllumination);
        }

        illumination = designatedIllumination;
    }

    public List<Element> toGpecConfigElements(final Document doc)
    {
        final List<Element> results = new ArrayList<Element>();

        /*
         * Example:
         *
         * <Illumination value="100" />
         */

        final Element illuminationElement = doc.createElement("Illumination");

        if (illumination!=null)
            illuminationElement.setAttribute("value", String.valueOf(illumination));
        else
            illuminationElement.setAttribute("value", "100"); // full-on

        results.add(illuminationElement);

        return results;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

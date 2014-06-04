package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author dhorlick
 */
public class DeviceScheduleEntry
{
    private DeviceScheduleState state;
    private Period period;

    public DeviceScheduleEntry(final DeviceScheduleState designatedState, final Period designatedPeriod)
    {
        state = designatedState;
        period = designatedPeriod;
    }

    public DeviceScheduleState getState()
    {
        return state;
    }

    public Period getPeriod()
    {
        return period;
    }

    public Element toGpecConfigElement(final Document doc)
    {
        final Element periodElement = period.toGpecConfigElement(doc);

        for (final Element subElement : state.toGpecConfigElements(doc))
            periodElement.appendChild(subElement);

        return periodElement;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

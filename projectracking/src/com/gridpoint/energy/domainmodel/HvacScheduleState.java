package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * A scheduled set of HVAC conditions.
 *
 * @author dhorlick
 */
public class HvacScheduleState implements DeviceScheduleState
{
    private HVACMode hvacMode;
    private FanMode fanMode;
    private Integer coolSetPointInDegreesFahrenheit;
    private Integer heatSetpointInDegreesFahrenheit;

    public HVACMode getHvacMode()
    {
        return hvacMode;
    }

    public void setHvacMode(final HVACMode hvacMode)
    {
        this.hvacMode = hvacMode;
    }

    public FanMode getFanMode()
    {
        return fanMode;
    }

    public void setFanMode(final FanMode fanMode)
    {
        this.fanMode = fanMode;
    }

    public Integer getCoolSetPointInDegreesFahrenheit()
    {
        return coolSetPointInDegreesFahrenheit;
    }

    public void setCoolSetPointInDegreesFahrenheit(final Integer coolSetPointInDegreesFahrenheit)
    {
        this.coolSetPointInDegreesFahrenheit = coolSetPointInDegreesFahrenheit;
    }

    public Integer getHeatSetpointInDegreesFahrenheit()
    {
        return heatSetpointInDegreesFahrenheit;
    }

    public void setHeatSetpointInDegreesFahrenheit(final Integer heatSetpointInDegreesFahrenheit)
    {
        this.heatSetpointInDegreesFahrenheit = heatSetpointInDegreesFahrenheit;
    }

    public List<Element> toGpecConfigElements(final Document doc)
    {
        final List<Element> results = new ArrayList<Element> ();

        /*
         Examples:

        <CoolSetpoint value="76" />
        <HeatSetpoint value="72" />
        <HVACMode value="2" />
        <FanMode value="1" />
         */

        if (coolSetPointInDegreesFahrenheit!=null)
        {
            final Element coolSetpointElement = doc.createElement("CoolSetpoint");
            coolSetpointElement.setAttribute("value", String.valueOf(coolSetPointInDegreesFahrenheit));
            results.add(coolSetpointElement);
        }

        if (heatSetpointInDegreesFahrenheit!=null)
        {
            final Element heatSetpointElement = doc.createElement("HeatSetpoint");
            heatSetpointElement.setAttribute("value", String.valueOf(heatSetpointInDegreesFahrenheit));
            results.add(heatSetpointElement);
        }

        if (fanMode!=null)
        {
            final Element fanModeElement = doc.createElement("FanMode");

            switch (fanMode)
            {
                case AUTO:
                    fanModeElement.setAttribute("value", "1");
                    break;
                case CONSTANT:
                    fanModeElement.setAttribute("value", "0");
                    break;
            }

            results.add(fanModeElement);
        }

        if (hvacMode!=null)
        {
            final Element hvacModeElement = doc.createElement("HVACMode");

            /*
             The valid values for this attribute are the integers 0, 1, 2, 3 and 4, where 0 is hvac mode OFF,
             1 is hvac mode COOL, 2 is hvac mode heat, 3 is hvac mode AUTO and 4 is hvac mode EMERGENCY-HEAT.
             */

            switch (hvacMode)
            {
                case OFF:
                    hvacModeElement.setAttribute("value", "0");
                    break;
                case AUTO:
                    hvacModeElement.setAttribute("value", "3");
                    break;
                case COOL:
                    hvacModeElement.setAttribute("value", "1");
                    break;
                case EMERGENCY_HEAT:
                    hvacModeElement.setAttribute("value", "4");
                    break;
                case HEAT:
                    hvacModeElement.setAttribute("value", "2");
                    break;
            }

            results.add(hvacModeElement);
        }

        return results;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

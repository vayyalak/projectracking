package com.gridpoint.energy.domainmodel;

/**
 * @author dhorlick
 */
public enum UnitType
{
    LIGHTING, HVAC;

    public static UnitType from(String string)
    {
        if (string==null)
            return null;
        for (final UnitType value : values())
        {
            if (value.toString().equalsIgnoreCase(string))
                return value;
        }

        return null;
    }
}

package com.gridpoint.energy.domainmodel;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumerates units of measurement commonly used as the {@link DataDictionaryType#unit} as identified in base_data.sql
 * @see DataDictionaryType
 */
public class Unit {
    private static final Logger logger = Logger.getLogger(Unit.class);

    // Known constants

    /**
     * kilowatts (power)
     */
    public static final String KW = "kw";

    /**
     * watts (power)
     */
    public static final String WATTS = "watts";

    /**
     * kilowatt-hours (energy)
     */
    public static final String KWH = "kwh";

    /**
     * British thermal units (energy)
     */
    public static final String KBTUS = "kbtus";

    /**
     * centicubic feet (volume). 100 cubic feet, typically of natural gas.
     */
    public static final String CCF = "ccf";

    /**
     * Units that measure power.
     */
    protected static final List<String> powerUnits = new ArrayList<String>();

    /**
     * Units that measure energy.
     */
    protected static final List<String> energyUnits = new ArrayList<String>();

    /**
     * Units that measure energy.
     */
    protected static final List<String> volumeUnits = new ArrayList<String>();


    // Static constructor
    static {

        // Initialize power units.
        powerUnits.add(KW);
        powerUnits.add(WATTS);

        // Initialize energy units.
        energyUnits.add(KWH);

        // Initialize volume units.
    }

    /**
     * Gets all the Unit constants
     * @return all the Unit constants
     */
    public static String[] values() {

        // Return a new array to prevent any threading issues.
        return new String[] {
            KW,
            WATTS,
            KWH,
            KBTUS,
            CCF,
        };
    }


    /**
     * Determines whether or not a unit measures power.
     * @param unit the unit of interest
     * @return {@code true} if the unit measures power; otherwise, {@code false}.
     */
    public static boolean isPower(String unit) {
        synchronized (powerUnits) {
            return powerUnits.contains(unit);
        }
    }

    /**
     * Determines whether or not a unit measures energy.
     * @param unit the unit of interest
     * @return {@code true} if the unit measures energy; otherwise, {@code false}.
     */
    public static boolean isEnergy(String unit) {
        synchronized (energyUnits) {
            return energyUnits.contains(unit);
        }
    }

    /**
     * Determines whether or not a unit measures volume.
     *
     * @param unit the unit of interest
     * @return {@code true} if the unit measures volume; otherwise, {@code false}.
     */
    public static boolean isVolume(String unit) {
        synchronized (volumeUnits) {
            return volumeUnits.contains(unit);
        }
    }

    /**
     * Gets the factor by which to multiply values in one unit to convert the value to another.
     * @param fromUnit the unit from which to convert
     * @param toUnit the unit to which to convert
     * @return the factor by which to multiply values measured in {@code fromUnit} to create values in {@code toUnit}
     * @throws NullPointerException if {@code fromUnit} is null
     * @throws IllegalArgumentException if {@code fromUnit} cannot be linearly converted to {@code toUnit}
     */
    public static double getConversionFactor(String fromUnit, String toUnit) {
        Double conversionFactor = null;
        
        fromUnit = fromUnit.toLowerCase();
        toUnit = toUnit.toLowerCase();

        if (fromUnit.equals(toUnit)) {
            conversionFactor = 1D;
        } else

        // power -> power or power -> energy or energy -> power
        // We use a linear conversion with the assumption that the time unit is hours.
        if (KWH.equals(fromUnit) || KW.equals(fromUnit)) {
            if (WATTS.equals(toUnit)) {
                conversionFactor = 1000D;
            } else if (KWH.equals(toUnit) || KW.equals(toUnit)) {
                conversionFactor = 1D;
            }
        } else if (WATTS.equals(fromUnit) &&
                (KW.equals(toUnit) || KWH.equals(toUnit))) {
            conversionFactor = 0.001D;
        } else

        // energy -> energy
        if (KWH.equals(fromUnit) && KBTUS.equals(toUnit)) {
            conversionFactor = 3.41214D;
        } else if (KWH.equals(fromUnit) && KBTUS.equals(toUnit)) {
            conversionFactor = 102.7D;
        }

        // not supported
        if (conversionFactor == null) {
            throw new IllegalArgumentException("getConversionFactor:  " + fromUnit + " cannot be linearly converted to " + toUnit);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("getConversionFactor(" + fromUnit + ",  " + toUnit + ") returning " + conversionFactor);
        }
        return conversionFactor;
    }
}

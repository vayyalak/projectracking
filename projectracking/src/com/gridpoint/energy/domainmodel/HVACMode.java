package com.gridpoint.energy.domainmodel;

/**
 * Valid mode settings for an HVAC system
 */
public enum HVACMode {
    
    // DEVELOPERS: Changing these enumerations will affect the ability to convert values
    // stored in the bulk data store for DataDictionaryType with the name DataDictionaryTypeName.HVAC_MODE

    /**
     * Compressor set to off. Neither heating nor cooling will occur.
     */
    // This shares a portal code with FAN.
    OFF(0, "X"),

    /**
     * Compressor will cycle between heating and cooling modes automatically based on the internal temperature's relationship to the heating
     * and cooling setpoint values. This setting is only possible for dual-mode thermostats.
     */
    AUTO(3, "A"),

    /**
     * Compressor will turn on when the internal temperature drops below the heating setpoint and will stay on until the heating setpoint is
     * exceeded by some internal threshold.
     */
    // This shares a portal code with EMERGENCY_HEAT
    HEAT(2, "H"),

    /**
     * Compressor will turn on when the internal temperature exceeds the cooling setpoint and will stay on until the temperature drops below
     * some threshold of the cooling setpoint.
     */
    COOL(1, "C"),

    // The portal does not support EMERGENCY_HEAT, so make sure this is declared after HEAT so that findByCode() will work correctly for the portal.
    EMERGENCY_HEAT(4, "H"),

    // The portal does not support FAN, so make sure this is declared after OFF so that findByCode() will work correctly for the portal.
    FAN(5, "X");

    private int intValue;

    /** the HVAC value in configuration JSON as provided by the portal */
    // See EditHvacSchedule.mxml
    private String code;

    private HVACMode(int intValue, String code) {
        this.intValue = intValue;
        this.code = code;
    }

    public int intValue() {
        return intValue;
    }

    /**
     * Gets the HVAC value in configuration JSON as provided by the portal.
     * @return the HVAC value in configuration JSON as provided by the portal
     */
    public String getCode() {
        return code;
    }

    public static HVACMode findByCode(String code) {
        for (HVACMode mode : values()) {
            if (mode.getCode().equals(code)) {
                return mode;
            }
        }
        return null;
    }

    public static HVACMode findByIntValue(Integer intValue) {
        if (intValue == null) {
            return null;
        }
        for (HVACMode mode : values()) {
            if (mode.intValue() == intValue) {
                return mode;
            }
        }
        return null;
    }
}

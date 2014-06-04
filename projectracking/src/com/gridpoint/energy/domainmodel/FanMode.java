package com.gridpoint.energy.domainmodel;

/**
 * Valid mode settings for an HVAC system
 */
public enum FanMode {

    /** Indicates the fan is always on. **/
    CONSTANT("C", 0),

    /** Indicates the fan is managed automatically by the thermostat. */
    AUTO("A", 1),

    /** Indicates the fan is always on when the building is occupied. */
    OCCUPIED("O", null);

    /** the value in configuration JSON as provided by the portal */
    // See EditHvacSchedule.mxml
    private String code;

    /** the value of this option in the GPEC configuration file */
    private Integer gpecValue;

    private FanMode(String code, Integer gpecValue) {
        this.code = code;
        this.gpecValue = gpecValue;
    }

    /**
     * Gets the value in configuration JSON as provided by the portal.
     * @return the value in configuration JSON as provided by the portal
     */
    public String getCode() {
        return code;
    }

    public Integer getGpecValue() {
        return gpecValue;
    }

    public static FanMode findByCode(String code) {
        for (FanMode fanMode : values()) {
            if (fanMode.getCode().equals(code)) {
                return fanMode;
            }
        }

        return null;
    }
}

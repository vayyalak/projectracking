package com.gridpoint.energy.domainmodel;

/**
 * Enumerates commonly-used values for {@link DataDictionaryType#name} property.
 */
// DEVELOPERS: If you modify this class, please modify the corresponding values in base_data.sql
public class DataDictionaryTypeName {
    /**
     * AC power factor
     */
    public final static String METER_POWER_FACTOR = "METER_POWER_FACTOR";

    /**
     * AC line frequency
     */
    public final static String METER_POWER_FREQUENCY = "METER_POWER_FREQUENCY";

    /**
     * Cumulative power received from grid
     */
    public final static String METER_RECEIVED = "METER_RECEIVED";

    /**
     * Cumulative power delivered to grid
     */
    public final static String METER_DELIVERED = "METER_DELIVERED";

    /**
     * Voltage on leg 1 (A-N)
     */
    public final static String METER_VOLTAGE_L1 = "METER_VOLTAGE_L1";

    /**
     * Voltage on leg 2 (B-N)
     */
    public final static String METER_VOLTAGE_L2 = "METER_VOLTAGE_L2";

    /**
     * Current on leg 1 (A)
     */
    public final static String METER_CURRENT_L1 = "METER_CURRENT_L1";

    /**
     * Current on leg 2 (A)
     */
    public final static String METER_CURRENT_L2 = "METER_CURRENT_L2;";

    /**
     * Estimated level of depleted battery energy
     */
    public final static String BATTERY_DISCHARGED = "BATTERY_DISCHARGED";

    /**
     * Rated capacity of the batteries
     */
    public final static String BATTERY_RATEDCAP = "BATTERY_RATEDCAP";

    /**
     * Estimated total energy capacity of the batteries, adjusted for temperature, rate of discharge, and age
     */
    public final static String BATTERY_USABLECAP = "BATTERY_USABLECAP";

    /**
     * Non-temperature-compensated battery voltage
     */
    public final static String BATTERY_VOLTAGE = "BATTERY_VOLTAGE";

    /**
     * Real power going out to secure circuit.
     * (always >= 0)
     */
    public final static String SECURE_POWER = "SECURE_POWER";

    /**
     * Voltage on secure circuit, or 0 if not active
     */
    public final static String SECURE_VOLTAGE = "SECURE_VOLTAGE";

    /**
     * Power flowing across meter (positive = from grid, negative = to grid)
     */
    public final static String ELECTRIC_METER_DATA = "ELECTRIC_METER_DATA";

    /**
     * Fan mode.  Expected values are "OFF" and "AUTO".
     *
     * @see {@link FanMode}
     */
    public final static String FAN_MODE = "FAN_MODE";

    /**
     * HVAC mode, expected values are "OFF", "AUTO", "HEAT", "COOL"
     *
     * @see {@link HVACMode}
     */
    public final static String HVAC_MODE = "HVAC_MODE";

    /**
     * Thermostat cooling setpoint
     */
    public final static String COOLING_SET_POINT = "COOLING_SET_POINT";

    /**
     * Thermostat heating setpoint
     */
    public final static String HEATING_SET_POINT = "HEATING_SET_POINT";

    /**
     * Internal temperature of a device.
     */
    public final static String INTERNAL_TEMP = "INTERNAL_TEMP";

    /**
     * The units in which the device displays temperature; {@code false} for Celsius, {@code true} for Fahrenheit.
     */
    public final static String DEGREE_UNIT = "DEGREE_UNIT";

    /**
     * Whether the relay is off/open ({@code false}) or on/closed ({@code true}).
     */
    public final static String RELAY_STATE = "RELAY_STATE";

    /**
     * The time that an endpoint or device last communicated with the server.
     */
    public final static String LAST_HEART_BEAT = "LAST_HEART_BEAT";

    /**
     * Percentage of writable flash memory free.
     */
    public final static String SYSTEM_MEMORY_LOAD = "SYSTEM_MEMORY_LOAD";

    /**
     * EVSE Amp usage
     */
    public final static String AMPS_AC = "AMPS_AC";

    /**
     * "Tempurature in Degrees Fahrenheit"
     */
    public final static String TEMP_F = "TEMP_F";

    /**
     * "Kilo Volt Amps"
     */
    public final static String KVA = "KVA";

    /**
     * "Kilo Volt Amps Reactive"
     */
    public final static String KVAR = "KVAR";

    /**
     * "Kilo Watts"
     */
    public final static String KW = "KW";

    /**
     * "volts alternating current"
     */
    public final static String VOLTS_AC = "VOLTS_AC";

    /**
     * "Minutes"
     */
    public final static String MINUTES = "MINUTES";

    /**
     * "Percent Relative Humidity"
     */
    public final static String PERCENT_RELATIVE_HUMIDITY = "PERCENT_RELATIVE_HUMIDITY";

    /**
     * "Cubic Feet"
     */
    public final static String CUBIC_FEET = "CUBIC_FEET";

    /**
     * "Operations"
     */
    public final static String OPERATIONS = "OPERATIONS";

    /**
     * "Standard Cubic Feet Per Minute"
     */
    public final static String STANDARD_CUBIC_FEET_PER_MINUTE = "STANDARD_CUBIC_FEET_PER_MINUTE";

    /**
     * "Tenths Of Inch"
     */
    public final static String TENTHS_OF_INCH = "TENTHS_OF_INCH";

    /**
     * "Pounds Per Square Inch"
     */
    public final static String POUNDS_PER_SQUARE_INCH = "POUNDS_PER_SQUARE_INCH";

    /**
     * "Power Factor"
     */
    public final static String POWER_FACTOR = "POWER_FACTOR";

    /**
     * "Seconds"
     */
    public final static String SECONDS = "SECONDS";

    /**
     * "Parts Per Million"
     */
    public final static String PARTS_PER_MILLION = "PARTS_PER_MILLION";

    /**
     * "Gallons"
     */
    public final static String GALLONS = "GALLONS";

    /**
     * "Inches"
     */
    public final static String INCHES = "INCHES";

    /**
     * "Million BTU"
     */
    public final static String MILLION_BTU = "MILLION_BTU";

    /**
     * "Percent"
     */
    public final static String PERCENT = "PERCENT";

    /**
     * "Ogre Noise"
     */
    public final static String OGRE_NOISE = "OGRE_NOISE";

    /**
     * EVSE Charge Station State
     */
    public final static String EVSE_STATE = "EVSE_STATE";

    /**
     * EVSE Fault status
     */
    public final static String EVSE_FAULT = "EVSE_FAULT";

    /**
     * EVSE KWH Reading
     */
    public final static String KWH = "KWH";

    /**
     * Unique EVSE Id
     */
    public final static String EVSE_ID = "EVSE_ID";

    /**
     * Vehicle ID
     */
    public final static String VIN = "VIN";

    /**
     * EVSE User
     */
    public final static String USER_ID = "USER_ID";

    /**
     * EVSE State of charge
     */
    public final static String SOC = "SOC";

    /**
     * Zone Temperature
     */
    public final static String ZONE_TEMP = "Zone Temperature";

    public final static String EVSE_AC_ENERGY_IN = "EVSE_AC_ENERGY_IN";
    public final static String EVSE_AC_ENERGY_OUT = "EVSE_AC_ENERGY_OUT";
    public final static String EVSE_STATE_OF_CHARGE = "EVSE_STATE_OF_CHARGE";
    public final static String EVSE_INSTANTANEOUS_POWER = "EVSE_INSTANTANEOUS_POWER";
    public final static String EVSE_VOLTS_AC = "EVSE_VOLTS_AC";
    public final static String EVSE_CURRENT_AC = "EVSE_CURRENT_AC";
    public final static String EVSE_TEMPERATURE = "EVSE_TEMPERATURE";

    public static final String LAST_UPDATE_TIME = "LAST_UPDATE";
    
    
    public static final String HVAC_ZONE_TEMP = "HVAC_ZONE_TEMP";

    /** Thermostat heating setpoint */
    public static final String HVAC_HEAT_POINT = "HVAC_HEAT_POINT";

    /** Thermostat cooling setpoint */
    public static final String HVAC_COOL_POINT = "HVAC_COOL_POINT";

    /** Thermostat fan mode; e.g. auto, on, off, or occupied */
    public static final String HVAC_FAN_MODE = "HVAC_FAN_MODE";
    public static final String HVAC_Y1_STATE = "HVAC_Y1_STATE";
    public static final String HVAC_W1_STATE = "HVAC_W1_STATE";
    public static final String HVAC_Y1_RUNTIME = "HVAC_Y1_RUNTIME";
    public static final String HVAC_W1_RUNTIME = "HVAC_W1_RUNTIME";

    public static final String SOLAR = "Solar";

    public static final String LIGHTING_KW = "LIGHTING_KW";

    public static final String MAINLOAD_VOLTAGE_PHASE_A_NEUTRAL = "MAINLOAD_VOLTAGE_PHASE_A_NEUTRAL";
    public static final String MAINLOAD_VOLTAGE_PHASE_B_NEUTRAL = "MAINLOAD_VOLTAGE_PHASE_B_NEUTRAL";
    public static final String MAINLOAD_VOLTAGE_PHASE_C_NEUTRAL = "MAINLOAD_VOLTAGE_PHASE_C_NEUTRAL";

    // Phase-to-phase voltage.  See JIRA issue GPUP-9261.
    public static final String MAINLOAD_VOLTAGE_PHASE_A_PHASE_B = "MAINLOAD_VOLTAGE_PHASE_A_PHASE_B";
    public static final String MAINLOAD_VOLTAGE_PHASE_B_PHASE_C = "MAINLOAD_VOLTAGE_PHASE_B_PHASE_C";
    public static final String MAINLOAD_VOLTAGE_PHASE_C_PHASE_A = "MAINLOAD_VOLTAGE_PHASE_C_PHASE_A";

    public static final String MAINLOAD_KW = "MAINLOAD_KW";
    public static final String VIRTUAL = "VIRTUAL";
}

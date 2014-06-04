package com.gridpoint.energy.domainmodel;

/**
 * A list of measurement type names used by this code base.
 * This is not a complete list of the measurement types.  Note that in order for toString() to work as expected,
 * the spelling of each value must match the spelling of the measure_type name column in the gpup data store.
 */
public enum MeasureTypeName {
    ENERGY,
    POWER_DEMAND,
    VOLTAGE_IMBALANCE_PHASE_TO_PHASE,
    VOLTAGE_IMBALANCE_PHASE_TO_NEUTRAL,
    VOLTAGE_PHASE_TO_PHASE,
    VOLTAGE_PHASE_TO_NEUTRAL,
	SOLAR_SYSTEM_SIZE,
	POWER_PRODUCTION,
}

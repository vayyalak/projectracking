package com.gridpoint.energy.domainmodel;

/**
 * A list of units of measurement names used by this code base.
 * This is not a complete list of units.  Note that in order for toString() to work as expected,
 * the spelling of each value must match the spelling of the unit_of_measure name column in the gpup data store.
 */
public enum UnitOfMeasureName {
    KILOWATT,
    KILOWATT_HOUR,
    PERCENTAGE,
    VOLTAGE,
}

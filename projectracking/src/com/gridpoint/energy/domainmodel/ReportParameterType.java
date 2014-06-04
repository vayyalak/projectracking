package com.gridpoint.energy.domainmodel;

/**
 * Describe the possible types for a report parameter value
 * @author mrochon
 *
 */
public enum ReportParameterType {

    PREMISES_LIST,
    START_DATE,
    END_DATE,
    DOUBLE,
    LONG,
    LOCAL_DATE_TIME,
    STRING,
    BOOLEAN,
    DATA_DICTIONARY_TYPE_LIST,
    CHANNEL_LIST,
    GENERIC_LIST,
    INTERVAL,
    BUTTON, // used for advanced report. never deserialized
    TEXT_DISPLAY; // used for advanced report. never deserialized

}

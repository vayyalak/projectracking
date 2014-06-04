package com.gridpoint.energy.domainmodel;

/**
 * Enumerates the names of known endpoint properties.
 * <p/>
 * These correspond to acceptable values for the EndpointMetadataEntity name property
 * as outlined in the endpoint_metadata_key table of the GPUP schema.
 */
public class EndpointPropertyName {
    // DEVELOPERS: If you change this file, please change the corresponding values in base_data.sql (dataModel module).

    /**
     * The password most recently assigned to the endpoint.
     */
    public static final String CURRENT_PASSWORD = "CURRENT_PASSWORD";

    /**
     * The default password assigned to the endpoint when it was manufactured.
     * <p/>
     * This default password is used by protocol adapters to authenticate endpoints.
     * An endpoint that uses its default password either is freshly manufactured or
     * has been reset to its initial state (factory reset).
     */
    public static final String DEFAULT_PASSWORD = "DEFAULT_PASSWORD";

    /**
     * The serial number assigned to the endpoint.  Note that this may be an arbitrary string, not a set of digits.
     * This allows customers, installers, customer service to identify an endpoint
     * based on its assigned serial number, which is usually a sticker or stamp on
     * the physical endpoint hardware.  The endpoint ID is not accessible outside
     * the GPUP framework.
     */
    public static final String SERIAL_NUMBER = "SERIAL_NUM";
    
    /**
     * A firmware update is currently in progress on this endpoint, or it will be as soon as it enters maintenance mode. 
     * The server knows because we sent them the firmware update binary data. 
     * If the endpoint receives the binary data any other way this will not be set.
     */
    public static final String UPDATE_IN_PROGRESS = "UPDATE_IN_PROGRESS";
}

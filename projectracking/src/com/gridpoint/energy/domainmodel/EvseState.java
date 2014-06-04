package com.gridpoint.energy.domainmodel;

/**
 * Enumerates EVSE states and actions.
 */
public enum EvseState {
    /**
     * Indicates that no vehicle is plugged in to the EVSE.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_UNPLUGGED_IDLE.
     */
    UNPLUGGED_IDLE(10),

    /**
     * Indicates that the EVSE needs service.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_NEEDS_SERVICE.
     */
    NEEDS_SERVICE(11),

    /**
     * Indicates that the EVSE has encountered a fault.  Repeated faults may cause the EVSE to subsequently change to the {@link #NEEDS_SERVICE} state.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_FAULT.
     */
    FAULT(12),

    /**
     * Indicates that the EVSE is charging, moving energy from the Grid to a vehicle.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_CHARGING.
     */
    CHARGING(13),

    /**
     * Indicates that the EVSE has a vehicle plugged in and is authorized and ready to charge/discharge.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_PLUGGED_IN_READY.
     */
    PLUGGED_IN_READY(14),

    /**
     * Indicates that the EVSE has a vehicle plugged in, but it has not yet been authorized to charge/discharge.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_STANDBY.
     */
    STANDBY(15),

    /**
     * Indicates that the EVSE is discharging energy from a vehicle to the Grid.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_DISCHARGING.
     */
    DISCHARGING(16),

    /**
     * Indicates that the EVSE has not sent a heartbeat signal recently.
     */
    OFFLINE(17),

    /**
     * Unlike the other enumerations, this not a persistent state, but an instantaneous event indicating
     * that the EVSE has requested authentication for a user operation.
     * For example, authentication may be requested in order to begin an EVSE charging session.
     */
    AUTHENTICATION_REQUESTED(18),

    /**
     * Unlike the other enumerations, this not a persistent state, but an instantaneous event indicating
     * that an authorization directive (e.g. allow or deny) has been issued to the EVSE for a user operation.
     * This may be in response to an authentication request or may be an asynchronous (server-initiated) authorization.
     */
    AUTHORIZATION_ISSUED(19),

    /**
     * The Endpoint has discovered the device signifying a reboot.
     * The Session should end.
     * Corresponds to com.gridpoint.energy.endpointadapters.geepadapter.model.GeepEventTypes.EVSE_DISCOVERY.
     */
    EVSE_DISCOVERY(20);

    private final int val;

    EvseState( int val ) {
        this.val = val;
    }

    public static EvseState fromInt( int val ) {
        switch(val) {
            case 10:
                return(UNPLUGGED_IDLE);
            case 11:
                return( NEEDS_SERVICE );
            case 12:
                return( FAULT );
            case 13:
                return( CHARGING );
            case 14:
                return(PLUGGED_IN_READY);
            case 15:
                return( STANDBY );
            case 16:
                return(DISCHARGING);
            case 17:
                return(OFFLINE);
            case 18:
                return(AUTHENTICATION_REQUESTED);
            case 19:
                return(AUTHORIZATION_ISSUED);
            case 20:
                return(EVSE_DISCOVERY);
        }
        return( null );
    }

    public int toInt() {
        return( val );
    }
}

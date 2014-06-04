package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown upon receipt of an incomplete device state or a device state mismatch.
 * 
 * For example, a method processing information for a tstat device would throw this method
 * upon receiving a relay device state object.
 *
 */
public class InvalidDeviceStateException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidDeviceStateException () {
        super();
    }

    public InvalidDeviceStateException (String message) {
        super(message);
    }
    
    public InvalidDeviceStateException (String message, Throwable caught) {
        super(message, caught);
    }
    
    public InvalidDeviceStateException (Throwable caught) {
        super(caught);
    }
}
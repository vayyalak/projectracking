package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown when a device type object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 * 
 */
public class InvalidDeviceTypeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -6480614008036253057L;

    public InvalidDeviceTypeException() {
        super();
    }

    public InvalidDeviceTypeException(String message) {
        super(message);
    }
}

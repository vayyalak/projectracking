package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown when a device make object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 * 
 */
public class InvalidDeviceMakeException extends Exception {


    /**
     * 
     */
    private static final long serialVersionUID = 2000623026258667467L;

    public InvalidDeviceMakeException() {
        super();
    }

    public InvalidDeviceMakeException(String message) {
        super(message);
    }
}

package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown when an endpoint object cannot be resolved based on the 
 * serial number provided to the throwing method.
 * 
 */
public class InvalidReferenceIdException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidReferenceIdException() {
        super();
    }

    public InvalidReferenceIdException(String message) {
        super(message);
    }
}

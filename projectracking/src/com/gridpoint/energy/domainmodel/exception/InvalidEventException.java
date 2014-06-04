package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown when a event object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 *
 */
public class InvalidEventException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidEventException() {
        super();
    }

    public InvalidEventException(String message) {
        super(message);
    }
}

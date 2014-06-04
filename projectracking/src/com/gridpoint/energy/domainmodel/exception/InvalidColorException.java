package com.gridpoint.energy.domainmodel.exception;


/**
 *
 * This exception is thrown when a device object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 *
 */
public class InvalidColorException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidColorException() {
        super();
    }

    public InvalidColorException(String message) {
        super(message);
    }
}

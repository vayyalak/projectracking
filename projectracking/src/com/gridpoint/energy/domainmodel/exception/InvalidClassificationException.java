package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown when a classification object cannot be resolved.
 * 
 */
public class InvalidClassificationException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidClassificationException() {
        super();
    }

    public InvalidClassificationException(String message) {
        super(message);
    }
}

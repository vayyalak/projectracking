package com.gridpoint.energy.domainmodel.exception;


/**
 *
 * This exception is thrown if an email address does not meet the requirements of
 * the throwing method.  
 * 
 * Failure to meet method requirements may include failure to
 * have correct email syntax upon email address update or failure to be unique upon
 * registration.
 *
 */
public class InvalidEmailException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidEmailException() {
        super();
    }

    public InvalidEmailException(String message) {
        super(message);
    }
}

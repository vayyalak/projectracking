package com.gridpoint.energy.domainmodel.exception;


/**
 *
 * This exception is thrown when an attempt is made to delete a
 * non-customizable mode
 *
 */
public class GeneralServiceException extends Exception {

    private static final long serialVersionUID = 0L;

    public GeneralServiceException () {
        super();
    }

    public GeneralServiceException (String message) {
        super(message);
    }
    public GeneralServiceException (String message, Throwable cause) {
        super(message, cause);
    }
    public GeneralServiceException (Throwable cause) {
        super(cause);
    }
}
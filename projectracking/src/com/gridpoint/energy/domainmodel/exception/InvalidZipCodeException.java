package com.gridpoint.energy.domainmodel.exception;


/**
 *
 * This exception is thrown when an invalid zip code is provided
 *
 */
public class InvalidZipCodeException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidZipCodeException ()
    {
        super();
    }

    public InvalidZipCodeException (Throwable t)
    {
        super(t);
    }

    public InvalidZipCodeException(String message) {
        super(message);
    }
}

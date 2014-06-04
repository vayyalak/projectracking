package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown upon failure to validate a TimeSpan object.
 * 
 * For example, a TimeSpan must have start date that preceeds the end date.
 *
 */
public class InvalidTimeRangeException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidTimeRangeException () {
        super();
    }

    public InvalidTimeRangeException (String message) {
        super(message);
    }
}
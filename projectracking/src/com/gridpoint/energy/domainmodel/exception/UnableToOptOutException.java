package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown if an attempt to opt-out of a demand response event fails.
 * 
 * Reasons why failure may occur include the event having been canceled or haven already completed.
 * Also, a failure to contact the load management service to register the opt-out may also trigger 
 * this exception.
 *
 */
public class UnableToOptOutException extends Exception {

    private static final long serialVersionUID = 0L;

    public UnableToOptOutException() {
        super();
    }

    public UnableToOptOutException(String message) {
        super(message);
    }
}

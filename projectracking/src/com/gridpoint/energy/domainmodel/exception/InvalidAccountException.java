package com.gridpoint.energy.domainmodel.exception;


/**
 * An exception thrown when a method requires an account ID and the ID provided is invalid.
 * 
 * @author mrochon
 *
 */
public class InvalidAccountException extends Exception {

    private static final long serialVersionUID = 1200511761265601214L;

    public InvalidAccountException() {
    }

    public InvalidAccountException(String message) {
        super(message);
    }

    public InvalidAccountException(Throwable cause) {
        super(cause);
    }

    public InvalidAccountException(String message, Throwable cause) {
        super(message, cause);
    }

}

package com.gridpoint.energy.domainmodel.exception;


/**
*
* This exception is thrown if a username does not meet the requirements of
* the throwing method.
*
* This may occur if a username does not meet length or pattern requirements or if
* the username already exists in the system.
*
*/
public class InvalidUsernameException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidUsernameException ()
    {
        super();
    }

    public InvalidUsernameException(String message) {
        super(message);
    }

    public InvalidUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUsernameException(Throwable cause) {
        super(cause);
    }
}

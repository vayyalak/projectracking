package com.gridpoint.energy.domainmodel.exception;


/**
*
* This exception is thrown if a user id does not meet the requirements of
* the throwing method.
*
* This may occur if a user id does not exist
*
*/
public class InvalidUserIdException extends Exception {
    private static final long serialVersionUID = 0L;

    public InvalidUserIdException ()
    {
        super();
    }

    public InvalidUserIdException(String message) {
        super(message);
    }

    public InvalidUserIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserIdException(Throwable cause) {
        super(cause);
    }

}

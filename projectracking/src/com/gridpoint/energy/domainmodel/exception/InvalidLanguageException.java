package com.gridpoint.energy.domainmodel.exception;


/**
*
* This exception is thrown if a language does not meet the requirements of
* the throwing method.
*
* This occurs if a language does not exist in the system.
*/
public class InvalidLanguageException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidLanguageException ()
    {
        super();
    }

    public InvalidLanguageException(String message) {
        super(message);
    }

    public InvalidLanguageException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLanguageException(Throwable cause) {
        super(cause);
    }
}

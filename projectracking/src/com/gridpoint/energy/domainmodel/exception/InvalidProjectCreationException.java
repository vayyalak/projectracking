package com.gridpoint.energy.domainmodel.exception;

public class InvalidProjectCreationException extends Exception {

	private static final long serialVersionUID = 0L;

	public InvalidProjectCreationException ()
    {
        super();
    }

    public InvalidProjectCreationException(String message) {
        super(message);
    }
    
    public InvalidProjectCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProjectCreationException(Throwable cause) {
        super(cause);
    }

}

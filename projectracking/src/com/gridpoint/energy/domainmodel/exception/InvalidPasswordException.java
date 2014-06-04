package com.gridpoint.energy.domainmodel.exception;


/**
*
* This exception is thrown if a password does not meet the requirements of
* the throwing method.
*
* This may occur if a password does not meet length or pattern requirements or if
* a password does not match a password confirmation parameter.
*
*/
public class InvalidPasswordException extends Exception {

    private static final long serialVersionUID = 0L;

	public InvalidPasswordException() {
		super();
	}

	public InvalidPasswordException(String message) {
		super(message);
	}
}

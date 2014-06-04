package com.gridpoint.energy.domainmodel.exception;

public class PasswordMismatchException extends Exception {

    private static final long serialVersionUID = 3778463395681152559L;

    public PasswordMismatchException() {
        super();
    }

    public PasswordMismatchException(String message) {
        super(message);
    }
}

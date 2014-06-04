package com.gridpoint.energy.domainmodel.exception;

/**
 * Indicates that an invalid or nonexistent peripheral was referenced.
 */
public class InvalidPeripheralException extends Exception {
    private static final long serialVersionUID = -6665149495330248308L;

    public InvalidPeripheralException() {
    }

    public InvalidPeripheralException(String s) {
        super(s);
    }

    public InvalidPeripheralException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidPeripheralException(Throwable throwable) {
        super(throwable);
    }
}

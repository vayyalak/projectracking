package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown when a device metadata object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 * 
 */
public class InvalidDeviceMetaDataException extends Exception {
    private static final long serialVersionUID = -6423812988164532116L;

    public InvalidDeviceMetaDataException() {
        super();
    }

    public InvalidDeviceMetaDataException(Throwable throwable) {
        super(throwable);
    }

    public InvalidDeviceMetaDataException(String s) {
        super(s);
    }

    public InvalidDeviceMetaDataException(String s, Throwable throwable) {
        super(s, throwable);
    }
}

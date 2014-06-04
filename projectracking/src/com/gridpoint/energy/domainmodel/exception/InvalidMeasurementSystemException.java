package com.gridpoint.energy.domainmodel.exception;


/**
*
* This exception is thrown if a measurement system does not meet the requirements of
* the throwing method.
*
* This occurs if a measurement system does not exist in the system.
*/
public class InvalidMeasurementSystemException extends Exception {

    private static final long serialVersionUID = 0L;

    public InvalidMeasurementSystemException ()
    {
        super();
    }

    public InvalidMeasurementSystemException(String message) {
        super(message);
    }

    public InvalidMeasurementSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMeasurementSystemException(Throwable cause) {
        super(cause);
    }
}

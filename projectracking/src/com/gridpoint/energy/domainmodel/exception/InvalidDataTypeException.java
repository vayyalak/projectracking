package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown when a data type cannot be resolved based on identifying
 * criteria provided to the throwing method.
 * 
 */
public class InvalidDataTypeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 4104797186352253251L;

    public InvalidDataTypeException() {
        super();
    }

    public InvalidDataTypeException(String message) {
        super(message);
    }
}

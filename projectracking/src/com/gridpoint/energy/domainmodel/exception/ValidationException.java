package com.gridpoint.energy.domainmodel.exception;


public class ValidationException extends Exception{

	/**
     * 
     */
    private static final long serialVersionUID = -8797031342255602635L;

    public ValidationException(String message){
    	super(message);
    }
}

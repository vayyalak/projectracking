package com.gridpoint.energy.domainmodel.exception;


/**
*
* This exception is thrown when a LegacyAdapter Service has no implementation for 
* the given time series data type
*
*/
public class DataSeriesTypeNotSupportedException extends Exception {
	private static final long serialVersionUID = 0L;
	
	public DataSeriesTypeNotSupportedException () {
        super();
    }

    public DataSeriesTypeNotSupportedException(String message) {
        super(message);
    }
}

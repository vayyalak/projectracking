package com.gridpoint.energy.domainmodel.exception;

import java.util.Date;


/**
 *
 * This exception is thrown when a invalid utility information
 * criteria provided to the throwing method.
 *
 */
public class InvalidUtilityBillException extends Exception {

    private static final long serialVersionUID = 0L;

    private long id;

    public InvalidUtilityBillException ()
    {
        super();
    }

    public InvalidUtilityBillException (Throwable t)
    {
        super(t);
    }

    public InvalidUtilityBillException(String message) {
        super(message);
    }

    public InvalidUtilityBillException(final long id)
    {
        super("Invalid account ID  #"+id);
        this.id = id;
    }

    public long getId()
    {
        return id;
    }
}

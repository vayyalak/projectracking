package com.gridpoint.energy.util.collection;

/**
 *
 */
public class OverlappingIntervalException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public OverlappingIntervalException ()
    {
    }

    public OverlappingIntervalException (String message)
    {
        super(message);
    }

    public OverlappingIntervalException (String message, Throwable cause)
    {
        super(message, cause);
    }

    public OverlappingIntervalException (Throwable cause)
    {
        super(cause);
    }
}

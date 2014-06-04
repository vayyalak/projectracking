package com.gridpoint.energy.domainmodel.exception;


/**
 *
 * This exception is thrown when a endpoint object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 *
 */
public class InvalidEndpointException extends Exception {

    private static final long serialVersionUID = 0L;

    private Long endpointId;

    public InvalidEndpointException ()
    {
        super();
    }

    public InvalidEndpointException(final long designatedEndpointId)
    {
        super("Invalid endpoint with id " + designatedEndpointId);
        endpointId = designatedEndpointId;

    }

    public InvalidEndpointException (String message) {
        super(message);
    }
    
    public InvalidEndpointException (Throwable cause) {
        super(cause);
    }

    public Long getEndpointId()
    {
        return endpointId;
    }
}
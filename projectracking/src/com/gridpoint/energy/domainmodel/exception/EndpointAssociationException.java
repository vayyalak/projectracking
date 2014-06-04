package com.gridpoint.energy.domainmodel.exception;


/**
 * 
 * This exception is thrown upon failure to associate or disassociate and endpoint with
 * a premises.  
 * 
 * This may occur in cases like a request to disassociate an endpoint which
 * is not already associated with the given premises or a case where an endpoint cannot be
 * associated with a given premises because it is already associated with another premises. 
 *
 */
public class EndpointAssociationException extends Exception {

    private static final long serialVersionUID = 0L;

    public EndpointAssociationException () {
        super();
    }

    public EndpointAssociationException (String message) {
        super(message);
    }
}
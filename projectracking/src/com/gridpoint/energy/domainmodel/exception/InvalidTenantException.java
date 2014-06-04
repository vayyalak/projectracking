package com.gridpoint.energy.domainmodel.exception;


/**
*
* This exception is thrown if a tenant does not meet the requirements of
* the throwing method.
*
*/
public class InvalidTenantException extends Exception {


    /**
     * 
     */
    private static final long serialVersionUID = 1372756677872160178L;

    public InvalidTenantException ()
    {
        super();
    }

    public InvalidTenantException(String message) {
        super(message);
    }
    
    public InvalidTenantException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTenantException(Throwable cause) {
        super(cause);
    }
}

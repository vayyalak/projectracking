package com.gridpoint.energy.domainmodel.exception;

public class ServiceException extends Exception{

    private static final long serialVersionUID = 5948352753948977710L;

    public ServiceException(Throwable t) {
        super(t);
    }

    public ServiceException(String msg, Throwable t) {
        super(msg, t);
    }

    public ServiceException(String msg) {
        super(msg);
    }
}

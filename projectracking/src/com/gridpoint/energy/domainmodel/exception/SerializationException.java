package com.gridpoint.energy.domainmodel.exception;

public class SerializationException extends Exception {

    private static final long serialVersionUID = 4176622176201961385L;

    public SerializationException() {
        super();
    }

    public SerializationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public SerializationException(String arg0) {
        super(arg0);
    }

    public SerializationException(Throwable arg0) {
        super(arg0);
    }

}

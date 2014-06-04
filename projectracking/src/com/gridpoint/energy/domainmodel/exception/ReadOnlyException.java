package com.gridpoint.energy.domainmodel.exception;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class ReadOnlyException extends Exception
{
    private static final long serialVersionUID = 1244L;
    private Serializable readOnlyEntity;

    public ReadOnlyException()
    {
        super();
    }

    public ReadOnlyException(final Throwable designatedThrowable)
    {
        super(designatedThrowable);
    }

    public ReadOnlyException(final Serializable designatedReadOnlyEntity)
    {
        readOnlyEntity = designatedReadOnlyEntity;
    }

    public ReadOnlyException(final String message, final Serializable designatedReadOnlyEntity)
    {
        super(message);
        readOnlyEntity = designatedReadOnlyEntity;
    }

    public Serializable getReadOnlyEntity()
    {
        return readOnlyEntity;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

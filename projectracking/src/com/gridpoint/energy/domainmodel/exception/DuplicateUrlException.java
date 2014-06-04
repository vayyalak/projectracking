package com.gridpoint.energy.domainmodel.exception;

import java.sql.SQLException;

public class DuplicateUrlException extends DuplicateException
{
    private static final long serialVersionUID = 12388L;

    public DuplicateUrlException()
    {
        super();
    }

    public DuplicateUrlException(final SQLException designatedSqlException)
    {
        super(designatedSqlException);
    }

    public DuplicateUrlException(final String designatedMessage)
    {
        super(designatedMessage);
    }
}
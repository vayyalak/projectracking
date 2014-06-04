package com.gridpoint.energy.domainmodel.exception;

import java.sql.SQLException;

public class InvalidVersionException extends DuplicateException {
	private static final long serialVersionUID = 12388L;

    public InvalidVersionException()
    {
        super();
    }

    public InvalidVersionException(final SQLException designatedSqlException)
    {
        super(designatedSqlException);
    }

    public InvalidVersionException(final String designatedMessage)
    {
        super(designatedMessage);
    }
}
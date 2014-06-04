package com.gridpoint.energy.domainmodel.exception;

import java.sql.SQLException;

public class DuplicateVersionException extends DuplicateException {
	private static final long serialVersionUID = 12388L;

    public DuplicateVersionException()
    {
        super();
    }

    public DuplicateVersionException(final SQLException designatedSqlException)
    {
        super(designatedSqlException);
    }

    public DuplicateVersionException(final String designatedMessage)
    {
        super(designatedMessage);
    }
}

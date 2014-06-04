package com.gridpoint.energy.domainmodel.exception;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Set;

public class DuplicateNameException extends DuplicateException
{
    private static final long serialVersionUID = 12387L;

    private String duplicatedName;

    public DuplicateNameException()
    {
        super();
    }

    public DuplicateNameException(final SQLException designatedSqlException)
    {
        super(designatedSqlException);
    }

    public DuplicateNameException(final String designatedDuplicatedName, final Set<? extends Serializable> duplicatedEntities)
    {
        super(duplicatedEntities);
        duplicatedName = designatedDuplicatedName;
    }

    public DuplicateNameException(final String designatedMessage)
    {
        super(designatedMessage);
    }

    public String getDuplicatedName()
    {
        return duplicatedName;
    }
}

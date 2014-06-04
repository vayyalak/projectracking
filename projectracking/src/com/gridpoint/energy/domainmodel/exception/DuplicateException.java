package com.gridpoint.energy.domainmodel.exception;

import java.io.Serializable;
import java.util.Set;

/**
 * Indicates that some property of a domain object improperly duplicates that property on another domain object
 * of the same type.
 */
public class DuplicateException extends Exception {
    private static final long serialVersionUID = 88490L;
    private Set<? extends Serializable> duplicatedEntities;

    public DuplicateException() {
        super();
    }

    public DuplicateException(final Throwable designatedThrowable) {
        super(designatedThrowable);
    }

    public DuplicateException(final String message) {
        super(message);
    }

    public DuplicateException(final Set<? extends Serializable> designatedDuplicatedEntities) {
        super(messagize(designatedDuplicatedEntities));
        duplicatedEntities = designatedDuplicatedEntities;
    }

    public DuplicateException(final String message, final Set<? extends Serializable> designatedDuplicatedEntities) {
        super(message + " " + messagize(designatedDuplicatedEntities));
        duplicatedEntities = designatedDuplicatedEntities;
    }

    public Set<? extends Serializable> getDuplicatedEntities() {
        return duplicatedEntities;
    }

    public static String messagize(final Set<? extends Serializable> designatedDuplicatedEntities) {
        if (designatedDuplicatedEntities == null || designatedDuplicatedEntities.size() == 0)
            return "?";

        final StringBuilder message = new StringBuilder();
        message.append(designatedDuplicatedEntities.size());
        message.append(" entity/entities of type: ");
        message.append(designatedDuplicatedEntities.iterator().next().getClass().getName());

        return message.toString();
    }
}

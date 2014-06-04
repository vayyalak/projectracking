package com.gridpoint.energy.domainmodel.exception;

/**
 * Thrown when a password fails strength rules.
 */
public class WeakPasswordException extends InvalidPasswordException
{
    private static final long serialVersionUID = 1L;

    public WeakPasswordException()
    {
    }

    public WeakPasswordException(final String designatedMessage)
    {
        super(designatedMessage);
    }
}

package com.gridpoint.energy.domainmodel.exception;

/**
 * Indicates that a provided firmware binary is demonstrably invalid.
 *
 * @author dhorlick
 */
@SuppressWarnings("serial")
public class InvalidFirmwareBinaryException extends Exception
{
    public InvalidFirmwareBinaryException()
    {
        super();
    }

    public InvalidFirmwareBinaryException(final Exception designatedCause)
    {
        super(designatedCause);
    }
}

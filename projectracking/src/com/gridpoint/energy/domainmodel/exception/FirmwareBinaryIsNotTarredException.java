package com.gridpoint.energy.domainmodel.exception;

import java.io.IOException;

/**
 * @author dhorlick
 */
@SuppressWarnings("serial")
public class FirmwareBinaryIsNotTarredException extends InvalidFirmwareBinaryException
{
    public FirmwareBinaryIsNotTarredException(final IOException designatedCause)
    {
        super(designatedCause);
    }
}

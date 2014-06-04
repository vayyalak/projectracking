package com.gridpoint.energy.domainmodel.exception;

import java.io.IOException;

/**
 * @author dhorlick
 */
@SuppressWarnings("serial")
public class FirmwareBinaryIsNotGzippedException extends InvalidFirmwareBinaryException
{
    public FirmwareBinaryIsNotGzippedException(final IOException designatedCause)
    {
        super(designatedCause);
    }
}

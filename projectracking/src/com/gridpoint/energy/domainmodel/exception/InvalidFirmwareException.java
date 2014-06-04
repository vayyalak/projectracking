package com.gridpoint.energy.domainmodel.exception;

/**
 * Requests references a non-existent firmware.
 *
 * @author dhorlick
 */
public class InvalidFirmwareException extends Exception
{
    private static final long serialVersionUID = 71204L;

    public InvalidFirmwareException() {
    }

    public InvalidFirmwareException(String s) {
        super(s);
    }

    public InvalidFirmwareException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidFirmwareException(Throwable throwable) {
        super(throwable);
    }
}

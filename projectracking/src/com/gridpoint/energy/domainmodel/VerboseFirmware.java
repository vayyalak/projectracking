package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Firmware, fully specified along with its binary executable.
 */
public class VerboseFirmware implements Serializable
{
    private static final long serialVersionUID = 409683409673489L;

    private Firmware firmware;
    private byte [] binaryExecutable;

    public Firmware getFirmware()
    {
        return firmware;
    }

    public void setFirmware(final Firmware designatedFirmware)
    {
        this.firmware = designatedFirmware;
    }

    public byte[] getBinaryExecutable()
    {
        return binaryExecutable;
    }

    public void setBinaryExecutable(final byte[] designatedBinaryExecutable)
    {
        this.binaryExecutable = designatedBinaryExecutable;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

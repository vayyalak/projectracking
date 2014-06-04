package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dhorlick
 */
public class GpecPeripheralFirmware implements Serializable
{
    private static final long serialVersionUID = 34898439493805L;

    private Long gpecPeripheralFirmwareId;

    private byte[] binaryExecutable;

    private int versionMajorNumber;

    private int versionMinorNumber;

    private Date releaseDate;

    private Boolean active;

    private String peripheralTypeName;

    private Integer minimumControllerFirmwareVersionMajorNumber;

    private Integer minimumControllerFirmwareVersionMinorNumber;

    private Integer minimumControllerFirmwareVersionRevisionNumber;

    private Date creationDate;

    public Long getGpecPeripheralFirmwareId()
    {
        return gpecPeripheralFirmwareId;
    }

    public void setGpecPeripheralFirmwareId(final Long designatedGpecPeripheralFirmwareId)
    {
        gpecPeripheralFirmwareId = designatedGpecPeripheralFirmwareId;
    }

    public byte[] getBinaryExecutable()
    {
        return binaryExecutable;
    }

    public void setBinaryExecutable(final byte[] designatedContent)
    {
        binaryExecutable = designatedContent;
    }

    public int getVersionMajorNumber()
    {
        return versionMajorNumber;
    }

    public void setVersionMajorNumber(final int designatedVersionMajorNumber)
    {
        versionMajorNumber = designatedVersionMajorNumber;
    }

    public int getVersionMinorNumber()
    {
        return versionMinorNumber;
    }

    public void setVersionMinorNumber(final int designatedVersionMinorNumber)
    {
        versionMinorNumber = designatedVersionMinorNumber;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(final Date designatedReleaseDate)
    {
        releaseDate = designatedReleaseDate;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(final Boolean designatedActive)
    {
        active = designatedActive;
    }

    public String getPeripheralTypeName()
    {
        return peripheralTypeName;
    }

    public void setPeripheralTypeName(final String designatedPeripheralTypeName)
    {
        peripheralTypeName = designatedPeripheralTypeName;
    }

    /**
     * @return The minimum corresponding controller firmware version major number.
     */
    public Integer getMinimumControllerFirmwareVersionMajorNumber()
    {
        return minimumControllerFirmwareVersionMajorNumber;
    }

    public void setMinimumControllerFirmwareVersionMajorNumber(final Integer designatedMinimumControllerFirmwareVersionMajorNumber)
    {
        minimumControllerFirmwareVersionMajorNumber = designatedMinimumControllerFirmwareVersionMajorNumber;
    }

    /**
     * @return The minimum corresponding controller firmware minor version number.
     */
    public Integer getMinimumControllerFirmwareVersionMinorNumber()
    {
        return minimumControllerFirmwareVersionMinorNumber;
    }

    public void setMinimumControllerFirmwareVersionMinorNumber(final Integer designatedMinimumControllerFirmwareVersionMinorNumber)
    {
        minimumControllerFirmwareVersionMinorNumber = designatedMinimumControllerFirmwareVersionMinorNumber;
    }

    public Integer getMinimumControllerFirmwareVersionRevisionNumber()
    {
        return minimumControllerFirmwareVersionRevisionNumber;
    }

    public void setMinimumControllerFirmwareVersionRevisionNumber(
            final Integer designatedMinimumControllerFirmwareVersionRevisionNumber)
    {
        minimumControllerFirmwareVersionRevisionNumber = designatedMinimumControllerFirmwareVersionRevisionNumber;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(final Date designatedCreationDate)
    {
        creationDate = designatedCreationDate;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * GPEC controller firmware.
 */
public class Firmware
        implements Serializable {
	private static final long serialVersionUID = 215811836767861152L;

	
	private Long firmwareId;
	
	private String name;
	
	private String version;

    private Date releaseDate;

    private Boolean active;

    private EndpointType endpointType;

	public void setFirmwareId(Long firmwareId ) {
		this.firmwareId = firmwareId;
	}

	public Long getFirmwareId() {
		return firmwareId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final Date designatedReleaseDate) {
        releaseDate = designatedReleaseDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean designatedActive) {
        active = designatedActive;
    }

    public EndpointType getEndpointType()
    {
        return endpointType;
    }

    public void setEndpointType(final EndpointType designatedEndpointType)
    {
        endpointType = designatedEndpointType;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

public class ConfigurationUnit implements Serializable {
	private static final long serialVersionUID = 5995654050768286363L;
	
	private Long configurationUnitId;
	
	private String configFileName;
	
	private String marker;
	
	private String transformation;
	
	private Long endpointId;

	public void setConfigurationUnitId(Long configurationUnitId) {
		this.configurationUnitId = configurationUnitId;
	}

	public Long getConfigurationUnitId() {
		return configurationUnitId;
	}

	public void setConfigFileName(String configFileName) {
		this.configFileName = configFileName;
	}

	public String getConfigFileName() {
		return configFileName;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public String getMarker() {
		return marker;
	}

	public void setTransformation(String transformation) {
		this.transformation = transformation;
	}

	public String getTransformation() {
		return transformation;
	}

	public Long getEndpointId() {
		return endpointId;
	}

	public void setEndpointId(Long endpointId) {
		this.endpointId = endpointId;
	}
	
	
	

}

package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

public class ChannelMetadata implements Serializable {
	private static final long serialVersionUID = 1L;
	private long channelMetadataId;
	private Boolean displayedByDefault;
	private MeasureType measureType;
	private ChannelMetadataCategory channelMetadataCategory;
	private UnitOfMeasure unitOfMeasure;
	
	public long getChannelMetadataId() {
		return this.channelMetadataId;
	}

	public void setChannelMetadataId(long channelMetadataId) {
		this.channelMetadataId = channelMetadataId;
	}

	public Boolean getDisplayedByDefault() {
		return displayedByDefault;
	}

	public void setDisplayedByDefault(Boolean displayedByDefault) {
		this.displayedByDefault = displayedByDefault;
	}

	public MeasureType getMeasureType() {
		return measureType;
	}

	public void setMeasureType(MeasureType measureType) {
		this.measureType = measureType;
	}

	public ChannelMetadataCategory getChannelMetadataCategory() {
		return channelMetadataCategory;
	}

	public void setChannelMetadataCategory(ChannelMetadataCategory channelMetadataCategory) {
		this.channelMetadataCategory = channelMetadataCategory;
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

}

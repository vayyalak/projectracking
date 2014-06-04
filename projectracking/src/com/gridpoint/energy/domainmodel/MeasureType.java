package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

public class MeasureType implements Serializable {
	private static final long serialVersionUID = 1L;
	private long measureTypeId;
	private String name;
	public long getMeasureTypeId() {
		return measureTypeId;
	}
	public void setMeasureTypeId(long measureTypeId) {
		this.measureTypeId = measureTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

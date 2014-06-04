package com.gridpoint.energy.domainmodel;
import java.io.Serializable;

public class UnitOfMeasure implements Serializable {
	private static final long serialVersionUID = 1L;
	private long unitOfMeasureId;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUnitOfMeasureId() {
		return unitOfMeasureId;
	}
	public void setUnitOfMeasureId(long unitOfMeasureId) {
		this.unitOfMeasureId = unitOfMeasureId;
	}

}

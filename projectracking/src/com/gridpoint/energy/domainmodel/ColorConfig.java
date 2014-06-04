package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="type")
public abstract class ColorConfig  implements Serializable {

	private static final long serialVersionUID = 8789948159987019559L;
	private long id;
	private long tenantId;
	private Integer graphOrder;
	private long paletteId;
	
	public ColorConfig() {
	}
	
	protected ColorConfig(long id, long tenantId, Integer graphOrder, long paletteId) {
		this.id = id;
		this.tenantId = tenantId;
		this.graphOrder = graphOrder;
		this.paletteId = paletteId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public void setGraphOrder(Integer graphOrder) {
		this.graphOrder = graphOrder;
	}

	public Integer getGraphOrder() {
		return graphOrder;
	}

	public void setPaletteId(Long paletteId) {
		this.paletteId = paletteId;
	}

	public Long getPaletteId() {
		return this.paletteId;
	}

}

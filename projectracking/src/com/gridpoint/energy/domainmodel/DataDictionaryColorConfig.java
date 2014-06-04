package com.gridpoint.energy.domainmodel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDictionaryColorConfig extends ColorConfig {

	private Long dataDictionaryTypeId;
	private static final long serialVersionUID = -6650989130053324213L;

	public DataDictionaryColorConfig() {	
	}
	
	public DataDictionaryColorConfig(long id, long tenantId, Integer graphOrder, Long paletteId, Long dataDictionaryTypeId) {
		super(id, tenantId, graphOrder, paletteId);
		setDataDictionaryTypeId(dataDictionaryTypeId);
	}	
	
	public void setDataDictionaryTypeId(Long dataDictionaryTypeId) {
		this.dataDictionaryTypeId = dataDictionaryTypeId;
	}
	
	public Long getDataDictionaryTypeId() {
		return this.dataDictionaryTypeId;
	}
}

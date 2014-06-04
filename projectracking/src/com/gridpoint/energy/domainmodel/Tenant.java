package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tenant implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tenantId;
	private Long parentId;
	private String name;
	private String tenantUrl;
	private String theme;

	private List<ColorConfig> colorConfigs;
	private Boolean inheritColorConfigs;
	// GPUP 10233
	private String eulavalue;
	private Boolean exceptional;
	private Boolean inheritEulavalue;
	
	//GPUP 12053
	private Boolean hasProjectTracking;

	

	public Tenant() {
	}

	public List<ColorConfig> getColorConfigs() {
		return colorConfigs;
	}

	public void setColorConfigs(List<ColorConfig> colorConfigs) {
		this.colorConfigs = colorConfigs;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTenantUrl() {
		return tenantUrl;
	}

	public void setTenantUrl(String tenantUrl) {
		this.tenantUrl = tenantUrl;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Boolean getInheritColorConfigs() {
		return inheritColorConfigs;
	}

	public void setInheritColorConfigs(Boolean inheritColorConfigs) {
		this.inheritColorConfigs = inheritColorConfigs;
	}

	// gpup 10233

	public Boolean getExceptional() {
		return exceptional;
	}

	public void setExceptional(Boolean exceptional) {
		this.exceptional = exceptional;
	}

	public String getEulavalue() {
		return eulavalue;
	}

	public void setEulavalue(String eulavalue) {
		this.eulavalue = eulavalue;
	}

	public Boolean getInheritEulavalue() {
		return inheritEulavalue;
	}

	public void setInheritEulavalue(Boolean inheritEulavalue) {
		this.inheritEulavalue = inheritEulavalue;
	}
	
	public Boolean getHasProjectTracking() {
		return hasProjectTracking;
	}

	public void setHasProjectTracking(Boolean hasProjectTracking) {
		this.hasProjectTracking = hasProjectTracking;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", name=" + name
				+ ", tenantUrl=" + tenantUrl + ", theme=" + theme + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result
				+ ((tenantUrl == null) ? 0 : tenantUrl.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tenant other = (Tenant) obj;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (tenantUrl == null) {
			if (other.tenantUrl != null)
				return false;
		} else if (!tenantUrl.equals(other.tenantUrl))
			return false;
		return true;
	}

}

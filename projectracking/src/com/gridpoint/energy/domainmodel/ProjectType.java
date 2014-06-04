package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

public class ProjectType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long projectTypeId;
	private String projectType;
	
	public Long getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(Long projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectTypeId == null) ? 0 : projectTypeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ProjectType other = (ProjectType) obj;
		if (projectTypeId == null) {
			if (other.projectTypeId != null) {
				return false;
			}
		} else if (!projectTypeId.equals(other.projectTypeId)) {
			return false;
		}
		return true;
	}

}

package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.gridpoint.energy.publicapi.util.JacksonProjectTrackingItemSerializer;
@JsonSerialize(using=JacksonProjectTrackingItemSerializer.class)
public class ProjectTrackingItemForCreate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long projectId;
	private Long premisesId;
	private String projectName;
	private String startDate;
	private String endDate;
	private Long projectTypeId;
	private String projectType;
	private Set<String> channelDisplayNames;
	private String description;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getPremisesId() {
		return premisesId;
	}

	public void setPremisesId(Long premisesId) {
		this.premisesId = premisesId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	

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
				+ ((projectId == null) ? 0 : projectId.hashCode());
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
		ProjectTrackingItemForCreate other = (ProjectTrackingItemForCreate) obj;
		if (projectId == null) {
			if (other.projectId != null) {
				return false;
			}
		} else if (!projectId.equals(other.projectId)) {
			return false;
		}
		return true;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Set<String> getChannelDisplayNames() {
		return channelDisplayNames;
	}

	public void setChannelDisplayNames(Set<String> channelDisplayNames) {
		this.channelDisplayNames = channelDisplayNames;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

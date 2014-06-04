package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectTrackingItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long projectId;
	private Long premisesId;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private Long projectTypeId;
	private String projectType;
	private Set<String> channelDisplayNames;
	private String projectStatus;
	private Boolean deprecated;
	private String siteName;
	private Map<String, ProjectTrackingErrorWarning> errorsAndWarnings;
	private List<Channel> channels;
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
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Set<String> getChannelDisplayNames() {
		return channelDisplayNames;
	}

	public void setChannelDisplayNames(Set<String> channelDisplayNames) {
		this.channelDisplayNames = channelDisplayNames;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Boolean getDeprecated() {
		return deprecated;
	}

	public void setDeprecated(Boolean deprecated) {
		this.deprecated = deprecated;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Map<String, ProjectTrackingErrorWarning> getErrorsAndWarnings() {
		return errorsAndWarnings;
	}

	public void setErrorsAndWarnings(
			Map<String, ProjectTrackingErrorWarning> errorsAndWarnings) {
		this.errorsAndWarnings = errorsAndWarnings;
	}

	public List<Channel> getChannels() {
		return channels;
	}
	
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		ProjectTrackingItem other = (ProjectTrackingItem) obj;
		if (projectId == null) {
			if (other.projectId != null) {
				return false;
			}
		} else if (!projectId.equals(other.projectId)) {
			return false;
		}
		return true;
	}

}

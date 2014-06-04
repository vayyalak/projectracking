package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EULA implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long eulaId;

	private Long tenantId;

	private String eulaVersion;

	private Date newEffectiveDate;

	private Date creationDate;

	// GPUP-10233

	private String newEulaVersion;

	private Date effectiveDate;

	private Boolean accepted;

	private Long parentEulaId;

	public void setEulaId(Long eulaId) {
		this.eulaId = eulaId;
	}

	public Long getEulaId() {
		return eulaId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setEulaVersion(String eulaVersion) {
		this.eulaVersion = eulaVersion;
	}

	public String getEulaVersion() {
		return eulaVersion;
	}

	public Date getNewEffectiveDate() {
		return newEffectiveDate;
	}

	public void setNewEffectiveDate(Date newEffectiveDate) {
		this.newEffectiveDate = newEffectiveDate;
	}

	public String getNewEulaVersion() {
		return newEulaVersion;
	}

	public void setNewEulaVersion(String uploadNewEulaVersion) {
		this.newEulaVersion = uploadNewEulaVersion;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Long getParentEulaId() {
		return parentEulaId;
	}

	public void setParentEulaId(Long parentEulaId) {
		this.parentEulaId = parentEulaId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean equal(EULA eula) {
		if (eula.getAccepted()) {
			if (eula.getParentEulaId() != null) {
				if (this.eulaId.equals(eula.getParentEulaId())) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

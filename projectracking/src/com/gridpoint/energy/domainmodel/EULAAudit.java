package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;

public class EULAAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long eulaAuditId;

	private Long enduserId;

	private String email;
	
	private String fname;
	
	private String lname;
	
	private String login;
	
	private Boolean accepted;
	
	private Date accDecDate;
	
	private Boolean access;
	
	private Date effectiveDate;
	
	private String eulaVersion;
	
	private String tenantName;
	
	private Boolean exceptional;

	public Long getEulaAuditId() {
		return eulaAuditId;
	}

	public void setEulaAuditId(Long eulaAudiId) {
		this.eulaAuditId = eulaAudiId;
	}

	public Long getEnduserId() {
		return enduserId;
	}

	public void setEnduserId(Long enduserId) {
		this.enduserId = enduserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Date getAccDecDate() {
		return accDecDate;
	}

	public void setAccDecDate(Date accDecDate) {
		this.accDecDate = accDecDate;
	}

	public Boolean getAccess() {
		return access;
	}

	public void setAccess(Boolean access) {
		this.access = access;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEulaVersion() {
		return eulaVersion;
	}

	public void setEulaVersion(String eulaVersion) {
		this.eulaVersion = eulaVersion;
	}

	
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public Boolean getExceptional() {
		return exceptional;
	}

	public void setExceptional(Boolean exceptional) {
		this.exceptional = exceptional;
	}

	

}

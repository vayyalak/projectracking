package com.gridpoint.energy.domainmodel.utilitybills;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SSDataResponse implements Serializable{

	private boolean status;
	private String message;
	private String masterTariffId;
	private Long accountId;
	private String startTime;//This is site format date when we are getting converted into UTC format
	private String endTime;
	private List<UtilityMeter> meters;
	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the masterTariffId
	 */
	public String getMasterTariffId() {
		return masterTariffId;
	}
	/**
	 * @param masterTariffId the masterTariffId to set
	 */
	public void setMasterTariffId(String masterTariffId) {
		this.masterTariffId = masterTariffId;
	}
	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the meters
	 */
	public List<UtilityMeter> getMeters() {
		return meters;
	}
	/**
	 * @param meters the meters to set
	 */
	public void setMeters(List<UtilityMeter> meters) {
		this.meters = meters;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((masterTariffId == null) ? 0 : masterTariffId.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}
	/* (non-Javadoc)
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
		SSDataResponse other = (SSDataResponse) obj;
		if (masterTariffId == null) {
			if (other.masterTariffId != null)
				return false;
		} else if (!masterTariffId.equals(other.masterTariffId))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
}

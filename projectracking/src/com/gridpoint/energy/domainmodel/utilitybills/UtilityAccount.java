package com.gridpoint.energy.domainmodel.utilitybills;

import java.io.Serializable;

public class UtilityAccount implements Serializable{
	private Long premisesId;
	private Long utilityId;
	private String accountNumber;
	private Long accountId;
	/**
	 * @return the premisesId
	 */
	public Long getPremisesId() {
		return premisesId;
	}
	/**
	 * @param premisesId the premisesId to set
	 */
	public void setPremisesId(Long premisesId) {
		this.premisesId = premisesId;
	}
	/**
	 * @return the utilityId
	 */
	public Long getUtilityId() {
		return utilityId;
	}
	/**
	 * @param utilityId the utilityId to set
	 */
	public void setUtilityId(Long utilityId) {
		this.utilityId = utilityId;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((premisesId == null) ? 0 : premisesId.hashCode());
		result = prime * result
				+ ((utilityId == null) ? 0 : utilityId.hashCode());
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
		UtilityAccount other = (UtilityAccount) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (premisesId == null) {
			if (other.premisesId != null)
				return false;
		} else if (!premisesId.equals(other.premisesId))
			return false;
		if (utilityId == null) {
			if (other.utilityId != null)
				return false;
		} else if (!utilityId.equals(other.utilityId))
			return false;
		return true;
	}
}

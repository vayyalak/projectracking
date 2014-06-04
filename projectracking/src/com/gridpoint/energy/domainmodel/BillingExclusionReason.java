package com.gridpoint.energy.domainmodel;

/**
 * Used for under performing sites to figure out which sites can not be calculated
 * for based on bad / missing r2 value or no billing records to estimate cost
 * @author cconstantinescu
 *
 */
public class BillingExclusionReason {

	private Long premisesId;
	private String message;
	private String name;

	public Long getPremisesId() {
		return premisesId;
	}

	public BillingExclusionReason() {
	}

	public BillingExclusionReason(Long premisesId, String message, String name) {
		this.premisesId = premisesId;
		this.message = message;
		this.name = name;
	}

	public void setPremisesId(Long premisesId) {
		this.premisesId = premisesId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

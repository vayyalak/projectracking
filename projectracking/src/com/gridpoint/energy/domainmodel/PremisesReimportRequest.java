package com.gridpoint.energy.domainmodel;

public class PremisesReimportRequest {

	public static enum Status {
		/**
		 * Re-import request has been recorded and is pending
		 */
		SUBMITTED,

		/**
		 * Re-importing is in progress
		 */
		PROCESSING,

		/**
		 * Re-import is finished
		 */
		COMPLETED,

		/**
		 * There was a problem encountered during the re-import
		 */
		FAILED,
	}

	private long id;
	private long premisesId;
	private long requestTime;
	private Long processTime;
	private Long finishTime;
	private Status status;

	public PremisesReimportRequest() {
	}

	/**
	 * The identifier of this {@link PremisesReimportRequest}
	 */
	public long getId() {
		return this.id;
	}

	public void setId(long requestId) {
		this.id = requestId;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

	public Long getProcessTime() {
		return processTime;
	}

	public void setProcessTime(Long processTime){
		this.processTime = processTime;
	}

	public Long getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Long finishTime) {
		this.finishTime = finishTime;
	}

	public long getPremisesId() {
		return this.premisesId;
	}

	public void setPremisesId(long premisesId) {
		this.premisesId = premisesId;
	}
}

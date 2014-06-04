package com.gridpoint.energy.domainmodel;

import java.util.Date;

/**
 * Models status of mass config update for an enduser
 * 
 * @author cconstantinescu
 * 
 */
public class ConfigUpdateAuditView {

	private long id;

	private String submittedBy;

	private Date creationDate;

	private String note;

	private String command;

	private int total;

	private int pending;

	private int succeeded;

	private int retrying;

	private int failed;

	public ConfigUpdateAuditView(long id, String submittedBy,
			Date creationDate, String note, String command, int total,
			int pending, int succeeded, int retrying, int failed) {
		this.id = id;
		this.submittedBy = submittedBy;
		this.creationDate = creationDate;
		this.note = note;
		this.command = command;
		this.total = total;
		this.pending = pending;
		this.succeeded = succeeded;
		this.retrying = retrying;
		this.failed = failed;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	public int getSucceeded() {
		return succeeded;
	}

	public void setSucceeded(int succeeded) {
		this.succeeded = succeeded;
	}

	public int getRetrying() {
		return retrying;
	}

	public void setRetrying(int retrying) {
		this.retrying = retrying;
	}

	public int getFailed() {
		return failed;
	}

	public void setFailed(int failed) {
		this.failed = failed;
	}
}

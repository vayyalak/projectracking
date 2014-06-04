package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;

public class SiteEvent {

	private String eventType;
	private DateTZ date;
	private String description;

	public SiteEvent() {

	}

	public SiteEvent(String eventType, DateTZ date, String description) {
		this.eventType = eventType;
		this.date = date;
		this.description = description;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public DateTZ getDate() {
		return date;
	}

	public void setDate(DateTZ date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

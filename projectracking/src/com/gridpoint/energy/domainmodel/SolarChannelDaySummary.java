package com.gridpoint.energy.domainmodel;

import java.util.Date;

public class SolarChannelDaySummary extends SolarSummary{
	
	private Date day;
	public SolarChannelDaySummary(Date day) {
		this.day = day;
	}	
	
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

}

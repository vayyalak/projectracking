package com.gridpoint.energy.domainmodel;

import java.util.LinkedList;
import java.util.List;

public class PremisesSolarSummary extends SolarSummary{
	
	private List<SolarChannelDaySummary> solarChannelDaySummary=new LinkedList<SolarChannelDaySummary>();

	public List<SolarChannelDaySummary> getSolarChannelDaySummary() {
		return solarChannelDaySummary;
	}

	public void setSolarChannelDaySummary(
			List<SolarChannelDaySummary> solarChannelDaySummary) {
		this.solarChannelDaySummary = solarChannelDaySummary;
	}
	
}

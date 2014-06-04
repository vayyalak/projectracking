package com.gridpoint.energy.domainmodel;


public class ChannelNameColorConfig extends ColorConfig {

	private String channelName;
	private String unit;
	private static final long serialVersionUID = -345437568539243333L;

	public ChannelNameColorConfig() {
	}
	
	public ChannelNameColorConfig(long id, long tenantId, Integer graphOrder, Long paletteId, String channelName, String unit) {
		super(id, tenantId, graphOrder, paletteId);
		setChannelName(channelName);
		setUnit(unit);
	}
	
	public String getChannelName() {
		return channelName;
	}
	
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getUnit() {
		return this.unit;
	}
}

package com.gridpoint.energy.domainmodel;
import java.io.Serializable;

public class ChannelMetadataCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	private long channelMetadataCategoryId;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getChannelMetadataCategoryId() {
		return channelMetadataCategoryId;
	}
	public void setChannelMetadataCategoryId(long channelMetadataCategoryId) {
		this.channelMetadataCategoryId = channelMetadataCategoryId;
	}

}

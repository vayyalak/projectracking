package com.gridpoint.energy.domainmodel.utilitybills;

import java.io.Serializable;

public class ChannelUsages implements Serializable{

	private Long channelId;
	private Long demand;
	private String demandUom;
	private Long usage;
	private String usageUom;
	/**
	 * @return the channelId
	 */
	public Long getChannelId() {
		return channelId;
	}
	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	/**
	 * @return the demand
	 */
	public Long getDemand() {
		return demand;
	}
	/**
	 * @param demand the demand to set
	 */
	public void setDemand(Long demand) {
		this.demand = demand;
	}
	/**
	 * @return the demandUom
	 */
	public String getDemandUom() {
		return demandUom;
	}
	/**
	 * @param demandUom the demandUom to set
	 */
	public void setDemandUom(String demandUom) {
		this.demandUom = demandUom;
	}
	/**
	 * @return the usage
	 */
	public Long getUsage() {
		return usage;
	}
	/**
	 * @param usage the usage to set
	 */
	public void setUsage(Long usage) {
		this.usage = usage;
	}
	/**
	 * @return the usageUom
	 */
	public String getUsageUom() {
		return usageUom;
	}
	/**
	 * @param usageUom the usageUom to set
	 */
	public void setUsageUom(String usageUom) {
		this.usageUom = usageUom;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((channelId == null) ? 0 : channelId.hashCode());
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
		ChannelUsages other = (ChannelUsages) obj;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		return true;
	}
	
}

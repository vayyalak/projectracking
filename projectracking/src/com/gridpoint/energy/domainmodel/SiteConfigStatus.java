package com.gridpoint.energy.domainmodel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteConfigStatus {

    String siteId;

    Long deviceId;

    String configStatus;

    String connectionStatus;

    String savedDatestamp;

    String nextAttemptTime;
    
    String lastHeartbeatDatestamp;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(String configStatus) {
        this.configStatus = configStatus;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public String getSavedDatestamp() {
        return savedDatestamp;
    }

    public void setSavedDatestamp(String savedDatestamp) {
        this.savedDatestamp = savedDatestamp;
    }

    public String getNextAttemptTime() {
        return nextAttemptTime;
    }

    public void setNextAttemptTime(String nextAttemptTime) {
        this.nextAttemptTime = nextAttemptTime;
    }

	public String getLastHeartbeatDatestamp() {
		return lastHeartbeatDatestamp;
	}

	public void setLastHeartbeatDatestamp(String lastHeartbeatDatestamp) {
		this.lastHeartbeatDatestamp = lastHeartbeatDatestamp;
	}

}

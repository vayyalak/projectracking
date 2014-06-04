package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;
public class EndpointConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long endpointConfigId;
    private Endpoint endpoint;
    private String actualConfig;
    private Long endpointId;
    private String stagedConfigFromApi;
    private String stagedConfigFromEndpoint;
    private String historyConfig;
    private String creationDate;
    private String historyCreationDate;
    private Date modificationFromApiDate;
    private Date modificationFromEndpointDate;
    private String enduserName;
    private String actualConfigAction;
    private String stagedConfigAction;
    private String notes;
    
    public EndpointConfig(long endpointId, String actualConfig, String historyConfig, String creationDate, 
    		String historyCreationDate, String actualConfigAction, String stagedConfigAction, String enduserName,String notes) {
        this.setEndpointId(endpointId);
        this.setActualConfig(actualConfig);
        this.setHistoryConfig(historyConfig);
        this.setCreationDate(creationDate);
        this.setHistoryCreationDate(historyCreationDate);
        this.setActualConfigAction(actualConfigAction);
        this.setStagedConfigAction(stagedConfigAction);
        this.setEnduserName(enduserName);
        this.setNotes(notes);
    }
    
    public void setEnduserName(String enduserName){
    	this.enduserName = enduserName;
    }
    public String getEnduserName(){
    	return enduserName;
    }
    
    public void setActualConfigAction(String actualConfigAction){
    	this.actualConfigAction = actualConfigAction;
    }
    public String getActualConfigAction(){
    	return actualConfigAction;
    }
    public void setStagedConfigAction(String stagedConfigAction){
    	this.stagedConfigAction= stagedConfigAction;
    }
    public String getStagedConfigAction(){
    	return stagedConfigAction;
    }   
    
    public Long getEndpointConfigId() {
        return endpointConfigId;
    }

    public void setEndpointConfigId(Long id) {
        this.endpointConfigId = id;
    }

	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	public String getActualConfig() {
		return actualConfig;
	}

	public void setActualConfig(String actualConfig) {
		this.actualConfig = actualConfig;
	}

	public String getStagedConfigFromApi() {
		return stagedConfigFromApi;
	}

	public void setStagedConfigFromApi(String stagedConfigFromApi) {
		this.stagedConfigFromApi = stagedConfigFromApi;
	}

	public String getStagedConfigFromEndpoint() {
		return stagedConfigFromEndpoint;
	}

	public void setStagedConfigFromEndpoint(String stagedConfigFromEndpoint) {
		this.stagedConfigFromEndpoint = stagedConfigFromEndpoint;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationFromApiDate() {
		return modificationFromApiDate;
	}

	public void setModificationFromApiDate(Date modificationFromApiDate) {
		this.modificationFromApiDate = modificationFromApiDate;
	}

	public Date getModificationFromEndpointDate() {
		return modificationFromEndpointDate;
	}

	public void setModificationFromEndpointDate(
			Date modificationFromEndpointDate) {
		this.modificationFromEndpointDate = modificationFromEndpointDate;
	}

	public String getHistoryConfig() {
		return historyConfig;
	}

	public void setHistoryConfig(String historyConfig) {
		this.historyConfig = historyConfig;
	}

	public String getHistoryCreationDate() {
		return historyCreationDate;
	}

	public void setHistoryCreationDate(String historyCreationDate) {
		this.historyCreationDate = historyCreationDate;
	}

	public Long getEndpointId() {
		return endpointId;
	}

	public void setEndpointId(Long endpointId) {
		this.endpointId = endpointId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}

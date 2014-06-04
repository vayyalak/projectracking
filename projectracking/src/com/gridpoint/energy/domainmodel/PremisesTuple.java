package com.gridpoint.energy.domainmodel;
import java.io.Serializable;

public class PremisesTuple implements Serializable{
	private String siteId;
	private String premisesName;
	
	public String getSiteId(){
		return siteId;
	}
	
	public void setSiteId(String siteId){
		this.siteId = siteId;
	}
	
	public String getPremisesName(){
		return premisesName;
	}
	public void setPremisesName(String premisesName){
		this.premisesName = premisesName;
	}
}
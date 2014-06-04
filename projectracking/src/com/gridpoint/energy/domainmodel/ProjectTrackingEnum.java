package com.gridpoint.energy.domainmodel;

public enum ProjectTrackingEnum {
	

	PLANNED("PLANNED"),
	PROPOSED("PROPOSED"),
	IN_PROGRESS("IN PROGRESS"),
	COMPLETED("COMPLETED"),
	ALL("ALL");
	
	String status;
	ProjectTrackingEnum(String status){
		this.status=status;
	}
	
	public String getValue(){
		return status;
	}
	


}

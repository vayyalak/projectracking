package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.List;

public class ProjectTrackingErrorWarning implements Serializable
{
	private static final long serialVersionUID = 1L;

	private List<String> errorList = null;
	private List<String> warningList = null;

	public List<String> getErrorList()
	{
		return errorList;
	}

	public void setErrorList(List<String> errorList)
	{
		this.errorList = errorList;
	}

	public List<String> getWarningList()
	{
		return warningList;
	}

	public void setWarningList(List<String> warningList)
	{
		this.warningList = warningList;
	}
}

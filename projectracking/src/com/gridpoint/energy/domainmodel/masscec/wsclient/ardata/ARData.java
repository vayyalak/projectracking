package com.gridpoint.energy.domainmodel.masscec.wsclient.ardata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "ptsSystem" })
@XmlRootElement(name = "ARData")
public class ARData {

	@XmlElement(required = true)
	protected List<ARData.PtsSystem> ptsSystem;

	public List<ARData.PtsSystem> getPtsSystem() {
		if (ptsSystem == null) {
			ptsSystem = new ArrayList<ARData.PtsSystem>();
		}
		return this.ptsSystem;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "sysID", "monthlyData", "intervalData" })
	public static class PtsSystem {

		@XmlElement(required = true)
		protected String sysID;
		@XmlElement(name = "MonthlyData", required = true)
		protected ARData.PtsSystem.MonthlyData monthlyData;
		protected ARData.PtsSystem.IntervalData intervalData;
		@XmlAttribute(required = true)
		protected String sysType;

		public String getSysID() {
			return sysID;
		}

		public void setSysID(String value) {
			this.sysID = value;
		}

		public ARData.PtsSystem.MonthlyData getMonthlyData() {
			return monthlyData;
		}

		public void setMonthlyData(ARData.PtsSystem.MonthlyData value) {
			this.monthlyData = value;
		}


		public ARData.PtsSystem.IntervalData getIntervalData() {
			return intervalData;
		}

		public void setIntervalData(ARData.PtsSystem.IntervalData value) {
			this.intervalData = value;
		}

		public String getSysType() {
			return sysType;
		}

		public void setSysType(String value) {
			this.sysType = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "pVdata" })
		public static class IntervalData {

			@XmlElement(name = "PVdata")
			protected List<PVType> pVdata;

			public List<PVType> getPVdata() {
				if (pVdata == null) {
					pVdata = new ArrayList<PVType>();
				}
				return this.pVdata;
			}

		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "pVmonthlyData" })
		public static class MonthlyData {

			@XmlElement(name = "PVmonthlyData")
			protected PvSpecificMonthlyData pVmonthlyData;

			public PvSpecificMonthlyData getPVmonthlyData() {
				return pVmonthlyData;
			}

			public void setPVmonthlyData(PvSpecificMonthlyData value) {
				this.pVmonthlyData = value;
			}

		}

	}

}

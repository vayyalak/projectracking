package com.gridpoint.energy.domainmodel.hvac.datavisualization;

public class GpecObject {

	/**Current Conditioning Parameters
	 */
	  private String zoneTemp;
	  private String hvacModeContrl;
	  private String fanMode;
	  
	  private String supplyAirTemp;
	  private String zoneHumidity;
	  private String zoneCo2;
	  
	  /** 
	   * Control Schedule Parameters
	   */
	  private String coolStpt;
	  private String heatStPt;
	  /**
	   * Thermostat details Parameters
	   */
	  
	  private static String degF="&#xB0;F";
	  private static String seconds = " Seconds";
	  private static String na ="N/A";
	  private static String relativeHumidity = " %RH";
	  private boolean advView=true;
	  
	  /**
	   * parameters which are present in ADM HVAC but not in GPEC
	   */
	  boolean rtConnectionEstablished;
	  boolean rtCommandEstablished,returned;
	  /**
	   * Current conditioning
	   */
	  private String hvacStatus,hvacMode;
	  private String fanStatus;
	  private String overrideInProgress;
	  private String zoneTempSetPoint;
	  private String rtuOccupiedStatus;
	  private String dischargeAirTemp;
	  private String returnAirTemp;
	  private String returnAirHumidity;
	  
	  /**
	   * Control Schedule 
	   */
	  private String hvacStatusCntrl,overrideDegMin,scheduledSetPoint,scheduledAsOccupied,relayState;

		/**
		 * Economizer Widget
		 */
      private String economizerEnabled,economizerActive,minimumDamperPositionSetPoint,minDamperPosition;
      private String mixedAirTemp,outdoorTemperature,outdoorHumidity;
      
      private String highPressureCutOffCompressorOne,lowPressureCutOffCompressorOne,highPressureCutOffCompressorTwo,lowPressureCutOffCompressorTwo;
      
      private String erv;
      /**
  	 * Algorithm Widget Parameters
  	 */
  	private String algorithm,rawdata;		
  	/**
  	 * General Widget Parameters 
  	 * 
  	 */	
  	private String make;
  	private String model;
  	private String tonnage;
  	private String unitStopSource;
  	private String smokeDetectors;
	
	/**
	 * @return the advView
	 */
	public boolean isAdvView() {
		return advView;
	}
	/**
	 * @param advView the advView to set
	 */
	public void setAdvView(boolean advView) {
		this.advView = advView;
	}
	  /**
	   * parameters which are present in ADM HVAC but not in GPEC
	   */
	  /**
		 * @return the rtConnectionEstablished
		 */
		public boolean getRtConnectionEstablished() {
			return rtConnectionEstablished;
		}

		/**
		 * @param rtConnectionEstablished the rtConnectionEstablished to set
		 */
		public void setRtConnectionEstablished(boolean rtConnectionEstablished) {
			this.rtConnectionEstablished = rtConnectionEstablished;
		}
		/**
		 * @return the rtCommandEstablished
		 */
		public boolean getRtCommandEstablished() {
			return rtCommandEstablished;
		}

		/**
		 * @param rtCommandEstablished the rtCommandEstablished to set
		 */
		public void setRtCommandEstablished(boolean rtCommandEstablished) {
			this.rtCommandEstablished = rtCommandEstablished;
		}
		public boolean getReturned()
		{
			return returned;
		}
		public void setReturned(boolean temp)
		{
			this.returned=temp;
		}
		 public String getRawData()
		  {
			  return rawdata;
		  }
		  public void setRawData(String data)
		  {
			  if(data!=null && !data.equals("")){
				  this.rawdata = data;
				  }
				  else 
					  this.rawdata=na;
		  }
		  public String getHvacStatusCntrl()
		  {
			  return hvacStatusCntrl;
		  }
		  public void setHvacStatusCntrl(String hStatus)
		  {
			  if(hStatus!=null && !hStatus.equals("")){
				  this.hvacStatusCntrl = hStatus;
				  }
				  else 
					  this.hvacStatusCntrl=na;
		  }
		  public String getHvacModeContrl()
		  {
			  return hvacModeContrl;
		  }
		  public void setHvacModeContrl(String hMode)
		  {
			  if(hMode!=null && !hMode.equals("")){
				  int mode= Integer.parseInt(hMode);
				  switch(mode)
				  {
				  case 0:
					  this.hvacModeContrl ="Off";break;
				  case 1:
					  this.hvacModeContrl="Heat";break;
				  case 2:
					  this.hvacModeContrl="Cool";break;
				  case 3:
					  this.hvacModeContrl="Auto";break;
				  case 4:
					  this.hvacModeContrl ="Emergency";break;
				  default: this.hvacModeContrl=na;
				  }
				  }
				  else 
					  this.hvacModeContrl=na;
		  }
		  
		 public String getHvacStatus()
		  {
			  return hvacStatus;
		  }
		  public void setHvacStatus(String hStatus)
		  {
			  if(hStatus!=null && !hStatus.equals("")){
				  this.hvacStatus = hStatus;
				  }
				  else 
					  this.hvacStatus=na;
		  }
		  public String getFanStatus()
		  {
			  return fanStatus;
		  }
		  public void setFanStatus(String fStatus)
		  {
			  if(fStatus!=null && !fStatus.equals("")){
				  this.fanStatus = fStatus;
				  }
				  else 
					  this.fanStatus=na;
		  }
		  public String getOverrideInProgress()
		  {
			  return overrideInProgress;
		  }
		  public void setOverrideInProgress(String oProgress)
		  {
			  if(oProgress!=null && !oProgress.equals("")){
				  this.overrideInProgress = oProgress;
				  }
				  else 
					  this.overrideInProgress=na;
		  }
		  public String getZoneTempSetPoint()
		  {
			  return zoneTempSetPoint;
		  }
		  public void setZoneTempSetPoint(String setPt)
		  {
			  if(setPt!=null && !setPt.equals("")){
				  this.zoneTempSetPoint = setPt;
				  }
				  else 
					  this.zoneTempSetPoint=na;
		  }
		  public String getRTUOccupiedStatus()
		  {
			  return rtuOccupiedStatus;
		  }
		  public void setRTUOccupiedStatus(String status)
		  {
			  if(status!=null && !status.equals("")){
				  this.rtuOccupiedStatus = status;
				  }
				  else 
					  this.rtuOccupiedStatus=na;
		  }
		  public String getDischargeAirTemp()
		  {
			  return dischargeAirTemp;
		  }
		  public void setDischargeAirTemp(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.dischargeAirTemp = temp;
				  }
				  else 
					  this.dischargeAirTemp=na;
		  }
		  public String getReturnAirTemp()
		  {
			  return returnAirTemp;
		  }
		  public void setReturnAirTemp(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.returnAirTemp = temp;
				  }
				  else 
					  this.returnAirTemp=na;
		  }
		  public String getReturnAirHumidity()
		  {
			  return returnAirHumidity;
		  }
		  public void setReturnAirHumidity(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.returnAirHumidity = temp;
				  }
				  else 
					  this.returnAirHumidity=na;
		  }
		  
		  public String getOverrideDegMin()
		  {
			  return overrideDegMin;
		  }
		  public void setOverrideDegMin(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.overrideDegMin = temp;
				  }
				  else 
					  this.overrideDegMin=na;
		  }
		  public String getScheduledSetPoint()
		  {
			  return scheduledSetPoint;
		  }
		  public void setScheduledSetPoint(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.scheduledSetPoint = temp;
				  }
				  else 
					  this.scheduledSetPoint=na;
		  }
		  public String getScheduledAsOccupied()
		  {
			  return scheduledAsOccupied;
		  }
		  public void setScheduledAsOccupied(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.scheduledAsOccupied = temp;
				  }
				  else 
					  this.scheduledAsOccupied=na;
		  }
		  public String getRelayState()
		  {
			  return relayState;
		  }
		  public void setRelayState(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.relayState = temp;
				  }
				  else 
					  this.relayState=na;
		  }
		  public String getEconomizerEnabled()
		  {
			  return economizerEnabled;
		  }
		  public void setEconomizerEnabled(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.economizerEnabled = temp;
				  }
				  else 
					  this.economizerEnabled=na;
		  }
		  public String getEconomizerActive()
		  {
			  return economizerActive;
		  }
		  public void setEconomizerActive(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.economizerActive = temp;
				  }
				  else 
					  this.economizerActive=na;
		  }
		  public String getMinimumDamperPositionSetPoint()
		  {
			  return minimumDamperPositionSetPoint;
		  }
		  public void setMinimumDamperPositionSetPoint(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.minimumDamperPositionSetPoint = temp;
				  }
				  else 
					  this.minimumDamperPositionSetPoint=na;
		  }
		  public String getMinDamperPosition()
		  {
			  return minDamperPosition;
		  }
		  public void setMinDamperPosition(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.minDamperPosition = temp;
				  }
				  else 
					  this.minDamperPosition=na;
		  }
		
		  public String getMixedAirTemp()
		  {
			  return mixedAirTemp;
		  }
		  public void setMixedAirTemp(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.mixedAirTemp = temp;
				  }
				  else 
					  this.mixedAirTemp=na;
		  }
		  public String getOutdoorTemperature()
		  {
			  return outdoorTemperature;
		  }
		  public void setOutdoorTemperature(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.outdoorTemperature = temp;
				  }
				  else 
					  this.outdoorTemperature=na;
		  }
		  public String getOutDoorHumidity()
		  {
			  return outdoorHumidity;
		  }
		  public void setOutDoorHumidity(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.outdoorHumidity = temp;
				  }
				  else 
					  this.outdoorHumidity=na;
		  }
		  public String getHighPressureCutOffCompressorOne()
		  {
			  return highPressureCutOffCompressorOne;
		  }
		  public void setHighPressureCutOffCompressorOne(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.highPressureCutOffCompressorOne = temp;
				  }
				  else 
					  this.highPressureCutOffCompressorOne=na;
		  }
		  public String getLowPressureCutOffCompressorOne()
		  {
			  return lowPressureCutOffCompressorOne;
		  }
		  public void setLowPressureCutOffCompressorOne(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.lowPressureCutOffCompressorOne = temp;
				  }
				  else 
					  this.lowPressureCutOffCompressorOne=na;
		  }
		  public String getHighPressureCutOffCompressorTwo()
		  {
			  return highPressureCutOffCompressorTwo;
		  }
		  public void setHighPressureCutOffCompressorTwo(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.highPressureCutOffCompressorTwo = temp;
				  }
				  else 
					  this.highPressureCutOffCompressorTwo=na;
		  }
		  public String getLowPressureCutOffCompressorTwo()
		  {
			  return lowPressureCutOffCompressorTwo;
		  }
		  public void setLowPressureCutOffCompressorTwo(String temp)
		  {
			  if(temp!=null && !temp.equals("")){
				  this.lowPressureCutOffCompressorTwo = temp;
				  }
				  else 
					  this.lowPressureCutOffCompressorTwo=na;
		  }
		  public String getErv() {
				return erv;
			}

			public void setErv(String temp) {
				if(temp!=null && !temp.equals("")){
					  this.erv = temp;
					  }
					  else 
						  this.erv=na;
			}
			public String getAlgorithm() {
				return algorithm;
			}

			public void setAlgorithm(String temp) {
				if(temp!=null && !temp.equals("")){
					  this.algorithm = temp;
					  }
					  else 
						  this.algorithm=na;
			}
			public String getMake() {
				return make;
			}

			public void setMake(String temp) {
				if(temp!=null && !temp.equals("")){
					  this.make = temp;
					  }
					  else 
						  this.make=na;
			}
			
			public String getModel() {
				return model;
			}

			public void setModel(String temp) {
				if(temp!=null && !temp.equals("")){
					  this.model = temp;
					  }
					  else 
						  this.model=na;
			}
			public String getTonnage() {
				return tonnage;
			}

			public void setTonnage(String temp) {
				if(temp!=null && !temp.equals("")){
					  this.tonnage = temp;
					  }
					  else 
						  this.tonnage=na;
			}
			public String getUnitStopSource() {
				return unitStopSource;
			}

			public void setUnitStopSource(String temp) {
				if(temp!=null && !temp.equals("")){
					  this.unitStopSource = temp;
					  }
					  else 
						  this.unitStopSource=na;
			}
			public String getSmokeDetectors() {
				return smokeDetectors;
			}

			public void setSmokeDetectors(String temp) {
				if(temp!=null && !temp.equals("")){
					  this.smokeDetectors = temp;
					  }
					  else 
						  this.smokeDetectors=na;
			}
	  /**
	   * Current conditioning parameter's getter and setter methods
	   */
	  public String getZoneTemp()
	  {
		  return zoneTemp;
	  }
	  public void setZoneTemp(String input)
	  {
			if(input!=null && !input.equals("")){
				double temp=Double.parseDouble(input);
				this.zoneTemp = temp+" "+degF;
			}else{
				this.zoneTemp=na;
			}	
	  }
	  public String getHvacMode()
	  {
		  return hvacMode;
	  }
	  public void setHvacMode(String hMode)
	  {
		  if(hMode!=null && !hMode.equals("")){
			  this.hvacMode = hMode;
			  }
			  else 
				  this.hvacMode=na;
	  }
	  public String getFanMode()
	  {
		  return fanMode;
	  }
	  public void setFanMode(String fMode)
	  {
		  if(fMode!=null&& !fMode.equals("")){
			  int mode= Integer.parseInt(fMode);
			  switch(mode)
			  {
			  case 0:
				  this.fanMode="On";break;
			  case 1: this.fanMode="Auto"; break;
			  default : this.fanMode=na;
			  }
			  }
			  else
				  this.fanMode=na;
	  }
	  
	  public String getSupplyAirTemp()
	  {
		  return supplyAirTemp;
	  }
	  public void setSupplyAirTemp(String dTemp)
	  {
		  //this.ductTemp=dTemp;
		  if(dTemp!=null && !dTemp.equals("")){
				double temp=Double.parseDouble(dTemp);
				this.supplyAirTemp = temp+" "+degF;
			}else{
				this.supplyAirTemp=na;
			}	
	  }
	  public String getZoneHumidity()
	  {
		  return zoneHumidity;
	  }
	  public void setZoneHumidity(String zHumidity)
	  {
		  if(zHumidity!=null && !zHumidity.equals("")){
			  double temp=Double.parseDouble(zHumidity);
			  this.zoneHumidity=temp+relativeHumidity;
		  }
		  else
			  this.zoneHumidity=na;
	  }
	  public String getZoneCo2()
	  {
		  return zoneCo2;
	  }
	  public void setZoneCo2(String co2)
	  {
		  if(co2!=null && !co2.equals(""))
			  this.zoneCo2=co2+" Parts-per-million";
		  else
			  this.zoneCo2=na;
	  }
	  /**
	   * Control schedule parameter's getter and setter methods
	   */
	  public String getCoolSetPoint()
	  {
		  return coolStpt;
	  }
	  public void setCoolSetPoint(String input)
	  {
		  //this.coolStpt=coolstpt;
		  if(input!=null && !input.equals("")){
				double temp=Double.parseDouble(input);
				this.coolStpt = temp+" "+degF;
			}else{
				this.coolStpt=na;
			}	
		  
	  }
	  public String getHeatSetPoint()
	  {
		  return heatStPt;
	  }
	  public void setHeatSetPoint(String input)
	  {
		  //this.heatStPt=heatstpt;
		  if(input!=null && !input.equals("")){
				double temp=Double.parseDouble(input);
				this.heatStPt = temp+" "+degF;
			}else{
				this.heatStPt=na;
			}	
	  }
}

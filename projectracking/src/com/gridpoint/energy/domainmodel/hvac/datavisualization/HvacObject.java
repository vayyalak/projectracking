package com.gridpoint.energy.domainmodel.hvac.datavisualization;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class HvacObject {

		/**
		 * Connection Established Parameters
		 */
		private boolean rtConnectionEstablished=false;
		private boolean rtCommandEstablished=false;
		private boolean advView=false;
		
		/**
		 * Current Condition Widget Parameters
		 */
		private String hvacStatus;
		private String hvacMode;
		private String fanStatus;
		private String overrideInProgress;
		private String zoneTempSetPoint;
		private String rtuOccupiedStatus;
		private String zoneTemp;
		private String dischargeAirTemp;
		private String supplyAirTemp;
		private String returnAirTemp;
		private String returnAirHumidity;
		private String zoneHumidity;
		private String zoneCo2;
		
		/**
		 * Control Schedule Widget Parameters
		 */
		private String hvacStatusCntrl;
		private String hvacModeContrl;
		private String fanMode;
		private String coolSetPoint;
		private String heatSetPoint;		
		private String overrideDegMin;
		private String scheduledSetPoint;
		private String scheduledAsOccupied;
		private String relayState;
		
		/**
		 * Economizer Widget Parameters
		 */
		
		private String economizerEnabled;
		private String economizerActive;
		private String minimumDamperPositionSetPoint;
		private String minDamperPosition;		
		private String mixedAirTemp;	
		private String outdoorTemperature;
		private String outdoorHumidity;
		private String highPressureCutOffCompressorOne;
		private String lowPressureCutOffCompressorOne;
		private String highPressureCutOffCompressorTwo;
		private String lowPressureCutOffCompressorTwo;
		private String erv;
		
		/**
		 * Algorithm Widget Parameters
		 */
		private String algorithm;	
		
		/**
		 * show feed
		 */
		private  Map<String,String> rawData;
		
		/**
		 * General Widget Parameters
		 */
		private String make;
		private String model;
		private String tonnage;	
		private String unitStopSource;
		private String smokeDetectors;
		private String spaceAirTemp;
		private String weatherHigh;

		private boolean isCelsius;
	    private String displayName;
	    private String systemId;
	    private String systemType;
	    private String status;
	    private String temperature;
	    private String kwValue;
	    private String timeOpen;
	    private String spaceAirHumidity;
	    private String weatherLow;
		
		/**
		 * @return the hvacStatus
		 */
		@JsonProperty("hvacStatus")
		public String getHvacStatus() {
			return hvacStatus;
		}
		/**
		 * @param hvacStatus the hvacStatus to set
		 */
		@JsonProperty("hvacStatus")
		public void setHvacStatus(String hvacStatus) {
			this.hvacStatus = hvacStatus;
		}
		
		public String getHvacModeCur() {
			return hvacMode;
		}
		public void setHvacModeCur(String hvacMode) {
			this.hvacMode = hvacMode;
		}
		/**
		 * @return the fanStatus
		 */
		@JsonProperty("fanStatus")
		public String getFanStatus() {
			return fanStatus;
		}
		/**
		 * @param fanStatus the fanStatus to set
		 */
		public void setFanStatus(String fanStatus) {
			this.fanStatus = fanStatus;
		}
		/**
		 * @return the overrideInProgress
		 */
		@JsonProperty("overrideInProgress")
		public String getOverrideInProgress() {
			return overrideInProgress;
		}
		/**
		 * @param overrideInProgress the overrideInProgress to set
		 */
		@JsonProperty("zoneOverride")
		public void setZoneOverride(String zoneOverride) {
			this.overrideInProgress = zoneOverride;
		}
		/**
		 * @return the zoneTempSetPoint
		 */
		@JsonProperty("zoneTempSetPoint")
		public String getZoneTempSetPoint() {
			return zoneTempSetPoint;
		}
		/**
		 * @param zoneTempSetPoint the zoneTempSetPoint to set
		 */
		@JsonProperty("currentSetpoint")
		public void setCurrentSetpoint(String zoneTempSetPoint) {
			this.zoneTempSetPoint = zoneTempSetPoint;
		}
		/**
		 * @return the rtuOccupiedStatus
		 */
		@JsonProperty("rtuOccupiedStatus")
		public String getRtuOccupiedStatus() {
			return rtuOccupiedStatus;
		}
		/**
		 * @param rtuOccupiedStatus the rtuOccupiedStatus to set
		 */
		@JsonProperty("occupiedStatus")
		public void setOccupiedStatus(String occupiedStatus) {
			this.rtuOccupiedStatus = occupiedStatus;
		}
		/**
		 * @return the zoneTemp
		 */
		@JsonProperty("zoneTemp")
		public String getZoneTemp() {
			return zoneTemp;
		}
		/**
		 * @param zoneTemp the zoneTemp to set
		 */
		@JsonProperty("zoneTemp")
		public void setZoneTemp(String zoneTemp) {
			this.zoneTemp = zoneTemp;
		}
		/**
		 * @return the dischargeAirTemp
		 */
		@JsonProperty("dischargeAirTemp")
		public String getDischargeAirTemp() {
			return dischargeAirTemp;
		}
		/**
		 * @param dischargeAirTemp the dischargeAirTemp to set
		 */
		//@JsonProperty("AI24")
		public void setDischargeAirTemp(String dischargeAirTemp) {		
			this.dischargeAirTemp = dischargeAirTemp;
		}
		/**
		 * @return the supplyAirTemp
		 */
		@JsonProperty("supplyAirTemp")
		public String getSupplyAirTemp() {
			return supplyAirTemp;
		}
		/**
		 * @param supplyAirTemp the supplyAirTemp to set
		 */
		@JsonProperty("supplyAirTemp")
		public void setSupplyAirTemp(String supplyAirTemp) {
			this.supplyAirTemp = supplyAirTemp;
		}
		/**
		 * @return the returnAirTemp
		 */
		@JsonProperty("returnAirTemp")
		public String getReturnAirTemp() {
			return returnAirTemp;
		}
		/**
		 * @param returnAirTemp the returnAirTemp to set
		 */
		@JsonProperty("returnAirTemp")
		public void setReturnAirTemp(String returnAirTemp) {
			this.returnAirTemp = returnAirTemp;
		}
		/**
		 * @return the returnAirHumidity
		 */	
		public String getReturnAirHumidity() {
			return returnAirHumidity;
		}
		/**
		 * @param returnAirHumidity the returnAirHumidity to set
		 */	
		public void setReturnAirHumidity(String returnAirHumidity) {
			this.returnAirHumidity = returnAirHumidity;
		}
		/**
		 * @return the zoneHumidity
		 */
		@JsonProperty("zoneHumidity")
		public String getZoneHumidity() {
			return zoneHumidity;
		}
		/**
		 * @param zoneHumidity the zoneHumidity to set
		 */
		@JsonProperty("spaceAirHumidity")
		public void setSpaceAirHumidity(String zoneHumidity) {
			this.zoneHumidity = zoneHumidity;
		}
		/**
		 * @return the zoneCo2
		 */
		@JsonProperty("zoneCo2")
		public String getZoneCo2() {
			return zoneCo2;
		}
		/**
		 * @param zoneCo2 the zoneCo2 to set
		 */
		@JsonProperty("co2Level")
		public void setCo2Level(String zoneCo2) {
			this.zoneCo2 = zoneCo2;
		}
		/**
		 * @return the hvacStatusCntrl
		 */
		
		public String getHvacStatusCntrl() {
			return hvacStatusCntrl;
		}
		/**
		 * @param hvacStatusCntrl the hvacStatusCntrl to set
		 */
		
		public void setMSO08(String hvacStatusCntrl) {
			this.hvacStatusCntrl = hvacStatusCntrl;
		}
		/**
		 * @return the hvacModeContrl
		 */
		public String getHvacModeContrl() {
			return hvacModeContrl;
		}
		/**
		 * @param hvacModeContrl the hvacModeContrl to set
		 */
		@JsonProperty("hvacMode")
		public void setHvacModeContrl(String hvacModeContrl) {
			this.hvacModeContrl = hvacModeContrl;
		}
		/**
		 * @return the fanMode
		 */
		
		public String getFanMode() {
			return fanMode;
		}
		/**
		 * @param fanMode the fanMode to set
		 */
		
		public void setFanMode(String fanMode) {
			this.fanMode = fanMode;
		}
		/**
		 * @return the coolSetPoint
		 */
		@JsonProperty("coolSetPoint")
		public String getCoolSetPoint() {
			return coolSetPoint;
		}
		/**
		 * @param coolSetPoint the coolSetPoint to set
		 */
		
		public void setCoolSetPoint(String coolSetPoint) {
			this.coolSetPoint = coolSetPoint;
		}
		/**
		 * @return the heatSetPoint
		 */
		@JsonProperty("heatSetPoint")
		public String getHeatSetPoint() {
			return heatSetPoint;
		}
		/**
		 * @param heatSetPoint the heatSetPoint to set
		 */
		public void setAO31(String heatSetPoint) {
			this.heatSetPoint = heatSetPoint;
		}
		/**
		 * @return the overrideDegMin
		 */
		@JsonProperty("overrideDegMin")
		public String getOverrideDegMin() {
			return overrideDegMin;
		}
		/**
		 * @param overrideDegMin the overrideDegMin to set
		 */
		public void setOverrideDegMin(String overrideDegMin) {
			this.overrideDegMin = overrideDegMin;
		}
		/**
		 * @return the scheduledSetPoint
		 */
		@JsonProperty("scheduledSetPoint")
		public String getScheduledSetPoint() {
			return scheduledSetPoint;
		}
		/**
		 * @param scheduledSetPoint the scheduledSetPoint to set
		 */	
		@JsonProperty("scheduledSetpoint")
		public void setScheduledSetPoint(String scheduledSetPoint) {
			this.scheduledSetPoint = scheduledSetPoint;
		}
		/**
		 * @return the scheduledAsOccupied
		 */
		@JsonProperty("scheduledAsOccupied")
		public String getScheduledAsOccupied() {
			return scheduledAsOccupied;
		}
		/**
		 * @param scheduledAsOccupied the scheduledAsOccupied to set
		 */
		@JsonProperty("scheduledAsOccupied")
		public void setScheduledAsOccupied(String scheduledAsOccupied) {
			this.scheduledAsOccupied = scheduledAsOccupied;
		}
		/**
		 * @return the relayState
		 */
		@JsonProperty("relayState")
		public String getRelayState() {
			return relayState;
		}
		/**
		 * @param relayState the relayState to set
		 */
		@JsonProperty("relayState")
		public void setRelayState(String relayState) {
			this.relayState = relayState;
		}
		/**
		 * @return the economizerEnabled
		 */
		@JsonProperty("economizerEnabled")
		public String getEconomizerEnabled() {
			return economizerEnabled;
		}
		/**
		 * @param economizerEnabled the economizerEnabled to set
		 */
		public void setEconomizerEnabled(String economizerEnabled) {
			this.economizerEnabled = economizerEnabled;
		}
		/**
		 * @return the economizerActive
		 */
		@JsonProperty("economizerActive")
		public String getEconomizerActive() {
			return economizerActive;
		}
		/**
		 * @param economizerActive the economizerActive to set
		 */
		
		public void setEconomizerActive(String economizerActive) {
			this.economizerActive = economizerActive;
		}
		/**
		 * @return the minimumDamperPositionSetPoint
		 */
		@JsonProperty("minimumDamperPositionSetPoint")
		public String getMinimumDamperPositionSetPoint() {
			return minimumDamperPositionSetPoint;
		}
		/**
		 * @param minimumDamperPositionSetPoint the minimumDamperPositionSetPoint to set
		 */
		@JsonProperty("minimumDamperPositionSetPoint")
		public void setMinimumDamperPositionSetPoint(String minimumDamperPositionSetPoint) {
			this.minimumDamperPositionSetPoint = minimumDamperPositionSetPoint;
		}
		/**
		 * @return the minDamperPosition
		 */
		@JsonProperty("minDamperPosition")
		public String getMinDamperPosition() {
			return minDamperPosition;
		}
		/**
		 * @param minDamperPosition the minDamperPosition to set
		 */
		@JsonProperty("damperPosition")
		public void setDamperPosition(String minDamperPosition) {
			this.minDamperPosition = minDamperPosition;
		}
		/**
		 * @return the mixedAirTemp
		 */
		@JsonProperty("mixedAirTemp")
		public String getMixedAirTemp() {
			return mixedAirTemp;
		}
		/**
		 * @param mixedAirTemp the mixedAirTemp to set
		 */
		@JsonProperty("AI25")
		public void setMixedAirTemp(String mixedAirTemp) {
			this.mixedAirTemp = mixedAirTemp;
		}
		/**
		 * @return the outdoorTemperature
		 */
		@JsonProperty("outdoorTemperature")
		public String getOutdoorTemperature() {
			return outdoorTemperature;
		}
		/**
		 * @param weatherCurrent the weatherCurrent to set
		 */
		@JsonProperty("weatherCurrent")
		public void setWeatherCurrent(String weatherCurrent) {
			this.outdoorTemperature = weatherCurrent;
		}
		/**
		 * @return the outdoorHumidity
		 */
		@JsonProperty("outdoorHumidity")
		public String getOutdoorHumidity() {
			return outdoorHumidity;
		}
		/**
		 * @param weatherHumidity the weatherHumidity to set
		 */
		@JsonProperty("weatherHumidity")
		public void setWeatherHumidity(String weatherHumidity) {
			this.outdoorHumidity = weatherHumidity;
		}
		
		/**
		 * @return the highPressureCutOffCompressorOne
		 */
		@JsonProperty("highPressureCutOffCompressorOne")
		public String getHighPressureCutOffCompressorOne() {
			return highPressureCutOffCompressorOne;
		}
		/**
		 * @param highPressureCutOffCompressorOne the highPressureCutOffCompressorOne to set
		 */
		@JsonProperty("highPressureCutOffCompressorOne")
		public void setHighPressureCutOffCompressorOne(String highPressureCutOffCompressorOne) {
			this.highPressureCutOffCompressorOne = highPressureCutOffCompressorOne;
		}
		/**
		 * @return the lowPressureCutOffCompressorOne
		 */
		@JsonProperty("lowPressureCutOffCompressorOne")
		public String getLowPressureCutOffCompressorOne() {
			return lowPressureCutOffCompressorOne;
		}
		/**
		 * @param lowPressureCutOffCompressorOne the lowPressureCutOffCompressorOne to set
		 */
		@JsonProperty("lowPressureCutOffCompressorOne")
		public void setLowPressureCutOffCompressorOne(String lowPressureCutOffCompressorOne) {
			this.lowPressureCutOffCompressorOne = lowPressureCutOffCompressorOne;
		}
		/**
		 * @return the highPressureCutOffCompressorTwo
		 */
		@JsonProperty("highPressureCutOffCompressorTwo")
		public String getHighPressureCutOffCompressorTwo() {
			return highPressureCutOffCompressorTwo;
		}
		/**
		 * @param highPressureCutOffCompressorTwo the highPressureCutOffCompressorTwo to set
		 */
		@JsonProperty("highPressureCutOffCompressorTwo")
		public void setHighPressureCutOffCompressorTwo(String highPressureCutOffCompressorTwo) {
			this.highPressureCutOffCompressorTwo = highPressureCutOffCompressorTwo;
		}
		/**
		 * @return the lowPressureCutOffCompressorTwo
		 */
		@JsonProperty("lowPressureCutOffCompressorTwo")
		public String getLowPressureCutOffCompressorTwo() {
			return lowPressureCutOffCompressorTwo;
		}
		/**
		 * @param lowPressureCutOffCompressorTwo the lowPressureCutOffCompressorTwo to set
		 */
		@JsonProperty("BI245")
		public void setLowPressureCutOffCompressorTwo(String lowPressureCutOffCompressorTwo) {
			this.lowPressureCutOffCompressorTwo = lowPressureCutOffCompressorTwo;
		}
		/**
		 * @return the erv
		 */
		@JsonProperty("erv")
		public String getErv() {
			return erv;
		}
		/**
		 * @param erv the erv to set
		 */
		//@JsonProperty("")
		public void setErv(String erv) {
			this.erv = erv;
		}
		
		/**
		 * @return the rtConnectionEstablished
		 */
		public boolean isRtConnectionEstablished() {
			return rtConnectionEstablished;
		}
		/**
		 * @param rtConnectionEstablished the rtConnectionEstablished to set
		 */
		public void setRtConnectionEstablished(boolean rtConnectionEstablished) {
			this.rtConnectionEstablished = rtConnectionEstablished;
		}
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
		 * @return the rtCommandEstablished
		 */
		public boolean isRtCommandEstablished() {
			return rtCommandEstablished;
		}
		/**
		 * @param rtCommandEstablished the rtCommandEstablished to set
		 */
		public void setRtCommandEstablished(boolean rtCommandEstablished) {
			this.rtCommandEstablished = rtCommandEstablished;
		}
		/**
		 * @return the algorithm
		 */
		public String getAlgorithm() {
			return algorithm;
		}
		/**
		 * @param algorithm the algorithm to set
		 */
		public void setAlgorithm(String algorithm) {
			this.algorithm = algorithm;
		}
		/**
		 * @return the unitStopSource
		 */
		 @JsonProperty("unitStopSource")
		public String getUnitStopSource() {
			return unitStopSource;
		}
		/**
		 * @param unitStopSource the unitStopSource to set
		 */
		 @JsonProperty("unitStopSource")
		public void setUnitStopSource(String unitStopSource) {
			this.unitStopSource = unitStopSource;
		}
		/**
		 * @return the smokeDetectors
		 */
		 @JsonProperty("smokeDetectors")
		public String getSmokeDetectors() {
			return smokeDetectors;
		}
		/**
		 * @param smokeDetectors the smokeDetectors to set
		 */
		 @JsonProperty("smokeDetectors")
		public void setSmokeDetectors(String smokeDetectors) {
			this.smokeDetectors = smokeDetectors;
		}
		 /**
		  * 
		  * @return
		  */
		public String getMake() {
			return make;
		}
		
		/**
		 * 
		 * @param make
		 */
		public void setMake(String make) {
			this.make = make;
		}
		/**
		 * @return the model
		 */
		public String getModel() {
			return model;
		}
		/**
		 * @param model the model to set
		 */
		public void setModel(String model) {
			this.model = model;
		}
		/**
		 * @return the tonnage
		 */
		public String getTonnage() {
			return tonnage;
		}
		/**
		 * @param tonnage the tonnage to set
		 */
		public void setTonnage(String tonnage) {
			this.tonnage = tonnage;
		}
		/**
		 * @return the weatherHigh
		 */
		public String getWeatherHigh() {
			return weatherHigh;
		}
		/**
		 * @param weatherHigh the weatherHigh to set
		 */
		public void setWeatherHigh(String weatherHigh) {
			this.weatherHigh = weatherHigh;
		}
		/**
		 * @return the isCelsius
		 */
		@JsonProperty("isCelsius")
		public boolean isCelsius() {
			return isCelsius;
		}
		/**
		 * @param isCelsius the isCelsius to set
		 */
		@JsonProperty("isCelsius")
		public void setIsCelsius(boolean isCelsius) {
			this.isCelsius = isCelsius;
		}
		/**
		 * @return the displayName
		 */
		public String getDisplayName() {
			return displayName;
		}
		/**
		 * @param displayName the displayName to set
		 */
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		/**
		 * @return the systemId
		 */
		public String getSystemId() {
			return systemId;
		}
		/**
		 * @param systemId the systemId to set
		 */
		public void setSystemId(String systemId) {
			this.systemId = systemId;
		}
		/**
		 * @return the systemType
		 */
		public String getSystemType() {
			return systemType;
		}
		/**
		 * @param systemType the systemType to set
		 */
		public void setSystemType(String systemType) {
			this.systemType = systemType;
		}
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
		/**
		 * @return the temperature
		 */
		public String getTemperature() {
			return temperature;
		}
		/**
		 * @param temperature the temperature to set
		 */
		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}
		/**
		 * @return the kwValue
		 */
		public String getKwValue() {
			return kwValue;
		}
		/**
		 * @param kwValue the kwValue to set
		 */
		public void setKwValue(String kwValue) {
			this.kwValue = kwValue;
		}
		/**
		 * @return the timeOpen
		 */
		public String getTimeOpen() {
			return timeOpen;
		}
		/**
		 * @param timeOpen the timeOpen to set
		 */
		public void setTimeOpen(String timeOpen) {
			this.timeOpen = timeOpen;
		}
		
		/**
		 * @return the weatherLow
		 */
		public String getWeatherLow() {
			return weatherLow;
		}
		/**
		 * @param weatherLow the weatherLow to set
		 */
		public void setWeatherLow(String weatherLow) {
			this.weatherLow = weatherLow;
		}
		/**
		 * @return the spaceAirHumidity
		 */
		public String getSpaceAirHumidity() {
			return spaceAirHumidity;
		}
		/**
		 * @return the spaceAirTemp
		 */
		public String getSpaceAirTemp() {
			return spaceAirTemp;
		}
		/**
		 * @param spaceAirTemp the spaceAirTemp to set
		 */
		public void setSpaceAirTemp(String spaceAirTemp) {
			this.spaceAirTemp = spaceAirTemp;
		}
		public  Map<String,String> getRawData() {
			return rawData;
		}
		public void setRawData( Map<String,String> rawData) {
			this.rawData = rawData;
		}	
	
}

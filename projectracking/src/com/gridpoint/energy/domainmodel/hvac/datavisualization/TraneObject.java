package com.gridpoint.energy.domainmodel.hvac.datavisualization;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;




public class TraneObject implements TraneAlarmCode{
	

	/**
	 * Connection Established Parameters
	 */
	private boolean rtConnectionEstablished=false;
	private boolean rtCommandEstablished=false;
	private boolean advView=true;
	
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
	 * General Widget Parameters
	 */
	private String make;
	private String model;
	private String tonnage;	
	private String unitStopSource;
	private String smokeDetectors;
	
	/**
	 * show feed
	 */
	private  Map<String,String> rawData;
	
	/**
	 * Other Trane Properties
	 */
	private String heatCapacityEnableSP;
	private String communications;
	private String coolingCapacityStatus;
	private String heatPrimaryCapacityStatus;
	private String heatSecondaryCapacityStatus;
	private String filterRuntimeHours;
	private String spaceTemperatureActive;
	private String dischargeAirTempActive;
	private String spaceTempCoolingSP;
	private String spaceTempHeatingSP;
	private String economizerMinimumPosSP;
	private String coolCapacityEnableSP;
	private String systemControlStatus;
	private String systemControlCommand;
	private String traneUnitType;
	private String economizerType;
	private String outdoorDamperStatus;
	private String alarms;
	
	
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
	 * @return the hvacStatus
	 */
	@JsonProperty("hvacStatus")
	public String getHvacStatus() {
		return TraneMapper.getHvacStatus(hvacStatus);
	}
	/**
	 * @param hvacStatus the hvacStatus to set
	 */
	@JsonProperty("MSI19")
	public void setMSI19(String hvacStatus) {
		this.hvacMode=hvacStatus;
		this.hvacStatus = hvacStatus;
	}
	/**
	 * @return the hvacMode
	 */
	@JsonProperty("hvacMode")
	public String getHvacMode() {
		return TraneMapper.getHvacMode(hvacMode);
	}
	
	/**
	 * @return the fanStatus
	 */
	@JsonProperty("fanStatus")
	public String getFanStatus() {
		return TraneMapper.getPresentageValue(fanStatus);
	}
	/**
	 * @param fanStatus the fanStatus to set
	 */
	@JsonProperty("AI07")
	public void setAI07(String fanStatus) {
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
	//@JsonProperty("")
	public void setOverrideInProgress(String overrideInProgress) {
		this.overrideInProgress = overrideInProgress;
	}
	/**
	 * @return the zoneTempSetPoint
	 */
	@JsonProperty("zoneTempSetPoint")
	public String getZoneTempSetPoint() {
		return TraneMapper.getTemp(zoneTempSetPoint);
	}
	/**
	 * @param zoneTempSetPoint the zoneTempSetPoint to set
	 */
	@JsonProperty("AI50")
	public void setAI50(String zoneTempSetPoint) {
		this.zoneTempSetPoint = zoneTempSetPoint;
	}
	/**
	 * @return the rtuOccupiedStatus
	 */
	@JsonProperty("rtuOccupiedStatus")
	public String getRtuOccupiedStatus() {
		return TraneMapper.getRTUOccupiedStatus(rtuOccupiedStatus);
	}
	/**
	 * @param rtuOccupiedStatus the rtuOccupiedStatus to set
	 */
	@JsonProperty("MSI20")
	public void setMSI20(String rtuOccupiedStatus) {
		this.rtuOccupiedStatus = rtuOccupiedStatus;
	}
	/**
	 * @return the zoneTemp
	 */
	@JsonProperty("zoneTemp")
	public String getZoneTemp() {
		return TraneMapper.getTemp(zoneTemp);
	}
	/**
	 * @param zoneTemp the zoneTemp to set
	 */
	@JsonProperty("AI87")
	public void setAI87(String zoneTemp) {
		this.zoneTemp = zoneTemp;
	}
	/**
	 * @return the dischargeAirTemp
	 */
	@JsonProperty("dischargeAirTemp")
	public String getDischargeAirTemp() {
		return TraneMapper.getTemp(dischargeAirTemp);
	}
	/**
	 * @param dischargeAirTemp the dischargeAirTemp to set
	 */
	@JsonProperty("AI24")
	public void setAI24(String dischargeAirTemp) {
		setDischargeAirTempActive(dischargeAirTemp);
		this.dischargeAirTemp = dischargeAirTemp;
	}
	/**
	 * @return the supplyAirTemp
	 */
	@JsonProperty("supplyAirTemp")
	public String getSupplyAirTemp() {
		return TraneMapper.getTemp(dischargeAirTemp);
	}
	/**
	 * @param supplyAirTemp the supplyAirTemp to set
	 */
	@JsonProperty("AI18")
	public void setAI18(String supplyAirTemp) {
		setOutdoorTemperature(supplyAirTemp);
		this.supplyAirTemp = supplyAirTemp;
	}
	/**
	 * @return the returnAirTemp
	 */
	@JsonProperty("returnAirTemp")
	public String getReturnAirTemp() {
		return TraneMapper.getTemp(returnAirTemp);
	}
	/**
	 * @param returnAirTemp the returnAirTemp to set
	 */
	@JsonProperty("AI26")
	public void setAI26(String returnAirTemp) {
		this.returnAirTemp = returnAirTemp;
	}
	/**
	 * @return the returnAirHumidity
	 */
	//@JsonProperty("returnAirHumidity")
	public String getReturnAirHumidity() {
		return returnAirHumidity;
	}
	/**
	 * @param returnAirHumidity the returnAirHumidity to set
	 */
	//@JsonProperty("")
	public void setReturnAirHumidity(String returnAirHumidity) {
		this.returnAirHumidity = returnAirHumidity;
	}
	/**
	 * @return the zoneHumidity
	 */
	@JsonProperty("zoneHumidity")
	public String getZoneHumidity() {
		return TraneMapper.getPresentageValue(zoneHumidity);
	}
	/**
	 * @param zoneHumidity the zoneHumidity to set
	 */
	@JsonProperty("AI16")
	public void setAI16(String zoneHumidity) {
		this.zoneHumidity = zoneHumidity;
	}
	/**
	 * @return the zoneCo2
	 */
	@JsonProperty("zoneCo2")
	public String getZoneCo2() {
		return TraneMapper.getZoneCO2(zoneCo2);
	}
	/**
	 * @param zoneCo2 the zoneCo2 to set
	 */
	@JsonProperty("AI32")
	public void setAI32(String zoneCo2) {
		this.zoneCo2 = zoneCo2;
	}
	/**
	 * @return the hvacStatusCntrl
	 */
	@JsonProperty("hvacStatusCntrl")
	public String getHvacStatusCntrl() {
		return TraneMapper.getApplicationContrl(hvacStatusCntrl);
	}
	/**
	 * @param hvacStatusCntrl the hvacStatusCntrl to set
	 */
	@JsonProperty("MSO08")
	public void setMSO08(String hvacStatusCntrl) {
		this.hvacModeContrl=hvacStatusCntrl;
		this.hvacStatusCntrl = hvacStatusCntrl;
	}
	/**
	 * @return the hvacModeContrl
	 */
	@JsonProperty("hvacModeContrl")
	public String getHvacModeContrl() {
		return TraneMapper.getApplicationStatusContrl(hvacModeContrl);
	}
	/**
	 * @param hvacModeContrl the hvacModeContrl to set
	 */
	//@JsonProperty("")
	public void setHvacModeContrl(String hvacModeContrl) {
		this.hvacModeContrl = hvacModeContrl;
	}
	/**
	 * @return the fanMode
	 */
	@JsonProperty("fanMode")
	public String getFanMode() {
		return TraneMapper.getSupplyFanStatus(fanMode);
	}
	/**
	 * @param fanMode the fanMode to set
	 */
	@JsonProperty("BO08")
	public void setBO08(String fanMode) {
		this.fanMode = fanMode;
	}
	/**
	 * @return the coolSetPoint
	 */
	@JsonProperty("coolSetPoint")
	public String getCoolSetPoint() {
		return TraneMapper.getTemp(coolSetPoint);
	}
	/**
	 * @param coolSetPoint the coolSetPoint to set
	 */
	@JsonProperty("AO32")
	public void setAO32(String coolSetPoint) {
		this.coolSetPoint = coolSetPoint;
	}
	/**
	 * @return the heatSetPoint
	 */
	@JsonProperty("heatSetPoint")
	public String getHeatSetPoint() {
		return TraneMapper.getTemp(heatSetPoint);
	}
	/**
	 * @param heatSetPoint the heatSetPoint to set
	 */
	@JsonProperty("AO31")
	public void setAO31(String heatSetPoint) {
		this.heatSetPoint = heatSetPoint;
	}
	/**
	 * @return the overrideDegMin
	 */
	@JsonProperty("overrideDegMin")
	public String getOverrideDegMin() {
		return TraneMapper.getTemp(overrideDegMin);
	}
	/**
	 * @param overrideDegMin the overrideDegMin to set
	 */
	@JsonProperty("AO29")
	public void setAO29(String overrideDegMin) {
		this.overrideDegMin = overrideDegMin;
	}
	/**
	 * @return the scheduledSetPoint
	 */
	@JsonProperty("scheduledSetPoint")
	public String getScheduledSetPoint() {
		return TraneMapper.getTemp(scheduledSetPoint);
	}
	/**
	 * @param scheduledSetPoint the scheduledSetPoint to set
	 */
	@JsonProperty("AO02")
	public void setAO02(String scheduledSetPoint) {
		this.scheduledSetPoint = scheduledSetPoint;
	}
	/**
	 * @return the scheduledAsOccupied
	 */
	@JsonProperty("scheduledAsOccupied")
	public String getScheduledAsOccupied() {
		return TraneMapper.getScheduledAsOccupied(scheduledAsOccupied);
	}
	/**
	 * @param scheduledAsOccupied the scheduledAsOccupied to set
	 */
	@JsonProperty("MSO07")
	public void setMSO07(String scheduledAsOccupied) {
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
	//@JsonProperty("")
	public void setRelayState(String relayState) {
		this.relayState = relayState;
	}
	/**
	 * @return the economizerEnabled
	 */
	@JsonProperty("economizerEnabled")
	public String getEconomizerEnabled() {
		return TraneMapper.getEconomizerEnable(economizerEnabled);
	}
	/**
	 * @param economizerEnabled the economizerEnabled to set
	 */
	@JsonProperty("MSI44")
	public void setMSI44(String economizerEnabled) {
		this.economizerEnabled = economizerEnabled;
	}
	/**
	 * @return the economizerActive
	 */
	@JsonProperty("economizerActive")
	public String getEconomizerActive() {
		return TraneMapper.getEconomizerActive(economizerActive);
	}
	/**
	 * @param economizerActive the economizerActive to set
	 */
	@JsonProperty("MSO01")
	public void setMSO01(String economizerActive) {
		this.economizerActive = economizerActive;
	}
	/**
	 * @return the minimumDamperPositionSetPoint
	 */
	@JsonProperty("minimumDamperPositionSetPoint")
	public String getMinimumDamperPositionSetPoint() {
		return TraneMapper.getPresentageValue(minimumDamperPositionSetPoint);
	}
	/**
	 * @param minimumDamperPositionSetPoint the minimumDamperPositionSetPoint to set
	 */
	@JsonProperty("AO01")
	public void setAO01(String minimumDamperPositionSetPoint) {
		this.minimumDamperPositionSetPoint = minimumDamperPositionSetPoint;
	}
	/**
	 * @return the minDamperPosition
	 */
	@JsonProperty("minDamperPosition")
	public String getMinDamperPosition() {
		return TraneMapper.getPresentageValue(minDamperPosition);
	}
	/**
	 * @param minDamperPosition the minDamperPosition to set
	 */
	@JsonProperty("AI11")
	public void setAI11(String minDamperPosition) {
		this.minDamperPosition = minDamperPosition;
	}
	/**
	 * @return the mixedAirTemp
	 */
	@JsonProperty("mixedAirTemp")
	public String getMixedAirTemp() {
		return TraneMapper.getTemp(mixedAirTemp);
	}
	/**
	 * @param mixedAirTemp the mixedAirTemp to set
	 */
	@JsonProperty("AI25")
	public void setAI25(String mixedAirTemp) {
		this.mixedAirTemp = mixedAirTemp;
	}
	/**
	 * @return the outdoorTemperature
	 */
	@JsonProperty("outdoorTemperature")
	public String getOutdoorTemperature() {
		return TraneMapper.getTemp(outdoorTemperature);
	}
	/**
	 * @param outdoorTemperature the outdoorTemperature to set
	 */
	//@JsonProperty("AI18")
	public void setOutdoorTemperature(String outdoorTemperature) {
		this.outdoorTemperature = outdoorTemperature;
	}
	/**
	 * @return the outdoorHumidity
	 */
	@JsonProperty("outdoorHumidity")
	public String getOutdoorHumidity() {
		return TraneMapper.getOutdoorHumidity(outdoorHumidity);
	}
	/**
	 * @param outdoorHumidity the outdoorHumidity to set
	 */
	@JsonProperty("AI20")
	public void setAI20(String outdoorHumidity) {
		this.outdoorHumidity = outdoorHumidity;
	}
	
	/**
	 * @return the highPressureCutOffCompressorOne
	 */
	@JsonProperty("highPressureCutOffCompressorOne")
	public String getHighPressureCutOffCompressorOne() {
		return (TraneMapper.decipherAlarmCode(getAlarms(),TraneAlarmCode.COMPRESSOR_1_HPC_LOCKOUT));
	}
	/**
	 * @param highPressureCutOffCompressorOne the highPressureCutOffCompressorOne to set
	 */
	@JsonProperty("BI269")
	public void setBI269(String highPressureCutOffCompressorOne) {
		this.highPressureCutOffCompressorOne = highPressureCutOffCompressorOne;
	}
	/**
	 * @return the lowPressureCutOffCompressorOne
	 */
	@JsonProperty("lowPressureCutOffCompressorOne")
	public String getLowPressureCutOffCompressorOne() {
		return TraneMapper.decipherAlarmCode(getAlarms(),TraneAlarmCode.COMPRESSOR_1_LPC_LOCKOUT);
	}
	/**
	 * @param lowPressureCutOffCompressorOne the lowPressureCutOffCompressorOne to set
	 */
	@JsonProperty("BI244")
	public void setBI244(String lowPressureCutOffCompressorOne) {
		this.lowPressureCutOffCompressorOne = lowPressureCutOffCompressorOne;
	}
	/**
	 * @return the highPressureCutOffCompressorTwo
	 */
	@JsonProperty("highPressureCutOffCompressorTwo")
	public String getHighPressureCutOffCompressorTwo() {
		return TraneMapper.decipherAlarmCode(getAlarms(),TraneAlarmCode.COMPRESSOR_2_HPC_LOCKOUT);
	}
	/**
	 * @param highPressureCutOffCompressorTwo the highPressureCutOffCompressorTwo to set
	 */
	@JsonProperty("BI270")
	public void setBI270(String highPressureCutOffCompressorTwo) {
		this.highPressureCutOffCompressorTwo = highPressureCutOffCompressorTwo;
	}
	/**
	 * @return the lowPressureCutOffCompressorTwo
	 */
	@JsonProperty("lowPressureCutOffCompressorTwo")
	public String getLowPressureCutOffCompressorTwo() {
		return TraneMapper.decipherAlarmCode(getAlarms(),TraneAlarmCode.COMPRESSOR_2_LPC_LOCKOUT);
	}
	/**
	 * @param lowPressureCutOffCompressorTwo the lowPressureCutOffCompressorTwo to set
	 */
	@JsonProperty("BI245")
	public void setBI245(String lowPressureCutOffCompressorTwo) {
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
	 * @return the heatCapacityEnableSP
	 */
	@JsonProperty("heatCapacityEnableSP")
	public String getHeatCapacityEnableSP() {
		return heatCapacityEnableSP;
	}
	/**
	 * @param heatCapacityEnableSP the heatCapacityEnableSP to set
	 */
	@JsonProperty("AO20")
	public void setAO20(String heatCapacityEnableSP) {
		this.heatCapacityEnableSP = heatCapacityEnableSP;
	}
	/**
	 * @return the communications
	 */
	@JsonProperty("communications")
	public String getCommunications() {
		return communications;
	}
	/**
	 * @param communications the communications to set
	 */
	@JsonProperty("communications")
	public void setCommunications(String communications) {
		this.communications = communications;
	}
	/**
	 * @return the coolingCapacityStatus
	 */
	@JsonProperty("coolingCapacityStatus")
	public String getCoolingCapacityStatus() {
		return coolingCapacityStatus;
	}
	/**
	 * @param coolingCapacityStatus the coolingCapacityStatus to set
	 */
	@JsonProperty("AI01")
	public void setAI01(String coolingCapacityStatus) {
		this.coolingCapacityStatus = coolingCapacityStatus;
	}
	/**
	 * @return the heatPrimaryCapacityStatus
	 */
	@JsonProperty("heatPrimaryCapacityStatus")
	public String getHeatPrimaryCapacityStatus() {
		return heatPrimaryCapacityStatus;
	}
	/**
	 * @param heatPrimaryCapacityStatus the heatPrimaryCapacityStatus to set
	 */
	@JsonProperty("AI02")
	public void setAI02(String heatPrimaryCapacityStatus) {
		this.heatPrimaryCapacityStatus = heatPrimaryCapacityStatus;
	}
	/**
	 * @return the heatSecondaryCapacityStatus
	 */
	@JsonProperty("heatSecondaryCapacityStatus")
	public String getHeatSecondaryCapacityStatus() {
		return heatSecondaryCapacityStatus;
	}
	/**
	 * @param heatSecondaryCapacityStatus the heatSecondaryCapacityStatus to set
	 */
	@JsonProperty("AI03")
	public void setAI03(String heatSecondaryCapacityStatus) {
		this.heatSecondaryCapacityStatus = heatSecondaryCapacityStatus;
	}
	/**
	 * @return the filterRuntimeHours
	 */
	@JsonProperty("filterRuntimeHours")
	public String getFilterRuntimeHours() {
		return filterRuntimeHours;
	}
	/**
	 * @param filterRuntimeHours the filterRuntimeHours to set
	 */
	@JsonProperty("AI06")
	public void setAI06(String filterRuntimeHours) {
		this.filterRuntimeHours = filterRuntimeHours;
	}
	/**
	 * @return the spaceTemperatureActive
	 */
	@JsonProperty("spaceTemperatureActive")
	public String getSpaceTemperatureActive() {
		return spaceTemperatureActive;
	}
	/**
	 * @param spaceTemperatureActive the spaceTemperatureActive to set
	 */
	@JsonProperty("AI15")
	public void setAI15(String spaceTemperatureActive) {
		this.spaceTemperatureActive = spaceTemperatureActive;
	}
	/**
	 * @return the dischargeAirTempActive
	 */
	@JsonProperty("dischargeAirTempActive")
	public String getDischargeAirTempActive() {
		return dischargeAirTempActive;
	}
	/**
	 * @param dischargeAirTempActive the dischargeAirTempActive to set
	 */	
	public void setDischargeAirTempActive(String dischargeAirTempActive) {
		this.dischargeAirTempActive = dischargeAirTempActive;
	}
	/**
	 * @return the spaceTempCoolingSP
	 */
	@JsonProperty("spaceTempCoolingSP")
	public String getSpaceTempCoolingSP() {
		return spaceTempCoolingSP;
	}
	/**
	 * @param spaceTempCoolingSP the spaceTempCoolingSP to set
	 */
	@JsonProperty("AI74")
	public void setAI74(String spaceTempCoolingSP) {
		this.spaceTempCoolingSP = spaceTempCoolingSP;
	}
	/**
	 * @return the spaceTempHeatingSP
	 */
	@JsonProperty("spaceTempHeatingSP")
	public String getSpaceTempHeatingSP() {
		return spaceTempHeatingSP;
	}
	/**
	 * @param spaceTempHeatingSP the spaceTempHeatingSP to set
	 */
	@JsonProperty("AI75")
	public void setAI75(String spaceTempHeatingSP) {
		this.spaceTempHeatingSP = spaceTempHeatingSP;
	}
	/**
	 * @return the economizerMinimumPosSP
	 */
	@JsonProperty("economizerMinimumPosSP")
	public String getEconomizerMinimumPosSP() {
		return economizerMinimumPosSP;
	}
	/**
	 * @param economizerMinimumPosSP the economizerMinimumPosSP to set
	 */
	@JsonProperty("AI86")
	public void setAI86(String economizerMinimumPosSP) {
		this.economizerMinimumPosSP = economizerMinimumPosSP;
	}
	/**
	 * @return the coolCapacityEnableSP
	 */
	@JsonProperty("coolCapacityEnableSP")
	public String getCoolCapacityEnableSP() {
		return coolCapacityEnableSP;
	}
	/**
	 * @param coolCapacityEnableSP the coolCapacityEnableSP to set
	 */
	@JsonProperty("AO19")
	public void setAO19(String coolCapacityEnableSP) {
		this.coolCapacityEnableSP = coolCapacityEnableSP;
	}
	/**
	 * @return the systemControlStatus
	 */
	@JsonProperty("systemControlStatus")
	public String getSystemControlStatus() {
		return systemControlStatus;
	}
	/**
	 * @param systemControlStatus the systemControlStatus to set
	 */
	 @JsonProperty("BI01")
	public void setBI01(String systemControlStatus) {
		this.systemControlStatus = systemControlStatus;
	}
	/**
	 * @return the systemControlCommand
	 */
	 @JsonProperty("systemControlCommand")
	public String getSystemControlCommand() {
		return systemControlCommand;
	}
	/**
	 * @param systemControlCommand the systemControlCommand to set
	 */
	 @JsonProperty("BO07")
	public void setBO07(String systemControlCommand) {
		this.systemControlCommand = systemControlCommand;
	}
	/**
	 * @return the traneUnitType
	 */
	 @JsonProperty("traneUnitType")
	public String getTraneUnitType() {
		return traneUnitType;
	}
	/**
	 * @param traneUnitType the traneUnitType to set
	 */
	 @JsonProperty("MSI02")
	public void setMSI02(String traneUnitType) {
		this.traneUnitType = traneUnitType;
	}
	/**
	 * @return the economizerType
	 */
	 @JsonProperty("economizerType")
	public String getEconomizerType() {
		return economizerType;
	}
	/**
	 * @param economizerType the economizerType to set
	 */
	 @JsonProperty("MSI09")
	public void setMSI09(String economizerType) {
		this.economizerType = economizerType;
	}
	/**
	 * @return the outdoorDamperStatus
	 */
	 @JsonProperty("outdoorDamperStatus")
	public String getOutdoorDamperStatus() {
		return outdoorDamperStatus;
	}
	/**
	 * @param outdoorDamperStatus the outdoorDamperStatus to set
	 */
	 @JsonProperty("MSI43")
	public void setMSI43(String outdoorDamperStatus) {
		this.outdoorDamperStatus = outdoorDamperStatus;
	}
	/**
	 * @return the alarams
	 */
	 @JsonProperty("Alarms")
	public String getAlarms() {
		return alarms;
	}
	/**
	 * @param alarams the alarams to set
	 */
	 @JsonProperty("Alarms")
	public void setAlarms(String alarms) {
		this.alarms = alarms;
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
		return TraneMapper.getUnitStopSource(unitStopSource);
	}
	/**
	 * @param unitStopSource the unitStopSource to set
	 */
	 @JsonProperty("MSI21")
	public void setMSI21(String unitStopSource) {
		this.unitStopSource = unitStopSource;
	}
	/**
	 * @return the smokeDetectors
	 */
	 @JsonProperty("smokeDetectors")
	public String getSmokeDetectors() {
		return TraneMapper.getSmokeDetectorsValue(smokeDetectors);
	}
	/**
	 * @param smokeDetectors the smokeDetectors to set
	 */
	 @JsonProperty("BI246")
	public void setBI246(String smokeDetectors) {
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
	public  Map<String,String> getRawData() {
		return rawData;
	}
	public void setRawData( Map<String,String> rawData) {
		this.rawData = rawData;
	}
	
}

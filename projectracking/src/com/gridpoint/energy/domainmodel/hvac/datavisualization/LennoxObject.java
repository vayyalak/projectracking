package com.gridpoint.energy.domainmodel.hvac.datavisualization;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;



public class LennoxObject {
	
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
	
	private String highPressureCutOffCompressorThree;
	private String lowPressureCutOffCompressorThree;
	private String highPressureCutOffCompressorFour;
	private String lowPressureCutOffCompressorFour;
	
	private String erv;
	
	/**
	 * Algorithm Widget Parameters
	 */
	private String algorithm;		
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
	 * show feed
	 */
	private  Map<String,String> rawData;
	
	/**
	 * Other linnox properties
	 * 
	 */
	private String primaryHeatControl;
	private String heatUnoccupiedSetPoint;
	private String compressorEnableControl;
	private String coolUnoccupiedSetPoint;	
	private String spaceTempInput;
	private String exhaustFanStatus;
	private String ductStaticPressure;
	private String buildingStaticPressure; 
	private String auxHeatControl;
	private String dehumidificationSP;
	private String heatPrimary;
	private String localSpaceTemp;
	private String occupancyScheduleControl;
	private String occupancyOvrdControl;
	private String coolPrimary;
	private String heatSecondary;
	private String dischargeAirCoolSP;
	private String ductStaticSP;
	private String buildingStaticSP;
	private String effSpaceHumidity;
	private String effDehumidSP;
	private String communications;
	private String dehumidStatus;
	private String unitID;
	private String errorCodes;
	private String currentError;
	private String effSpaceCO2;

	
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
	@JsonProperty("hvacStatus")
	public String getHvacStatus() {
		return LennoxMapper.getHvacStatus(hvacStatus);
	}
	
	@JsonProperty("232")
	public void set232(String hvacStatus) {
		this.hvacMode=hvacStatus;
		this.hvacStatus = hvacStatus;
	}

	/**
	 * @return the hvacMode
	 */
	@JsonProperty("hvacMode")
	public String getHvacMode() {		
		return LennoxMapper.getHvacStatus(hvacMode);
	}


	/**
	 * @return the fanStatus
	 */
	@JsonProperty("fanStatus")
	public String getFanStatus() {
		return LennoxMapper.getFanStatus(fanStatus);
	}

	/**
	 * @param fanStatus the fanStatus to set
	 */
	@JsonProperty("250")
	public void set250(String fanStatus) {
		this.fanStatus = fanStatus;
	}

	/**
	 * @return the overrideInProgress
	 */
	@JsonProperty("overrideInProgress")
	public String getOverrideInProgress() {
		return LennoxMapper.getOverrideInProgress(overrideInProgress);
	}

	/**
	 * @param overrideInProgress the overrideInProgress to set
	 */
	@JsonProperty("114")
	public void set114(String overrideInProgress) {
		this.overrideInProgress = overrideInProgress;
	}

	/**
	 * @return the zoneTempSetPoint
	 */
	@JsonProperty("zoneTempSetPoint")
	public String getZoneTempSetPoint() {
		return LennoxMapper.getTemp(zoneTempSetPoint);
	}

	/**
	 * @param zoneTempSetPoint the zoneTempSetPoint to set
	 */
	@JsonProperty("252")
	public void set252(String zoneTempSetPoint) {
		this.zoneTempSetPoint = zoneTempSetPoint;
	}

	/**
	 * @return the rtuOccupiedStatus
	 */
	@JsonProperty("rtuOccupiedStatus")
	public String getRtuOccupiedStatus() {
		return LennoxMapper.getRTUOccupiedStatus(rtuOccupiedStatus);
	}

	/**
	 * @param rtuOccupiedStatus the rtuOccupiedStatus to set
	 */
	@JsonProperty("241")
	public void set241(String rtuOccupiedStatus) {
		this.rtuOccupiedStatus = rtuOccupiedStatus;
	}

	/**
	 * @return the zoneTemp
	 */
	@JsonProperty("zoneTemp")
	public String getZoneTemp() {
		return LennoxMapper.getTemp(zoneTemp);
	}

	/**
	 * @param zoneTemp the zoneTemp to set
	 */
	@JsonProperty("239")
	public void set239(String zoneTemp) {
		this.zoneTemp = zoneTemp;
	}

	/**
	 * @return the dischargeAirTemp
	 */
	@JsonProperty("dischargeAirTemp")
	public String getDischargeAirTemp() {
		return LennoxMapper.getTemp(dischargeAirTemp);
	}

	/**
	 * @param dischargeAirTemp the dischargeAirTemp to set
	 */
	@JsonProperty("240")
	public void set240(String dischargeAirTemp) {
		this.dischargeAirTemp = dischargeAirTemp;
	}

	/**
	 * @return the supplyAirTemp
	 */
	@JsonProperty("supplyAirTemp")
	public String getSupplyAirTemp() {
		return LennoxMapper.getTemp(dischargeAirTemp);
	}

	/**
	 * @param supplyAirTemp the supplyAirTemp to set
	 */
	@JsonProperty("242")
	public void set242(String supplyAirTemp) {
		this.supplyAirTemp = supplyAirTemp;
	}

	/**
	 * @return the returnAirTemp
	 */
	@JsonProperty("returnAirTemp")
	public String getReturnAirTemp() {
		return LennoxMapper.getTemp(returnAirTemp);
	}

	/**
	 * @param returnAirTemp the returnAirTemp to set
	 */
	@JsonProperty("281")
	public void set281(String returnAirTemp) {
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
		return LennoxMapper.getZoneHumidity(zoneHumidity);
	}

	/**
	 * @param zoneHumidity the zoneHumidity to set
	 */
	@JsonProperty("277")
	public void set277(String zoneHumidity) {
		this.zoneHumidity = zoneHumidity;
	}

	/**
	 * @return the zoneCo2
	 */
	@JsonProperty("zoneCo2")
	public String getZoneCo2() {
		return LennoxMapper.getZoneCO2(zoneCo2);
	}

	/**
	 * @param zoneCo2 the zoneCo2 to set
	 */
	@JsonProperty("275")
	public void set275(String zoneCo2) {
		this.zoneCo2 = zoneCo2;
	}

	/**
	 * @return the hvacStatusCntrl
	 */
	@JsonProperty("hvacStatusCntrl")
	public String getHvacStatusCntrl() {
		return LennoxMapper.getApplicationContrl(hvacStatusCntrl);
	}

	/**
	 * @param hvacStatusCntrl the hvacStatusCntrl to set
	 */
	@JsonProperty("101")
	public void set101(String hvacStatusCntrl) {
		this.hvacStatusCntrl = hvacStatusCntrl;
	}

	/**
	 * @return the hvacModeContrl
	 */
	@JsonProperty("hvacModeContrl")
	public String getHvacModeContrl() {
		this.hvacModeContrl=this.hvacStatusCntrl;
		return LennoxMapper.getApplicationStatusContrl(hvacModeContrl);
	}
	

	/**
	 * @return the fanMode
	 */
	@JsonProperty("fanMode")
	public String getFanMode() {
		return LennoxMapper.getSupplyFanStatus(hvacStatusCntrl);
	}

	/**
	 * @param fanMode the fanMode to set
	 */
	//@JsonProperty("")
	public void setFanMode(String fanMode) {
		this.fanMode = fanMode;
	}

	/**
	 * @return the heatSetPoint
	 */
	@JsonProperty("heatSetPoint")
	public String getHeatSetPoint() {
		return LennoxMapper.getSetPoint(scheduledAsOccupied, heatSetPoint, heatUnoccupiedSetPoint);
	}

	/**
	 * @param heatSetPoint the heatSetPoint to set
	 */
	@JsonProperty("130")
	public void set130(String heatSetPoint) {
		this.heatSetPoint = heatSetPoint;
	}
	
	/**
	 * @return the coolSetPoint
	 */
	@JsonProperty("coolSetPoint")
	public String getCoolSetPoint() {
		return LennoxMapper.getSetPoint(scheduledAsOccupied, coolSetPoint, coolUnoccupiedSetPoint);
	}

	/**
	 * @param coolSetPoint the coolSetPoint to set
	 */
	@JsonProperty("131")
	public void set131(String coolSetPoint) {
		this.coolSetPoint = coolSetPoint;
	}
	
	/**
	 * @param heatUnoccupiedSetPoint the heatUnoccupiedSetPoint to set
	 */
	@JsonProperty("132")
	public void set132(String heatUnoccupiedSetPoint) {
		this.heatUnoccupiedSetPoint = heatUnoccupiedSetPoint;
	}	

	/**
	 * @param coolUnoccupiedSetPoint the coolUnoccupiedSetPoint to set
	 */
	@JsonProperty("133")
	public void set133(String coolUnoccupiedSetPoint) {
		this.coolUnoccupiedSetPoint = coolUnoccupiedSetPoint;
	}
	
	/**
	 * @return the overrideDegMin
	 */
	@JsonProperty("overrideDegMin")
	public String getOverrideDegMin() {
		return LennoxMapper.getTemp(overrideDegMin);
	}

	/**
	 * @param overrideDegMin the overrideDegMin to set
	 */
	@JsonProperty("110")
	public void set110(String overrideDegMin) {
		this.overrideDegMin = overrideDegMin;
	}

	/**
	 * @return the scheduledSetPoint
	 */
	@JsonProperty("scheduledSetPoint")
	public String getScheduledSetPoint() {
		return LennoxMapper.getTemp(scheduledSetPoint);
	}

	/**
	 * @param scheduledSetPoint the scheduledSetPoint to set
	 */
	@JsonProperty("109")
	public void set109(String scheduledSetPoint) {
		this.scheduledSetPoint = scheduledSetPoint;
	}

	/**
	 * @return the scheduledAsOccupied
	 */
	@JsonProperty("scheduledAsOccupied")
	public String getScheduledAsOccupied() {
		return LennoxMapper.getScheduledAsOccupied(scheduledAsOccupied);
	}

	/**
	 * @param scheduledAsOccupied the scheduledAsOccupied to set
	 */
	@JsonProperty("104")
	public void set104(String scheduledAsOccupied) {
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
		return LennoxMapper.getEconomizerEnable(economizerEnabled);
	}

	/**
	 * @param economizerEnabled the economizerEnabled to set
	 */
	@JsonProperty("248")
	public void set248(String economizerEnabled) {
		this.economizerEnabled = economizerEnabled;
	}

	/**
	 * @return the economizerActive
	 */
	@JsonProperty("economizerActive")
	public String getEconomizerActive() {
		return LennoxMapper.getEconomizerActive(economizerActive);
	}

	/**
	 * @param economizerActive the economizerActive to set
	 */
	@JsonProperty("129")
	public void set129(String economizerActive) {
		this.economizerActive = economizerActive;
	}

	/**
	 * @return the minimumDamperPositionSetPoint
	 */
	@JsonProperty("minimumDamperPositionSetPoint")
	public String getMinimumDamperPositionSetPoint() {
		return LennoxMapper.getDamperPosition(minimumDamperPositionSetPoint);
	}

	/**
	 * @param minimumDamperPositionSetPoint the minimumDamperPositionSetPoint to set
	 */
	@JsonProperty("102")
	public void set102(String minimumDamperPositionSetPoint) {
		this.minimumDamperPositionSetPoint = minimumDamperPositionSetPoint;
	}

	/**
	 * @return the minDamperPosition
	 */
	@JsonProperty("minDamperPosition")
	public String getMinDamperPosition() {
		return LennoxMapper.getDamperPosition(minDamperPosition);
	}

	/**
	 * @param minDamperPosition the minDamperPosition to set
	 */
	@JsonProperty("244")
	public void set244(String minDamperPosition) {
		this.minDamperPosition = minDamperPosition;
	}

	/**
	 * @return the mixedAirTemp
	 */
	@JsonProperty("mixedAirTemp")
	public String getMixedAirTemp() {
		return LennoxMapper.getTemp("");
	}

	/**
	 * @param mixedAirTemp the mixedAirTemp to set
	 */
	//@JsonProperty("240")
	public void setMixedAirTemp(String mixedAirTemp) {
		this.mixedAirTemp = mixedAirTemp;
	}

	/**
	 * @return the outdoorTemperature
	 */
	@JsonProperty("outdoorTemperature")
	public String getOutdoorTemperature() {
		return LennoxMapper.getTemp(supplyAirTemp);
	}

	/**
	 * @param outdoorTemperature the outdoorTemperature to set
	 */
	//@JsonProperty("242")
	public void setOutdoorTemperature(String outdoorTemperature) {
		this.outdoorTemperature = outdoorTemperature;
	}

	/**
	 * @return the outdoorHumidity
	 */
	@JsonProperty("outdoorHumidity")
	public String getOutdoorHumidity() {
		return outdoorHumidity;
	}

	/**
	 * @param outdoorHumidity the outdoorHumidity to set
	 */
	//@JsonProperty("")
	public void setOutdoorHumidity(String outdoorHumidity) {
		this.outdoorHumidity = outdoorHumidity;
	}

	/**
	 * @return the highPressureCutOffCompressorOne
	 */
	@JsonProperty("highPressureCutOffCompressorOne")
	public String getHighPressureCutOffCompressorOne() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_1_HIGH_PRESS_S4));
	}

	/**
	 * @param highPressureCutOffCompressorOne the highPressureCutOffCompressorOne to set
	 */
	public void setHighPressureCutOffCompressorOne(
			String highPressureCutOffCompressorOne) {
		this.highPressureCutOffCompressorOne = highPressureCutOffCompressorOne;
	}

	/**
	 * @return the lowPressureCutOffCompressorOne
	 */
	@JsonProperty("lowPressureCutOffCompressorOne")
	public String getLowPressureCutOffCompressorOne() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_1_LOW_PRESS_S87));
	}

	/**
	 * @param lowPressureCutOffCompressorOne the lowPressureCutOffCompressorOne to set
	 */
	public void setLowPressureCutOffCompressorOne(
			String lowPressureCutOffCompressorOne) {
		this.lowPressureCutOffCompressorOne = lowPressureCutOffCompressorOne;
	}

	/**
	 * @return the highPressureCutOffCompressorTwo
	 */
	@JsonProperty("highPressureCutOffCompressorTwo")
	public String getHighPressureCutOffCompressorTwo() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_2_HIGH_PRESS_S7));
	}

	/**
	 * @param highPressureCutOffCompressorTwo the highPressureCutOffCompressorTwo to set
	 */
	public void setHighPressureCutOffCompressorTwo(
			String highPressureCutOffCompressorTwo) {
		this.highPressureCutOffCompressorTwo = highPressureCutOffCompressorTwo;
	}

	/**
	 * @return the lowPressureCutOffCompressorTwo
	 */
	@JsonProperty("lowPressureCutOffCompressorTwo")
	public String getLowPressureCutOffCompressorTwo() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_2_LOW_PRESS_S88));
	}

	/**
	 * @param lowPressureCutOffCompressorTwo the lowPressureCutOffCompressorTwo to set
	 */
	public void setLowPressureCutOffCompressorTwo(
			String lowPressureCutOffCompressorTwo) {
		this.lowPressureCutOffCompressorTwo = lowPressureCutOffCompressorTwo;
	}

	
	/**
	 * @return the highPressureCutOffCompressorThree
	 */
	@JsonProperty("highPressureCutOffCompressorThree")
	public String getHighPressureCutOffCompressorThree() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_3_HIGH_PRESS_S28));
	}

	/**
	 * @param highPressureCutOffCompressorThree the highPressureCutOffCompressorThree to set
	 */
	public void setHighPressureCutOffCompressorThree(
			String highPressureCutOffCompressorThree) {
		this.highPressureCutOffCompressorThree = highPressureCutOffCompressorThree;
	}

	/**
	 * @return the lowPressureCutOffCompressorOne
	 */
	@JsonProperty("lowPressureCutOffCompressorThree")
	public String getLowPressureCutOffCompressorThree() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_3_LOW_PRESS_S98));
	}

	/**
	 * @param lowPressureCutOffCompressorThree the lowPressureCutOffCompressorThree to set
	 */
	public void setLowPressureCutOffCompressorThree(
			String lowPressureCutOffCompressorThree) {
		this.lowPressureCutOffCompressorThree = lowPressureCutOffCompressorThree;
	}

	/**
	 * @return the highPressureCutOffCompressorFour
	 */
	@JsonProperty("highPressureCutOffCompressorFour")
	public String getHighPressureCutOffCompressorFour() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_4_HIGH_PRESS_S96));
	}

	/**
	 * @param highPressureCutOffCompressorFour the highPressureCutOffCompressorFour to set
	 */
	public void setHighPressureCutOffCompressorFour(
			String highPressureCutOffCompressorFour) {
		this.highPressureCutOffCompressorFour = highPressureCutOffCompressorFour;
	}

	/**
	 * @return the lowPressureCutOffCompressorFour
	 */
	@JsonProperty("lowPressureCutOffCompressorFour")
	public String getLowPressureCutOffCompressorFour() {
		return (LennoxMapper.decipherErrorCode(getCurrentError(),LennoxAlarmCode.COMP_4_LOW_PRESS_S97));
	}

	/**
	 * @param lowPressureCutOffCompressorTwo the lowPressureCutOffCompressorTwo to set
	 */
	public void setLowPressureCutOffCompressorFour(
			String lowPressureCutOffCompressorFour) {
		this.lowPressureCutOffCompressorFour = lowPressureCutOffCompressorFour;
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
	 * @return the primaryHeatControl
	 */
	@JsonProperty("primaryHeatControl")
	public String getPrimaryHeatControl() {
		return primaryHeatControl;
	}

	/**
	 * @param primaryHeatControl the primaryHeatControl to set
	 */
	@JsonProperty("117")
	public void set117(String primaryHeatControl) {
		this.primaryHeatControl = primaryHeatControl;
	}

	

	/**
	 * @return the compressorEnableControl
	 */
	@JsonProperty("compressorEnableControl")
	public String getCompressorEnableControl() {
		return compressorEnableControl;
	}

	/**
	 * @param compressorEnableControl the compressorEnableControl to set
	 */
	@JsonProperty("115")
	public void set115(String compressorEnableControl) {
		this.compressorEnableControl = compressorEnableControl;
	}


	/**
	 * @return the spaceTempInput
	 */
	@JsonProperty("spaceTempInput")
	public String getSpaceTempInput() {
		return spaceTempInput;
	}

	/**
	 * @param spaceTempInput the spaceTempInput to set
	 */
	@JsonProperty("113")
	public void set113(String spaceTempInput) {
		this.spaceTempInput = spaceTempInput;
	}

	/**
	 * @return the exhaustFanStatus
	 */
	@JsonProperty("exhaustFanStatus")
	public String getExhaustFanStatus() {
		return exhaustFanStatus;
	}

	/**
	 * @param exhaustFanStatus the exhaustFanStatus to set
	 */
	@JsonProperty("285")
	public void set285(String exhaustFanStatus) {
		this.exhaustFanStatus = exhaustFanStatus;
	}

	/**
	 * @return the ductStaticPressure
	 */
	@JsonProperty("ductStaticPressure")
	public String getDuctStaticPressure() {
		return ductStaticPressure;
	}

	/**
	 * @param ductStaticPressure the ductStaticPressure to set
	 */
	@JsonProperty("283")
	public void set283(String ductStaticPressure) {
		this.ductStaticPressure = ductStaticPressure;
	}

	/**
	 * @return the buildingStaticPressure
	 */
	@JsonProperty("buildingStaticPressure")
	public String getBuildingStaticPressure() {
		return buildingStaticPressure;
	}

	/**
	 * @param buildingStaticPressure the buildingStaticPressure to set
	 */
	@JsonProperty("282")
	public void set282(String buildingStaticPressure) {
		this.buildingStaticPressure = buildingStaticPressure;
	}

	/**
	 * @return the auxHeatControl
	 */
	@JsonProperty("auxHeatControl")
	public String getAuxHeatControl() {
		return auxHeatControl;
	}

	/**
	 * @param auxHeatControl the auxHeatControl to set
	 */
	@JsonProperty("119")
	public void set119(String auxHeatControl) {
		this.auxHeatControl = auxHeatControl;
	}

	/**
	 * @return the dehumidificationSP
	 */
	@JsonProperty("dehumidificationSP")
	public String getDehumidificationSP() {
		return dehumidificationSP;
	}

	/**
	 * @param dehumidificationSP the dehumidificationSP to set
	 */
	@JsonProperty("108")
	public void set108(String dehumidificationSP) {
		this.dehumidificationSP = dehumidificationSP;
	}

	/**
	 * @return the heatPrimary
	 */
	@JsonProperty("heatPrimary")
	public String getHeatPrimary() {
		return heatPrimary;
	}

	/**
	 * @param heatPrimary the heatPrimary to set
	 */
	@JsonProperty("245")
	public void set245(String heatPrimary) {
		this.heatPrimary = heatPrimary;
	}

	/**
	 * @return the localSpaceTemp
	 */
	@JsonProperty("localSpaceTemp")
	public String getLocalSpaceTemp() {
		return localSpaceTemp;
	}

	/**
	 * @param localSpaceTemp the localSpaceTemp to set
	 */
	@JsonProperty("243")
	public void set243(String localSpaceTemp) {
		this.localSpaceTemp = localSpaceTemp;
	}


	/**
	 * @return the occupancyOvrdControl
	 */
	@JsonProperty("occupancyOvrdControl")
	public String getOccupancyOvrdControl() {
		return occupancyOvrdControl;
	}

	/**
	 * @param occupancyOvrdControl the occupancyOvrdControl to set
	 */
	@JsonProperty("103")
	public void set103(String occupancyOvrdControl) {
		this.occupancyOvrdControl = occupancyOvrdControl;
	}

	/**
	 * @return the coolPrimary
	 */
	@JsonProperty("coolPrimary")
	public String getCoolPrimary() {
		return coolPrimary;
	}

	/**
	 * @param coolPrimary the coolPrimary to set
	 */
	@JsonProperty("247")
	public void set247(String coolPrimary) {
		this.coolPrimary = coolPrimary;
	}

	/**
	 * @return the heatSecondary
	 */
	@JsonProperty("heatSecondary")
	public String getHeatSecondary() {
		return heatSecondary;
	}

	/**
	 * @param heatSecondary the heatSecondary to set
	 */
	@JsonProperty("246")
	public void set246(String heatSecondary) {
		this.heatSecondary = heatSecondary;
	}

	/**
	 * @return the dischargeAirCoolSP
	 */
	@JsonProperty("dischargeAirCoolSP")
	public String getDischargeAirCoolSP() {
		return dischargeAirCoolSP;
	}

	/**
	 * @param dischargeAirCoolSP the dischargeAirCoolSP to set
	 */
	@JsonProperty("125")
	public void set125(String dischargeAirCoolSP) {
		this.dischargeAirCoolSP = dischargeAirCoolSP;
	}

	/**
	 * @return the ductStaticSP
	 */
	@JsonProperty("ductStaticSP")
	public String getDuctStaticSP() {
		return ductStaticSP;
	}

	/**
	 * @param ductStaticSP the ductStaticSP to set
	 */
	@JsonProperty("123")
	public void set123(String ductStaticSP) {
		this.ductStaticSP = ductStaticSP;
	}

	/**
	 * @return the buildingStaticSP
	 */
	@JsonProperty("buildingStaticSP")
	public String getBuildingStaticSP() {
		return buildingStaticSP;
	}

	/**
	 * @param buildingStaticSP the buildingStaticSP to set
	 */
	@JsonProperty("124")
	public void set124(String buildingStaticSP) {
		this.buildingStaticSP = buildingStaticSP;
	}

	/**
	 * @return the effSpaceHumidity
	 */
	@JsonProperty("effSpaceHumidity")
	public String getEffSpaceHumidity() {
		return effSpaceHumidity;
	}

	/**
	 * @param effSpaceHumidity the effSpaceHumidity to set
	 */
	@JsonProperty("276")
	public void set276(String effSpaceHumidity) {
		this.effSpaceHumidity = effSpaceHumidity;
	}

	/**
	 * @return the effDehumidSP
	 */
	@JsonProperty("effDehumidSP")
	public String getEffDehumidSP() {
		return effDehumidSP;
	}

	/**
	 * @param effDehumidSP the effDehumidSP to set
	 */
	@JsonProperty("278")
	public void set278(String effDehumidSP) {
		this.effDehumidSP = effDehumidSP;
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
	 * @return the dehumidStatus
	 */
	@JsonProperty("dehumidStatus")
	public String getDehumidStatus() {
		return dehumidStatus;
	}

	/**
	 * @param dehumidStatus the dehumidStatus to set
	 */
	@JsonProperty("279")
	public void set279(String dehumidStatus) {
		this.dehumidStatus = dehumidStatus;
	}

	/**
	 * @return the unitID
	 */
	@JsonProperty("unitID")
	public String getUnitID() {
		return unitID;
	}

	/**
	 * @param unitID the unitID to set
	 */
	@JsonProperty("231")
	public void set231(String unitID) {
		this.unitID = unitID;
	}

	/**
	 * @return the errorCodes
	 */
	@JsonProperty("errorCodes")
	public String getErrorCodes() {
		return errorCodes;
	}

	/**
	 * @param errorCodes the errorCodes to set
	 */
	@JsonProperty("254")
	public void set254(String errorCodes) {
		this.errorCodes = errorCodes;
	}

	/**
	 * @return the currentError
	 */
	@JsonProperty("currentError")
	public String getCurrentError() {
		return currentError;
	}

	/**
	 * @param currentError the currentError to set
	 */
	@JsonProperty("253")
	public void set253(String currentError) {
		this.currentError = currentError;
	}

	/**
	 * @return the effSpaceCO2
	 */
	@JsonProperty("effSpaceCO2")
	public String getEffSpaceCO2() {
		return effSpaceCO2;
	}

	/**
	 * @param effSpaceCO2 the effSpaceCO2 to set
	 */
	@JsonProperty("274")
	public void set274(String effSpaceCO2) {
		this.effSpaceCO2 = effSpaceCO2;
	}	
	
	/**
	 * @return the occupancyScheduleControl
	 */
	@JsonProperty("occupancyScheduleControl")
	public String getOccupancyScheduleControl() {
		return occupancyScheduleControl;
	}

	/**
	 * @param occupancyScheduleControl the occupancyScheduleControl to set
	 */
	@JsonProperty("107")
	public void set107(String occupancyScheduleControl) {
		this.occupancyScheduleControl = occupancyScheduleControl;
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

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getUnitStopSource() {
		return unitStopSource;
	}

	public void setUnitStopSource(String unitStopSource) {
		this.unitStopSource = unitStopSource;
	}

	/**
	 * @return the smokeDetectors
	 */
	public String getSmokeDetectors() {
		return LennoxMapper.getSmokeDetectorsValue(overrideInProgress);
	}

	/**
	 * @param smokeDetectors the smokeDetectors to set
	 */
	public void setSmokeDetectors(String smokeDetectors) {
		this.smokeDetectors = smokeDetectors;
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

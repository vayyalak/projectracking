package com.gridpoint.energy.domainmodel.hvac.datavisualization;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public final class LennoxMapper {

	private static Map<String, String> hvacStatus=new HashMap<String, String>();
	private static Map<String, String> applicationModeContrl=new HashMap<String, String>();
	private static String NA="N/A";	
	private static String ON="ON";
	private static String OFF="OFF";
	
	private static String YES="YES";
	private static String NO="NO";
	
	private static String ACTIVE="ACTIVE";
	
	private static String degF="&#xB0;F";
	
	static{		
		
		//HVAC Status
		
		hvacStatus.put("0", "OFF");
		hvacStatus.put("1", "HEAT");
		hvacStatus.put("2", "MORNING WARMUP");
		hvacStatus.put("3", "COOL");
		hvacStatus.put("5", "PRE-COOL");
		hvacStatus.put("6", "OFF");
		hvacStatus.put("7", "TEST");
		hvacStatus.put("8", "EMERGENCY HEAT");
		hvacStatus.put("9", "FAN ONLY");
		hvacStatus.put("12", "MAX HEAT");
		hvacStatus.put("14", "DEHUMIDIFICATION");
		hvacStatus.put("129", "FRESH AIR HEATING");
		hvacStatus.put("131", "FRESH AIR COOLING");
		hvacStatus.put("145", "DEFROST COMPRESSOR 1");
		hvacStatus.put("161", "DEFROST COMPRESSOR 2");
		hvacStatus.put("177", "DEFROST COMPRESSOR 1 & 2");
		
		
		applicationModeContrl.put("0", "AUTO");
		applicationModeContrl.put("1", "HEAT");
		applicationModeContrl.put("3", "COOL");
		applicationModeContrl.put("6", "OFF");
		applicationModeContrl.put("9", "FAN ONLY");
		applicationModeContrl.put("255", "NUL");
		applicationModeContrl.put("208", "FAN AUTO");
		applicationModeContrl.put("209", "FAN ON");
		applicationModeContrl.put("216", "EXHAUST AUTO");
		applicationModeContrl.put("217", "EXHAUST1 ON");
		applicationModeContrl.put("218", "EXHAUST1 OFF");
		applicationModeContrl.put("219", "EXHAUST2 ON");
		applicationModeContrl.put("220", "EXHAUST2 OFF");
		applicationModeContrl.put("221", "EXHAUST ON");
		applicationModeContrl.put("222", "EXHAUST OFF");
		applicationModeContrl.put("254", "RESET");
		applicationModeContrl.put("224", "IDLE");
		applicationModeContrl.put("228", "COOL1");
		applicationModeContrl.put("232", "COOL2");
		applicationModeContrl.put("236", "COOL3");
		applicationModeContrl.put("225", "HEAT1");
		applicationModeContrl.put("226", "HEAT2");
		applicationModeContrl.put("227", "HEAT3");
		applicationModeContrl.put("229", "REHEAT LO");
		applicationModeContrl.put("230", "REHEAT HI");
	}
	
	public static String getHvacStatus(String input){
		if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(hvacStatus.get(input))){
			return hvacStatus.get(input);			
		}else{
			return NA;
		}
	}
	
	public static String getHvacMode(String input){
		if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(hvacStatus.get(input))){
			return hvacStatus.get(input);
		}else{
			return NA;
		}		
	}
	
	public static String getFanStatus(String input){		
		if(!StringUtils.isEmpty(input)){
			return input+"%";			
		}else{
			return NA;
		}		
	}
	
	/**
	 * This method return only YES/NO
	 * @param input
	 * @return
	 */
	public static String getOverrideInProgress(String input){
		if(!StringUtils.isEmpty(input)){
			int emgOvrdCntrl=Integer.parseInt(input);
			if(emgOvrdCntrl==0 || emgOvrdCntrl>7){
				return NO;
			}else{
				return YES;
			}			
		}else{
			return NA;
		}		
	}
	
	public static String getTemp(String input){
		if(!StringUtils.isEmpty(input)){
			double temp=Double.parseDouble(input);
			return temp+" "+degF;
		}else{
			return NA;
		}		
	}
	
	public static String getRTUOccupiedStatus(String input){
		if(!StringUtils.isEmpty(input)){
			if(input.equals("1")){
				return NO;
			}else if(input.equals("0") || input.equals("2")){
				return YES;
			}else{
				return NA;
			}
		}else{
			return NA;
		}	
	}
	
	public static String getZoneHumidity(String input){		
		if(!StringUtils.isEmpty(input)){
			int zoneHumidity=Integer.parseInt(input);
			if(zoneHumidity==0){
				return "NO SENSOR"; 
			}else if(zoneHumidity==100){
				return "SENSOR ERROR";
			}else if(zoneHumidity>=1 && zoneHumidity<=99){
				return zoneHumidity+"%";
			}else{
				return NA;
			}
		}else{
			return NA;
		}		
	}
	
	public static String getZoneCO2(String input){		
		if(!StringUtils.isEmpty(input)){
			int zoneCo2=Integer.parseInt(input);
			if(zoneCo2>=0 && zoneCo2<=6){
				return "NO SENSOR"; 
			}else if(zoneCo2>=1993 && zoneCo2<=2000){
				return "SENSOR ERROR";
			}else if(zoneCo2>=7 && zoneCo2<=1992){
				return zoneCo2+" Parts-per-million";
			}else{
				return NA;
			}
		}else{
			return NA;
		}		
	}
	
	public static String getApplicationContrl(String input){		
		if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(applicationModeContrl.get(input))){
			if(input.equals("1") || input.equals("3")){
				return applicationModeContrl.get(input);
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}
	
	
	public static String getApplicationStatusContrl(String input){		
		if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(applicationModeContrl.get(input))){
			return applicationModeContrl.get(input);
		}else{
			return NA;
		}
	}
	
	public static String getSupplyFanStatus(String input){		
		if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(applicationModeContrl.get(input))){
			if(input.equals("9") || input.equals("208") || input.equals("209")){
				return applicationModeContrl.get(input);
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}
	
	public static String getScheduledAsOccupied(String input){
		if(!StringUtils.isEmpty(input)){
			int occupancy=Integer.parseInt(input);
			if(occupancy==0){
				return YES;
			}else if(occupancy>=1){
				return NO;
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}
	public static String getSetPoint(String occupancySetPoint, String setpoint, String unoccupiedSetPoint){
		if(!StringUtils.isEmpty(occupancySetPoint)){
			if(getScheduledAsOccupied(occupancySetPoint).equals(YES)){
				return getTemp(setpoint);
			}else if(getScheduledAsOccupied(occupancySetPoint).equals(NO)){
				return getTemp(unoccupiedSetPoint);
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}	
	
	
	public static String getEconomizerEnable(String input){
		if(!StringUtils.isEmpty(input)){
			if(input.equals("0")){
				return NO;
			}else if(input.equals("1")){
				return YES;
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}	
	
	public static String getEconomizerActive(String input){		
		if(!StringUtils.isEmpty(input)){
			int ecoActive=Integer.parseInt(input);
			if(ecoActive==0){
				return NO;
			}else if(ecoActive==1){
				return YES;
			}else if(ecoActive>1){
				return "AUTO";
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}
	
	public static String getDamperPosition(String input){		
		if(!StringUtils.isEmpty(input)){
			int ecoActive=Integer.parseInt(input);
			if(ecoActive>=0 && ecoActive<=100){
				return ecoActive+"%";
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}
	
	public static String getSmokeDetectorsValue(String input){
		if(!StringUtils.isEmpty(input)){
			int emgOvrdCntrl=Integer.parseInt(input);
			if(emgOvrdCntrl==5){
				return YES;
			}else{
				return NO;
			}			
		}else{
			return NA;
		}		
	}
	public static String decipherErrorCode(String currErr,int index){
		
		String alarmState=NA;
		
		try{
			if( Integer.parseInt(currErr)==index)
				alarmState=ACTIVE;
		}
		catch(Exception e)
		{
			alarmState=NA;
		}
		return alarmState;
	}
}

package com.gridpoint.energy.domainmodel.hvac.datavisualization;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public final class TraneMapper {

	private static Map<String, String> hvacStatus=new HashMap<String, String>();
	private static String NA="N/A";	
	private static String ON="ON";
	private static String OFF="OFF";
	
	private static String YES="YES";
	private static String NO="NO";
	private static String ACTIVE="ACTIVE";
	private static String INACTIVE="INACTIVE";
	
	private static String degF="&#xB0;F";
	
	static{		
		
		//HVAC Status
		
		hvacStatus.put("1", "AUTO");
		hvacStatus.put("2", "HEAT");
		hvacStatus.put("3", "MORNING WARMUP");
		hvacStatus.put("4", "COOL");
		hvacStatus.put("5", "NIGHT PURGE");
		hvacStatus.put("6", "PRE COOL");
		hvacStatus.put("7", "OFF");
		hvacStatus.put("8", "TEST");
		hvacStatus.put("9", "EMERGENCY HEAT");
		hvacStatus.put("10", "FAN ONLY");
		hvacStatus.put("11", "FREE COOL");
		hvacStatus.put("12", "ICE-MAKING");
		hvacStatus.put("13", "MAX HEAT");
		hvacStatus.put("14", "ECONOMY MODE");
		hvacStatus.put("15", "DEHUMIDIFYING");
		hvacStatus.put("16", "CALIBRATE");
		
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
			int fanStatus=Integer.parseInt(input);
			if(fanStatus>0){
				return ON; 
			}else{
				return OFF;
			}
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
			if(input.equals("2")){
				return NO;
			}else if(input.equals("1") || input.equals("3") || input.equals("4")){
				return YES;
			}else{
				return NA;
			}
		}else{
			return NA;
		}	
	}
		
	
	public static String getZoneCO2(String input){		
		if(!StringUtils.isEmpty(input)){
			return input+" Parts-per-million";
		}else{
			return NA;
		}		
	}
	
	public static String getApplicationContrl(String input){		
		if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(hvacStatus.get(input))){
			return hvacStatus.get(input);
		}else{
			return NA;
		}
	}
	
	
	public static String getApplicationStatusContrl(String input){		
		if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(hvacStatus.get(input))){
			return hvacStatus.get(input);
		}else{
			return NA;
		}
	}
	
	public static String getSupplyFanStatus(String input){		
		if(!StringUtils.isEmpty(input)){
			if(input.equals("0")){
				return OFF;
			}else if(input.equals("1")){
				return ON;
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
	
	public static String getEconomizerEnable(String input){
		if(!StringUtils.isEmpty(input)){
			if(input.equals("1")){
				return NO;
			}else if(input.equals("2")){
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
			if(input.equals("1")){
				return NO;
			}else if(input.equals("2")){
				return YES;
			}else if(input.equals("3")){
				return "AUTO";
			}else{
				return NA;
			}
		}else{
			return NA;
		}
	}
	
	public static String getPresentageValue(String input){		
		if(!StringUtils.isEmpty(input)){
			return input+"%";
		}else{
			return NA;
		}		
	}
	
	public static String getOutdoorHumidity(String input){		
		if(!StringUtils.isEmpty(input)){
			long oH=Long.valueOf(input);
			if(oH>=0 && oH<=100){
				return input+"% RH";
			}
			return NA;
		}else{
			return NA;
		}		
	}
	
	public static String getSmokeDetectorsValue(String input){		
		if(!StringUtils.isEmpty(input)){
			if(input.equals("0")){
				return NO;
			}else{
				return YES;
			}			
		}else{
			return NA;
		}		
	}
	
	public static String getUnitStopSource(String input){		
		if(!StringUtils.isEmpty(input)){
			if(input.equals("1")){
				return "NONE";
			}else if(input.equals("2")){
				return "Emergency Stop";
			}if(input.equals("3")){
				return "External Auto/Stop";
			}if(input.equals("4")){
				return "Local HI";
			}if(input.equals("5")){
				return "Remote HI";
			}else{
				return NA;
			}
		}else{
			return NA;
		}		
	}
	
	public static String decipherAlarmCode(String alarmCode,int bitIndex){
		if(alarmCode!=null && alarmCode.length()!=0){
		//make sure alarm code has 12 digits.
		 while(alarmCode.length() < 12)
			 alarmCode = "0" + alarmCode;
			
		 StringBuffer wholeStr=new StringBuffer();
			
			for(int i=0;i<alarmCode.length();i++)
				wholeStr.append(hexToBinary(alarmCode.charAt(i)));
			return ( mapBitValues(wholeStr.reverse().toString(),bitIndex));
		}
		else
			return NA;
	}
	private static String hexToBinary(Character hex){
		try{
	    String binFragment = "";
	    binFragment = Integer.toBinaryString(Integer.parseInt(""+hex,16));
	        while(binFragment.length() < 4){
	            binFragment = "0" + binFragment;
	        }
	    return binFragment;
		}
		catch(Exception e){
			return "0000";
		}
	}
	private static String mapBitValues(String hexStr,int bitIndex) {
		
		//As of now we are interested in low and high compressor 1&2 alarms.
		if(hexStr.charAt(bitIndex)=='1')
			return ACTIVE;
		else if(hexStr.charAt(bitIndex)=='1')
			return ACTIVE;
		else if(hexStr.charAt(bitIndex)=='1')
			return ACTIVE;
		else if(hexStr.charAt(bitIndex)=='1')
			return ACTIVE;
		
		else return INACTIVE;
    }
}

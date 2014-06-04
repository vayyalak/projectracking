package com.gridpoint.energy.domainmodel.hvac.datavisualization;

public interface TraneAlarmCode {
	
	public static final int ZONE_TEMP_SENSOR_FAILURE = 0;
	public static final int SUPPLY_AIR_TEMP_SENSOR_FAIL=1;
	public static final int OUTDOOR_AIR_TEMPERATURE_SSENSOR_FAIL=2;
	public static final int	LOCAL_COOL_SETPOINT_FAIL=3;
	public static final int LOCAL_ZONE_HEAT_SETPOINT_FAIL=4;
	public static final int SA_PRESSURE_SENSOR_FAIL=5;
	public static final int OUTDOOR_HUMIDITY_SENSOR_FAIL=6;
	public static final int LOCAL_EMERGENCY_STOP_INITIATED=7;
	public static final int FAN_FAILURE=8;
	public static final int EXHAUST_FAN_PROVING_FAILURE=9;
	public static final int COMPRESSOR_1_LPC_LOCKOUT=10;
	public static final int COMPRESSOR_2_LPC_LOCKOUT=11;
	public static final int COIL_TEMP_SENSOR_1_FAIL=12;
	public static final int COIL_TEMP_SENSOR_2_FAIL=13;
	public static final int COMPRESSOR_1_HPC_LOCKOUT=14;
	public static final int COMPRESSOR_2_HPC_LOCKOUT=15;
	public static final int HEAT_FAILURE=16;
	public static final int SA_PRESUURE_SETPOINT_FAILURE=17;
	public static final int SPACE_PRESSURE_SETPOINT_FAIL=18;
	public static final int SPACE_PRESSURE_SENSOR_FAIL=19;
	public static final int RETURN_AIR_TEMP_SENSOR_FAIL=20;
	public static final int RETURN_AIR_HUMIDITY_SENSOR_FAIL=21;
	public static final int AUTO_SA_HIGH_PRESS_LIMIT=22;
	public static final int SA_TEMP_COOL_SETPOINT_FAIL=23;
	public static final int SA_TEMP_HEAT_SETPOINT_FAIL=24;
	public static final int DIRTY_FILTER=25;
	public static final int CO2_SENSOR_FAILURE=26;
	public static final int VELOCITY_PRESSURE_SENSOR_FAIL=27;
	public static final int MIXED_AIR_TEMP_SENSOR_FAILURE=28;
	public static final int SPACE_HUMIDITY_SENSOR_FAILURE=29;
	public static final int ENTERING_EVAP_TEMP_SENSOR_FAIL=30;
	public static final int SA_REHEAT_SETPOINT_FAILURE=31;
	public static final int DEHUMID_SETPOINT_FAILURE=32;
	public static final int MAINTENANCE_REQUIRED=33;
	public static final int UNIT_COMMUNICATIONS_FAILURE=34;
	public static final int EXTERNAL_AUTO_STOP=35;
	public static final int MORNING_WARMUP_SETPOIT_FAIL=36;
	public static final int MIN_OA_FLOW_SETPOINT_FAIL=37;
	public static final int COMP_1_DISABLE_INPUT_LPC=38;
	public static final int COMP_2_DISABLE_INPUT_LPC=39;
	public static final int SMOKE_DETECTOR=40;
	public static final int HEATING_HIGH_TEMP_LIMIT_OPEN=41;
	public static final int NO_FLAME_SENSED_ON_HEAT_CALL=42;
	public static final int FLAME_SENSED_WITH_GAS_VALVE_OFF=43;
	public static final int GAS_HEAT_MODULE_FAILURE=44;
	public static final int ECONOMIZER_ACTUATOR_FAULT=45;
	public static final int COMP_1_DISABLE_INPUT_HPC=46;
	public static final int COMP_2_DISABLE_INPUT_HPC=47;
	
	
}

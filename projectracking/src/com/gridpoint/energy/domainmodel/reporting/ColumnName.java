package com.gridpoint.energy.domainmodel.reporting;

/**
 * Enumerates the fields of tabular reports
 */
public class ColumnName {

    //
    // Fields for the billing comparison report
    //

    /**
     * number of fields in the billing comparison report
     */
    public static final int BILLING_COMPARISON_COUNT = 20;

    /**
     * see com.gridpoint.energy.datamodel.Premises#name
     */
    public static final String BILLING_COMPARISON_PREMISES_NAME = "premisesName";
    /**
     * see PremisesEntity#description
     */
    public static final String BILLING_COMPARISON_PREMISES_DESCRIPTION = "premisesDescription";
    /**
     * see PremisesEntity#Address
     */
    public static final String BILLING_COMPARISON_PREMISES_ADDRESS = "premisesAddress";
    /**
     * see PremisesEntity#city
     */
    public static final String BILLING_COMPARISON_PREMISES_CITY = "premisesCity";
    /**
     * see PremisesEntity#state
     */
    public static final String BILLING_COMPARISON_PREMISES_STATE = "premisesState";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#billCount
     */
    public static final String BILLING_COMPARISON_BILL_COUNT = "billCount";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#start
     */
    public static final String BILLING_COMPARISON_START = "start";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#end
     */
    public static final String BILLING_COMPARISON_END = "end";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#lastBilledDate
     */
    public static final String BILLING_COMPARISON_LAST_BILLED_DATE = "lastBilledDate";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#billedCost
     */
    public static final String BILLING_COMPARISON_BILLED_COST = "billedCost";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#billedUsage
     */
    public static final String BILLING_COMPARISON_BILLED_USAGE = "billedUsage";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#billingDaysMissing
     */
    public static final String BILLING_COMPARISON_BILLING_DAYS_MISSING = "billingDaysMissing";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#measuredUsage
     */
    public static final String BILLING_COMPARISON_MEASURED_USAGE = "measuredUsage";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#missingIntervals
     */
    public static final String BILLING_COMPARISON_MISSING_INTERVALS = "missingIntervals	";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#avgUsageDelta
     */
    public static final String BILLING_COMPARISON_AVERAGE_USAGE_DELTA = "avgUsageDelta";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#lastUsageDelta
     */
    public static final String BILLING_COMPARISON_LAST_USAGE_DELTA = "lastUsageDelta";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#avgBilledPower
     */
    public static final String BILLING_COMPARISON_AVERAGE_BILLED_POWER = "avgBilledPower";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#avgMeasuredPower
     */
    public static final String BILLING_COMPARISON_AVERAGE_MEASURED_POWER = "avgMeasuredPower";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#avgPowerDelta
     */
    public static final String BILLING_COMPARISON_AVERAGE_POWER_DELTA = "avgPowerDelta";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#lastPowerDelta
     */
    public static final String BILLING_COMPARISON_LAST_POWER_DELTA = "lastPowerDelta";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#usageDelta
     */
    public static final String BILLING_COMPARISON_USAGE_DELTA = "usageDelta";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#billedPower
     */
    public static final String BILLING_COMPARISON_BILLED_POWER = "billedPower";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#measuredPower
     */
    public static final String BILLING_COMPARISON_MEASURED_POWER = "measuredPower";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#powerDelta
     */
    public static final String BILLING_COMPARISON_POWER_DELTA = "powerDelta";
    /**
     * see com.gridpoint.energy.datamodel.BillingComparisonReportRecord#billedUsageDaysMissing
     */
    public static final String BILLING_COMPARISON_BILLED_USAGE_DAYS_MISSING = "billedUsageDaysMissing";

    //
    // Fields for the voltage imbalance report
    //

    /**
     * @see com.gridpoint.energy.domainmodel.VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_SITE_ID = "siteId";
    /**
     * @see com.gridpoint.energy.domainmodel.VoltageImbalanceInstance#siteName
     */
    public static final String VOLTAGE_IMBALANCE_SITE_NAME = "siteName";
    /**
     * @see com.gridpoint.energy.domainmodel.VoltageImbalanceInstance#siteAddress
     */
    public static final String VOLTAGE_IMBALANCE_SITE_ADDRESS = "siteAddress";
    /**
     * @see com.gridpoint.energy.domainmodel.VoltageImbalanceInstance#city
     */
    public static final String VOLTAGE_IMBALANCE_SITE_CITY = "city";
    /**
     * @see com.gridpoint.energy.domainmodel.VoltageImbalanceInstance#state
     */
    public static final String VOLTAGE_IMBALANCE_SITE_STATE = "state";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_N_MAX_IMBALANCE = "phaseToNeutralMaxImbalance";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_N_AVG_IMBALANCE = "phaseToNeutralAverageImbalance";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_N_MAX_IMBALANCE_DATE = "phaseToNeutralImbalanceOccurrence";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_N_DURATION_EXCEEDING_THRESHOLD = "phaseToNeutralDurationExceedingThreshold";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_PH_MAX_IMBALANCE = "phaseToPhaseMaxImbalance";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_PH_AVG_IMBALANCE = "phaseToPhaseAvgImbalance";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_PH_MAX_IMBALANCE_DATE = "phaseToPhaseImbalanceOccurrence";
    /**
     * see VoltageImbalanceInstance#siteId
     */
    public static final String VOLTAGE_IMBALANCE_PH_PH_DURATION_EXCEEDING_THRESHOLD = "phaseToPhaseDurationExceedingThreshold";
    
    

    //
    // Fields for the Solar report 
    //
    
    
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#siteId
     */
    public static final String SOLAR_REPORT_SITE_ID = "siteId";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#siteName
     */
    public static final String SOLAR_REPORT_SITE_NAME = "startName";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#start
     */
    public static final String SOLAR_REPORT_START = "startDate";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#end
     */
    public static final String SOLAR_REPORT_END = "endDate";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#commissionDate
     */
    public static final String SOLAR_REPORT_COMMISSION_DATE = "commissionDate";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#address
     */
    public static final String SOLAR_REPORT_ADDRESS = "address";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#city
     */
    public static final String SOLAR_REPORT_CITY = "city";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#state
     */
    public static final String SOLAR_REPORT_STATE = "state";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#peakProduction
     */
    public static final String SOLAR_REPORT_PEAK_PRODUCTION = "peakProduction";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#peakOccurenceSolar
     */
    public static final String SOLAR_REPORT_PEAK_OCCURENCE_SOLAR = "peakOccurenceSolar";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#peakMainLoad
     */
    public static final String SOLAR_REPORT_PEAK_MAIN_LOAD = "peakMainLoad";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#peakOccurenceMainLoad
     */
    public static final String SOLAR_REPORT_PEAK_OCCURENCE_MAIN_LOAD = "peakOccurenceMainLoad";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#totalGeneration
     */
    public static final String SOLAR_REPORT_TOTAL_GENERATION = "totalGeneration";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#totalUsage
     */
    public static final String SOLAR_REPORT_TOTAL_USAGE = "totalUsage";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#solarData
     */
    public static final String SOLAR_REPORT_SOLAR_DATA = "solarData";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#solarMissing
     */
    public static final String SOLAR_REPORT_SOLAR_MISSING = "solarMissing";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#mainLoadData
     */
    public static final String SOLAR_REPORT_MAIN_LOAD_DATA = "mainLoadData";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#mainLoadMissing
     */
    public static final String SOLAR_REPORT_MAIN_LOAD_MISSING = "mainLoadMissing";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#dailyDate
     */
    public static final String SOLAR_REPORT_DAILY_DATE = "date";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#channelCount
     */
    public static final String SOLAR_REPORT_CHANNEL_COUNT = "subChannelCount";
    /**
     * see com.gridpoint.energy.datamodel.SolarSummary#channelName
     */
    public static final String SOLAR_REPORT_CHANNEL_NAME = "channel";
    
    public static final String SOLAR_REPORT_COINCIDENT_PEAK = "coincidentPeak";
    
    public static final String SOLAR_REPORT_PERCENT_OF_COINCIDENT_PEAK = "percentOfCoincidentPeak";
    
}

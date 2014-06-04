package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;
import com.gridpoint.energy.util.json.ReportField;
import com.gridpoint.energy.util.json.ReportField.Justification;

// DEVELOPERS, if you change the ReportField annotations, change ColumnBuilder.generateVoltageImbalanceReportColumns(), too.
public class VoltageImbalanceInstance {

    /**
     * @see Premises#id
     */
    private Long premisesId;

    /**
     * @see Premises#name
     */
    @ReportField(title = "Site ID", width = 55, position = 1, justification = Justification.LEFT)
    private String siteId;

    /**
     * @see Premises#description
     */
    @ReportField(title = "Site Name", width = 80, position = 2, justification = Justification.LEFT)
    private String siteName;

    /**
     * @see Premises#address1
     */
    @ReportField(title = "Address", width = 110, position = 3, justification = Justification.LEFT)
    private String siteAddress;

    /**
     * @see Premises#city
     */
    @ReportField(title = "City", width = 110, position = 4, justification = Justification.LEFT)
    private String city;

    /**
     * @see Premises#province
     */
    @ReportField(title = "State", width = 110, position = 5, justification = Justification.LEFT)
    private String state;

    @ReportField(title = "Ph-N Max Imbalance (%)", width = 70, position = 11)
    private Double phaseToNeutralMaxImbalance;

    @ReportField(title = "Ph-N Avg Imbalance (%)", width = 70, position = 10)
    private Double phaseToNeutralAvgImbalance;

    @ReportField(title = "Time of Ph-N Max Imbalance Occurrence", format = ReportField.FieldFormat.TIME, width = 70, position = 12)
    private DateTZ phaseToNeutralImbalanceOccurrence;

    @ReportField(title = "Duration (h) That Ph-N Voltage Exceeded Threshold", width = 100, position = 13)
    private Double phaseToNeutralDurationExceedingThreshold;

    @ReportField(title = "Ph-Ph Max Imbalance (%)", width = 70, position = 7)
    private Double phaseToPhaseMaxImbalance;

    @ReportField(title = "Ph-Ph Avg Imbalance (%)", width = 70, position = 6)
    private Double phaseToPhaseAvgImbalance;

    @ReportField(title = "Time of Ph-Ph Max Imbalance Occurrence", format = ReportField.FieldFormat.TIME, width = 70, position = 8)
    private DateTZ phaseToPhaseImbalanceOccurrence;

    @ReportField(title = "Duration (h) That Ph-Ph Voltage Exceeded Threshold", width = 100, position = 9)
    private Double phaseToPhaseDurationExceedingThreshold;

    public Long getPremisesId() {
        return premisesId;
    }

    public void setPremisesId(Long premisesId) {
        this.premisesId = premisesId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getPhaseToNeutralAvgImbalance() {
        return phaseToNeutralAvgImbalance;
    }

    public void setPhaseToNeutralAvgImbalance(Double phaseToNeutralAvgImbalance) {
        this.phaseToNeutralAvgImbalance = phaseToNeutralAvgImbalance;
    }

    public Double getPhaseToNeutralMaxImbalance() {
        return phaseToNeutralMaxImbalance;
    }

    public void setPhaseToNeutralMaxImbalance(Double phaseToNeutralMaxImbalance) {
        this.phaseToNeutralMaxImbalance = phaseToNeutralMaxImbalance;
    }

    public DateTZ getPhaseToNeutralMaxImbalanceOccurrence() {
        return phaseToNeutralImbalanceOccurrence;
    }

    public void setPhaseToNeutralImbalanceOccurrence(DateTZ phaseToNeutralImbalanceOccurrence) {
        this.phaseToNeutralImbalanceOccurrence = phaseToNeutralImbalanceOccurrence;
    }

    public Double getPhaseToNeutralDurationExceedingThreshold() {
        return phaseToNeutralDurationExceedingThreshold;
    }

    public void setPhaseToNeutralDurationExceedingThreshold(Double phaseToNeutralDurationExceedingThreshold) {
        this.phaseToNeutralDurationExceedingThreshold = phaseToNeutralDurationExceedingThreshold;
    }

    public Double getPhaseToPhaseMaxImbalance() {
        return phaseToPhaseMaxImbalance;
    }

    public void setPhaseToPhaseMaxImbalance(Double phaseToPhaseMaxImbalance) {
        this.phaseToPhaseMaxImbalance = phaseToPhaseMaxImbalance;
    }

    public Double getPhaseToPhaseAvgImbalance() {
        return phaseToPhaseAvgImbalance;
    }

    public void setPhaseToPhaseAvgImbalance(Double phaseToPhaseAvgImbalance) {
        this.phaseToPhaseAvgImbalance = phaseToPhaseAvgImbalance;
    }

    public DateTZ getPhaseToPhaseMaxImbalanceOccurrence() {
        return phaseToPhaseImbalanceOccurrence;
    }

    public void setPhaseToPhaseImbalanceOccurrence(DateTZ phaseToPhaseImbalanceOccurrence) {
        this.phaseToPhaseImbalanceOccurrence = phaseToPhaseImbalanceOccurrence;
    }

    public Double getPhaseToPhaseDurationExceedingThreshold() {
        return phaseToPhaseDurationExceedingThreshold;
    }

    public void setPhaseToPhaseDurationExceedingThreshold(Double phaseToPhaseDurationExceedingThreshold) {
        this.phaseToPhaseDurationExceedingThreshold = phaseToPhaseDurationExceedingThreshold;
    }

    public boolean violatesThreshold(Double threshold) {

        return
                (getPhaseToNeutralAvgImbalance() != null && getPhaseToNeutralAvgImbalance() > threshold) ||
                (getPhaseToPhaseAvgImbalance() != null && getPhaseToPhaseAvgImbalance() > threshold);
    }
}

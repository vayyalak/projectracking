package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

import com.gridpoint.energy.util.json.ReportField;

@SuppressWarnings("serial")
public class ElevatedTempReport implements Serializable{

    @ReportField(title="Channel Name", width=75, position=4)
    private String channelName;
    @ReportField(title="Premises", width=70, position=2)
    private String premisesDescription;
    @ReportField(title="Site Id", width=50, position=1)
    private String siteId;
    @ReportField(title="Total Length (hrs)", width=40, position=8)
    private Double hours;
    @ReportField(title="Last Value", width=40, position=9)
    private Double lastValue;
    @ReportField(title="Peak Value", width=40, position=10)
    private Double peak;
    @ReportField(title="Occurrences", width=60, position=7)
    private Long occurrences;
    @ReportField(title="First Occurrence", position=5, width=70, format= ReportField.FieldFormat.TIME)
    private Long firstOccurrence;
    @ReportField(title="Last Occurrence", position=6, width=70, format= ReportField.FieldFormat.TIME)
    private Long lastOccurrence;
    @ReportField(title="Unit", width=40, position=11)
    private String unit;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElevatedTempReport that = (ElevatedTempReport) o;

        if (channelName != null ? !channelName.equals(that.channelName) : that.channelName != null) return false;
        if (firstOccurrence != null ? !firstOccurrence.equals(that.firstOccurrence) : that.firstOccurrence != null)
            return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        if (lastOccurrence != null ? !lastOccurrence.equals(that.lastOccurrence) : that.lastOccurrence != null)
            return false;
        if (lastValue != null ? !lastValue.equals(that.lastValue) : that.lastValue != null) return false;
        if (occurrences != null ? !occurrences.equals(that.occurrences) : that.occurrences != null) return false;
        if (peak != null ? !peak.equals(that.peak) : that.peak != null) return false;
        if (premisesDescription != null ? !premisesDescription.equals(that.premisesDescription) : that.premisesDescription != null)
            return false;
        if (siteId != null ? !siteId.equals(that.siteId) : that.siteId != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = channelName != null ? channelName.hashCode() : 0;
        result = 31 * result + (premisesDescription != null ? premisesDescription.hashCode() : 0);
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (lastValue != null ? lastValue.hashCode() : 0);
        result = 31 * result + (peak != null ? peak.hashCode() : 0);
        result = 31 * result + (occurrences != null ? occurrences.hashCode() : 0);
        result = 31 * result + (firstOccurrence != null ? firstOccurrence.hashCode() : 0);
        result = 31 * result + (lastOccurrence != null ? lastOccurrence.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public String getChannelName() {
        return channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    public String getPremisesDescription() {
        return premisesDescription;
    }
    public void setPremisesDescription(String premisesDescription) {
        this.premisesDescription = premisesDescription;
    }
    public String getSiteId() {
        return siteId;
    }
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public Double getHours() {
        return hours;
    }
    public void setHours(Double hours) {
        this.hours = hours;
    }
    public Double getPeak() {
        return peak;
    }
    public void setPeak(Double peak) {
        this.peak = peak;
    }
    public Long getOccurrences() {
        return occurrences;
    }
    public void setOccurrences(Long occurrences) {
        this.occurrences = occurrences;
    }
    public Long getLastOccurrence() {
        return lastOccurrence;
    }
    public void setLastOccurrence(Long lastOccurrence) {
        this.lastOccurrence = lastOccurrence;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getFirstOccurrence() {
        return firstOccurrence;
    }

    public void setFirstOccurrence(Long firstOccurrence) {
        this.firstOccurrence = firstOccurrence;
    }

    public Double getLastValue(){
        return lastValue;
    }

    public void setLastValue(Double lastValue){
        this.lastValue = lastValue;
    }
}

package com.gridpoint.energy.domainmodel;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to hold a time period of analysis and a listing of sites (premises ids) to percentage values of performance relative to predicted
 * usage, and the average percentage within the set of sites. 
 * 
 * @author cconstantinescu
 */
public class SitePerformers {

    private Integer period;

    /**
     * Average percentage change for the period. The context of this avergae may be either overall change for a period of time, or change
     * versus a previous period of time.
     */
    private Double average = 0D;

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    /**
     * Site id to percentage number. The context of the percentage may be either overall change for a period of time, or change versus a
     * previous period of time.
     */
    private Map<Long, Double> sitePerformances;

    public SitePerformers(Integer period) {
        this.period = period;
        sitePerformances = new HashMap<Long, Double>();
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public void addSitePerformance(Long premisesId, Double value) {
        sitePerformances.put(premisesId, value);
    }

    public Map<Long, Double> getSitePerformances() {
        return sitePerformances;
    }

    public void setSitePerformances(Map<Long, Double> sitePerformances) {
        this.sitePerformances = sitePerformances;
    }

}

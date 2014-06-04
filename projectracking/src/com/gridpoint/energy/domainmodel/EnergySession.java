package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;

/**
 * Represents an EVSE energy session, from the time the EVSE is plugged in until the time it unplugs.
 */
@SuppressWarnings ({"UnusedDeclaration"})
public class EnergySession implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long                deviceId                = null;

    private String              vin                     = null;
    private String              userId                  = null;

    private Long                sessionId               = null;

    /**
     * UTC time, in milliseconds, at energy session start
     */
    private DateTZ              startTime               = null;

    /**
     * UTC time, in milliseconds, at last energy session update (or end)
     */
    private DateTZ              lastTime                = null;

    /**
     * total energy transferred in to resource, in Wh, at the start of this session
     */
    private Double              acEnergyIn              = null;

    /**
     * total energy transferred out of resource, in Wh, at last session update (or end)
     */
    private Double              acEnergyOut             = null;

    /**
     * state of charge % at session start
     */
    private Double              startSoc                = null;

    /**
     * state of charge % at last session update (or end)
     */
    private Double              lastSoc                 = null;

    /**
     * whether a close state was received
     */
    private boolean             closed                  = false;

    /**
     * whether processing had anomalies.
     */
    private boolean             suspect                 = false;

    private Double              minPower                = null;
    private Double              maxPower                = null;
    private Double              meanPower               = null;

    private Double              minCurrent              = null;
    private Double              maxCurrent              = null;
    private Double              meanCurrent             = null;

    private Double              minVoltage              = null;
    private Double              maxVoltage              = null;
    private Double              meanVoltage             = null;

    private Double              minTemp                 = null;
    private Double              maxTemp                 = null;
    private Double              meanTemp                = null;

    private Double              percentTimeCharging     = null;

    private Double              mitigatedLbsCo2         = null;

    public EnergySession () {
    }

    public Long getDeviceId () {
        return deviceId;
    }

    public void setDeviceId (Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getSessionId () {
        return sessionId;
    }

    public void setSessionId (Long sessionId) {
        this.sessionId = sessionId;
    }

    public Double getPercentTimeCharging () {
        return percentTimeCharging;
    }

    public void setPercentTimeCharging (Double percentTimeCharging) {
        this.percentTimeCharging = percentTimeCharging;
    }

    public String getVin () {
        return vin;
    }

    public void setVin (String vin) {
        this.vin = vin;
    }

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    public DateTZ getStartTime () {
        return startTime;
    }

    public void setStartTime (DateTZ startTime) {
        this.startTime = startTime;
    }

    public DateTZ getLastTime () {
        return lastTime;
    }

    public void setLastTime (DateTZ lastTime) {
        this.lastTime = lastTime;
    }

    public Double getAcEnergyIn () {
        return acEnergyIn;
    }

    public void setAcEnergyIn (Double acEnergyIn) {
        this.acEnergyIn = acEnergyIn;
    }

    public Double getAcEnergyOut () {
        return acEnergyOut;
    }

    public void setAcEnergyOut (Double acEnergyOut) {
        this.acEnergyOut = acEnergyOut;
    }

    public Double getStartSoc () {
        return startSoc;
    }

    public void setStartSoc (Double startSoc) {
        this.startSoc = startSoc;
    }

    public Double getLastSoc () {
        return lastSoc;
    }

    public void setLastSoc (Double lastSoc) {
        this.lastSoc = lastSoc;
    }

    public boolean isClosed () {
        return closed;
    }

    public void setClosed (Boolean closed) {
        this.closed = closed;
    }

    public boolean isSuspect () {
        return suspect;
    }

    public void setSuspect (Boolean suspect) {
        this.suspect = suspect;
    }

    public Double getMinPower () {
        return minPower;
    }

    public void setMinPower (Double minPower) {
        this.minPower = minPower;
    }

    public Double getMaxPower () {
        return maxPower;
    }

    public void setMaxPower (Double maxPower) {
        this.maxPower = maxPower;
    }

    public Double getMeanPower () {
        return meanPower;
    }

    public void setMeanPower (Double meanPower) {
        this.meanPower = meanPower;
    }

    public Double getMinCurrent () {
        return minCurrent;
    }

    public void setMinCurrent (Double minCurrent) {
        this.minCurrent = minCurrent;
    }

    public Double getMaxCurrent () {
        return maxCurrent;
    }

    public void setMaxCurrent (Double maxCurrent) {
        this.maxCurrent = maxCurrent;
    }

    public Double getMeanCurrent () {
        return meanCurrent;
    }

    public void setMeanCurrent (Double meanCurrent) {
        this.meanCurrent = meanCurrent;
    }

    public Double getMinVoltage () {
        return minVoltage;
    }

    public void setMinVoltage (Double minVoltage) {
        this.minVoltage = minVoltage;
    }

    public Double getMaxVoltage () {
        return maxVoltage;
    }

    public void setMaxVoltage (Double maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public Double getMeanVoltage () {
        return meanVoltage;
    }

    public void setMeanVoltage (Double meanVoltage) {
        this.meanVoltage = meanVoltage;
    }

    public Double getMinTemp () {
        return minTemp;
    }

    public void setMinTemp (Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp () {
        return maxTemp;
    }

    public void setMaxTemp (Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getMeanTemp () {
        return meanTemp;
    }

    public void setMeanTemp (Double meanTemp) {
        this.meanTemp = meanTemp;
    }

    public Double getMitigatedLbsCo2() {
        return mitigatedLbsCo2;
    }

    public void setMitigatedLbsCo2(Double mitigatedLbsCo2) {
        this.mitigatedLbsCo2 = mitigatedLbsCo2;
    }

}

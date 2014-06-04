package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * domainModel form of an externally-produced alarm.
 */
public class ExternalDeviceOverride implements Serializable {

    private static final long serialVersionUID = 1L;

    private long deviceOverrideId;

    private String referenceId;

    private long premisesId;

    private long endpointId;

    private Long channelId;

    private String name;

    private DeviceOverrideType type;

    private String description;

    private Integer unitNumber;

    private Date overrideStart;

    private int durationMinutes;

    private HVACMode hvacMode;

    private Double configuredSetpoint;

    private Double manualSetpoint;

    public long getDeviceOverrideId() {
        return this.deviceOverrideId;
    }

    public void setDeviceOverrideId(long deviceOverrideId) {
        this.deviceOverrideId = deviceOverrideId;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public long getPremisesId() {
        return this.premisesId;
    }

    public void setPremisesId(long premisesId) {
        this.premisesId = premisesId;
    }

    public long getEndpointId() {
        return this.endpointId;
    }

    public void setEndpointId(long endpointId) {
        this.endpointId = endpointId;
    }

    public Long getChannelId() {
        return this.channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceOverrideType getType() {
        return this.type;
    }

    public void setType(DeviceOverrideType type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUnitNumber() {
        return this.unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Date getOverrideStart() {
        return this.overrideStart;
    }

    public void setOverrideStart(Date overrideStart) {
        this.overrideStart = overrideStart;
    }

    public int getDurationMinutes() {
        return this.durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public HVACMode getHvacMode() {
        return this.hvacMode;
    }

    public void setHvacMode(HVACMode hvacMode) {
        this.hvacMode = hvacMode;
    }

    public Double getConfiguredSetpoint() {
        return this.configuredSetpoint;
    }

    public void setConfiguredSetpoint(Double configuredSetpoint) {
        this.configuredSetpoint = configuredSetpoint;
    }

    public Double getManualSetpoint() {
        return this.manualSetpoint;
    }

    public void setManualSetpoint(Double manualSetpoint) {
        this.manualSetpoint = manualSetpoint;
    }
}
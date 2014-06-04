package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;

public class ConfigUpdateDetailView {

    private Long id;

    private DateTZ lastDelivered;

    private String status;

    private Long premisesId;

    private String exception;

    public ConfigUpdateDetailView(Long id, DateTZ lastDelivered, String status, Long premisesId, String exception) {
        this.id = id;
        this.lastDelivered = lastDelivered;
        this.status = status;
        this.premisesId = premisesId;
        this.exception = exception;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTZ getLastDelivered() {
        return lastDelivered;
    }

    public void setLastDelivered(DateTZ lastDelivered) {
        this.lastDelivered = lastDelivered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPremisesId() {
        return premisesId;
    }

    public void setPremisesId(Long premisesId) {
        this.premisesId = premisesId;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

}

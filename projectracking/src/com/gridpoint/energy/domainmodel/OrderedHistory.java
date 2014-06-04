package com.gridpoint.energy.domainmodel;

/**
 * Used for DataApi.getConfigurationHistory and its dependencies,
 * AdmDataClient.getConfigurationHistory and GpecDataClient.getConfigurationHistory.
 * Modeled on the OrderedHistory class as implemented in the ADMMicro site service.
 */
// see com.gridpoint.energy.publicapi.util.JacksonOrderedHistorySerializer
// see com.gridpoint.energy.publicapi.util.JacksonOrderedHistoryDeserializer
public class OrderedHistory {

    // The following three fields are typically populated only for ADMMicro controllers' configuration history, and they are deliberately nulled out for use with the "export notes" feature in the site manager.  E.g. a GPEC device will likely have a null configurationDeviceId, entityId, deviceNo.
    // TODO: We could substitute the EclCommandEntity.eclCommandEntityId for the configurationDeviceId if null values are a problem.
    private Integer configurationDeviceId;
    private Integer entityId;
    private Integer deviceNo;

    /**
     * The date at which the configuration change took place, in site local time, formatted as yyyy-MM-dd HH:mm:ss.
     */
    private String datestamp;
    private String timezone;
    private String comments;
    private String editedBy;

    /**
     * The site ID; in other words, the ADMMicro short entity display name, or premises name.
     * Typically, this field is null for the portal's "view notes" feature (see publicApi /data/getConfigHistory) and
     * populated for the portal's "export notes" feature (see publicApi /jasper/getConfigHistory).
     * This field is not present in the original OrderedHistory as implemented in the ADMMicro site service.
     * @see Premises#name
     */
    private String siteName;

    public Integer getConfigurationDeviceId() {
        return configurationDeviceId;
    }

    public void setConfigurationDeviceId(Integer configurationDeviceId) {
        this.configurationDeviceId = configurationDeviceId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(Integer deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * Gets the date at which the configuration change took place, in site local time, formatted as yyyy-MM-dd HH:mm:ss.
     * @return the date at which the configuration change took place, in site local time, formatted as yyyy-MM-dd HH:mm:ss.
     */
    public String getDatestamp() {
        return datestamp;
    }

    /**
     * Sets the date at which the configuration change took place, in site local time, formatted as yyyy-MM-dd HH:mm:ss.
     * @param datestamp the date at which the configuration change took place, in site local time, formatted as yyyy-MM-dd HH:mm:ss.
     */
    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(String editedBy) {
        this.editedBy = editedBy;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedHistory)) return false;

        OrderedHistory history = (OrderedHistory) o;

        if (comments != null ? !comments.equals(history.comments) : history.comments != null) return false;
        if (configurationDeviceId != null ? !configurationDeviceId.equals(history.configurationDeviceId) : history.configurationDeviceId != null)
            return false;
        if (datestamp != null ? !datestamp.equals(history.datestamp) : history.datestamp != null) return false;
        if (deviceNo != null ? !deviceNo.equals(history.deviceNo) : history.deviceNo != null) return false;
        if (editedBy != null ? !editedBy.equals(history.editedBy) : history.editedBy != null) return false;
        if (entityId != null ? !entityId.equals(history.entityId) : history.entityId != null) return false;
        if (siteName != null ? !siteName.equals(history.siteName) : history.siteName != null) return false;
        if (timezone != null ? !timezone.equals(history.timezone) : history.timezone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = configurationDeviceId != null ? configurationDeviceId.hashCode() : 0;
        result = 31 * result + (entityId != null ? entityId.hashCode() : 0);
        result = 31 * result + (deviceNo != null ? deviceNo.hashCode() : 0);
        result = 31 * result + (datestamp != null ? datestamp.hashCode() : 0);
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (editedBy != null ? editedBy.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        return result;
    }
}
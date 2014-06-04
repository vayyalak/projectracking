package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 */
public class AuthenticationOverride implements Serializable {

    private static final long serialVersionUID = 1L;

    private long authenticationOverrideId;
    private long deviceId;
    private String policy;
    private Date expirationDate;

    public long getAuthenticationOverrideId() {
        return authenticationOverrideId;
    }

    public void setAuthenticationOverrideId(long authenticationOverrideId) {
        this.authenticationOverrideId = authenticationOverrideId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthenticationOverride that = (AuthenticationOverride) o;

        if (authenticationOverrideId != that.authenticationOverrideId) return false;
        if (deviceId != that.deviceId) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;
        if (policy != null ? !policy.equals(that.policy) : that.policy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (authenticationOverrideId ^ (authenticationOverrideId >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (policy != null ? policy.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        dateFormat.setTimeZone( TimeZone.getTimeZone("GMT") );
        
        return "AuthenticationOverride{" +
                "authenticationOverrideId=" + authenticationOverrideId +
                ", deviceId=" + deviceId +
                ", policy='" + policy + '\'' +
                ", expirationDate=" + expirationDate +
                ", expirationDateStr=" + dateFormat.format(expirationDate) +
                '}';
    }
}

package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

/**
 *
 */
public class AuthenticationMechanism implements Serializable {

    private static final long serialVersionUID = 1L;

    private long authenticationMechanismId;
    private String policy;
    private String provider_name;
    private String credentials;
    private String properties;

    public AuthenticationMechanism() {
        authenticationMechanismId = -1;
    }

    public long getAuthenticationMechanismId() {
        return authenticationMechanismId;
    }

    public void setAuthenticationMechanismId(long authenticationMechanismId) {
        this.authenticationMechanismId = authenticationMechanismId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthenticationMechanism that = (AuthenticationMechanism) o;

        if (authenticationMechanismId != that.authenticationMechanismId) return false;
        if (credentials != null ? !credentials.equals(that.credentials) : that.credentials != null) return false;
        if (policy != null ? !policy.equals(that.policy) : that.policy != null) return false;
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;
        if (provider_name != null ? !provider_name.equals(that.provider_name) : that.provider_name != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (authenticationMechanismId ^ (authenticationMechanismId >>> 32));
        result = 31 * result + (policy != null ? policy.hashCode() : 0);
        result = 31 * result + (provider_name != null ? provider_name.hashCode() : 0);
        result = 31 * result + (credentials != null ? credentials.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthenticationMechanism{" +
                "authenticationMechanismId=" + authenticationMechanismId +
                ", policy='" + policy + '\'' +
                ", provider_name='" + provider_name + '\'' +
                ", credentials='" + credentials + '\'' +
                ", properties='" + properties + '\'' +
                '}';
    }
}

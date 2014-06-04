package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class UserAuthorities implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -2585535594602145631L;


    @JsonDeserialize
    private Map<Long, Set<String>> accessMap = new HashMap<Long, Set<String>>();

    private final Set<String> capabilities = new HashSet<String>();

    private EULA acceptedEula = null;
    private EULA tenantEula = null;

    /* An enduser capability */
    public final static String BYPASS_THROTTLING = "BYPASS_THROTTLING";
    public final static String DISABLE_CIDASHBOARD = "DISABLE_CIDASHBOARD";


    public void authorize(Long tenantId, Set<String> paths) {
        accessMap.put(tenantId, Collections.unmodifiableSet(paths));
    }
   
    public void addCapability(String capability) {
        capabilities.add(capability);
    }

    /**
     * @return the capabilities
     */
    public Set<String> getCapabilities() {
        return Collections.unmodifiableSet(capabilities);
    }

    public boolean isCapable(String capability) {
        return capabilities.contains(capability);
    }

    public Map<Long, Set<String>> getAccessMap() {
        return Collections.unmodifiableMap(accessMap);
    }

    public void setAccessMap(Map<Long, Set<String>> accessMap) {
        this.accessMap = accessMap;
    }

    public Set<String> getAccessOnTenant(Long tenantId) {
        return accessMap.get(tenantId);
    }

    public boolean isAuthorized(Long tenantId) {
        return accessMap.containsKey(tenantId);
    }

    public boolean isAuthorized(List<Long> tenantIds) {
        for(Long tenantId : tenantIds) {
            if(!accessMap.containsKey(tenantId)) {
                return false;
            }
        }
        return true;
    }

	public void setAcceptedEula(EULA acceptedEula) {
		this.acceptedEula = acceptedEula;
	}

	public EULA getAcceptedEula() {
		return acceptedEula;
	}

	public void setTenantEula(EULA tenantEula) {
		this.tenantEula = tenantEula;
	}

	public EULA getTenantEula() {
		return tenantEula;
	}

    @Override
    public String toString() {
        return "UserAuthorities{" +
                "accessMap=" + accessMap +
                ", capabilities=" + capabilities +
                ", acceptedEula=" + acceptedEula +
                ", tenantEula=" + tenantEula +
                '}';
    }
}

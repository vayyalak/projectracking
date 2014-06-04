package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The device domain implementation. When this class is sent to the UI it is run through a custom JSON serializer (GsonDeviceTypeAdapter).
 * If you make changes to this object you *MUST* update the custom serializer or it will never make it to the front end.
 * 
 * @author mrochon
 * see GsonDeviceTypeAdapter
 */
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The device primary key */
    private Long deviceId;

    /** The device type */
    private String deviceType;

    /**
     * premises to which device belongs to
     */
    private Long premisesId;

    /**
     * Endpoint to which device belongs.
     */
    private Long endpointId;

    public Long getPremisesId() {
        return premisesId;
    }

    public void setPremisesId(Long premisesId) {
        this.premisesId = premisesId;
    }

    public Long getEndpointId() {
        return this.endpointId;
    }

    public void setEndpointId(Long endpointId) {
        this.endpointId = endpointId;
    }

    private String premisesDescription;

    public String getPremisesDescription() {
        return premisesDescription;
    }

    public void setPremisesDescription( String desc ) {
        premisesDescription = desc;
    }

    /** The device name */
    private String name;

    /** The device address, MAC, serial etc... */
    private String address;

    /** The device state. A key value pair where the key is a data type such as RELAY_STATE, FAN_MODE etc... */
    private DataMap state;

    /** The device properties. These are all the metadata associated with this device */
    private final List<Property> properties = new ArrayList<Property>();

    /** List of Channels Connected to this Device **/
    private final List<Channel> channels = new ArrayList<Channel>();

    public Device() {
    }

    public List<Channel> getChannels() {
        return channels;
    }

    /**
     * @return the deviceId
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId
     *            the deviceId to set
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return the types
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * @param type
     *            the types to set
     */
    public void setDeviceType(String type) {
        this.deviceType = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the state
     */
    public DataMap getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(DataMap state) {
        this.state = state;
    }

    /**
     * @return the properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( address == null ) ? 0 : address.hashCode() );
        result = prime * result + ( ( channels == null ) ? 0 : channels.hashCode() );
        result = prime * result + ( ( deviceId == null ) ? 0 : deviceId.hashCode() );
        result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
        result = prime * result + ( ( premisesId == null ) ? 0 : premisesId.hashCode() );
        result = prime * result + ( ( properties == null ) ? 0 : properties.hashCode() );
        result = prime * result + ( ( state == null ) ? 0 : state.hashCode() );
        result = prime * result + ( ( deviceType == null ) ? 0 : deviceType.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Device other = (Device) obj;
        if (address == null) {
            if (other.address != null) return false;
        } else if (!address.equals(other.address)) return false;
        if (channels == null) {
            if (other.channels != null) return false;
        } else if (!channels.equals(other.channels)) return false;
        if (deviceId == null) {
            if (other.deviceId != null) return false;
        } else if (!deviceId.equals(other.deviceId)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (premisesId == null) {
            if (other.premisesId != null) return false;
        } else if (!premisesId.equals(other.premisesId)) return false;
        if (properties == null) {
            if (other.properties != null) return false;
        } else if (!properties.equals(other.properties)) return false;
        if (state == null) {
            if (other.state != null) return false;
        } else if (!state.equals(other.state)) return false;
        if (deviceType == null) {
            if (other.deviceType != null) return false;
        } else if (!deviceType.equals(other.deviceType)) return false;
        return true;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

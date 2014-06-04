package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Endpoint implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String referenceId;
    private String password;
    
    /** The endpoint state. A key value pair where the key is a data type such as RELAY_STATE, FAN_MODE etc... */
    private DataMap state;
    
    private String type;
    
    private Long premisesId;
    
    private Firmware firmware;
    private Firmware factoryFirmware;
    
    private DateTZ lastMessageReceived;

    private String controllerFirmwareVersionLabel;

    /**
     * Represents the 6-byte MAC address of this endpoint.
     */
    private Long macAddress;

    /**
     * A case-insensitive serial identifier (a.k.a "serial number", a.k.a. "S/N") that uniquely identifies this endpoint.
     * The serial number is typically assigned by the manufacturer.
     */
    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getControllerFirmwareVersionLabel()
    {
        return controllerFirmwareVersionLabel;
    }

    public void setControllerFirmwareVersionLabel(String controllerFirmwareVersionLabel)
    {
        this.controllerFirmwareVersionLabel = controllerFirmwareVersionLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endpoint)) return false;

        Endpoint endpoint = (Endpoint) o;

        if (macAddress != null ? !macAddress.equals(endpoint.macAddress) : endpoint.macAddress != null) return false;
        if (password != null ? !password.equals(endpoint.password) : endpoint.password != null) return false;
        if (referenceId != null ? !referenceId.equals(endpoint.referenceId) : endpoint.referenceId != null)
            return false;
        if (serial != null ? !serial.equals(endpoint.serial) : endpoint.serial != null) return false;
        if (type != null ? !type.equals(endpoint.type) : endpoint.type != null) return false;
        if (controllerFirmwareVersionLabel != null ? !controllerFirmwareVersionLabel.equals(endpoint.controllerFirmwareVersionLabel) : endpoint.controllerFirmwareVersionLabel!=null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = referenceId != null ? referenceId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
        result = 31 * result + (serial != null ? serial.hashCode() : 0);
        result = 37 * result + (controllerFirmwareVersionLabel != null ? controllerFirmwareVersionLabel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Endpoint{" +
                "id=" + id +
                ", referenceId='" + referenceId + '\'' +
                ", type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                ", controllerFirmwareVersionLabel='" + controllerFirmwareVersionLabel + "'" +
                '}';
    }

    @JsonIgnore
	public void setState(DataMap state) {
		this.state = state;
	}

	public DataMap getState() {
		return state;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
    
	public Firmware getFirmware() {
		return firmware;
	}
	
	public void setFirmware(Firmware firmware) {
		this.firmware = firmware;
	}
	
	public Firmware getFactoryFirmware() {
		return factoryFirmware;
	}
	
	public void setFactoryFirmware(Firmware factoryFirmware) {
		this.factoryFirmware = factoryFirmware;
	}	

    public Long getPremisesId() {
        return premisesId;
    }

    public void setPremisesId(Long premisesId) {
        this.premisesId = premisesId;
    }

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public DateTZ getLastMessageReceived() {
		return lastMessageReceived;
	}

	public void setLastMessageReceived(DateTZ lastMessageReceived) {
		this.lastMessageReceived = lastMessageReceived;
	}

    public Long getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(Long macAddress) {
        this.macAddress = macAddress;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}

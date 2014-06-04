package com.gridpoint.energy.domainmodel;

import java.io.Serializable;


public class DeviceType implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long deviceTypeId;
    private String name;
    private String description;


    public DeviceType() {
    }

    public DeviceType( String name ) {
        this.name = name;
    }

    public void setDeviceTypeId( Long deviceTypeId ) {
        this.deviceTypeId = deviceTypeId;
    }

    public Long getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        DeviceType that = (DeviceType) o;

        if ( description != null ? !description.equals( that.description ) : that.description != null ) return false;
        if ( deviceTypeId != null ? !deviceTypeId.equals( that.deviceTypeId ) : that.deviceTypeId != null )
            return false;
        if ( name != null ? !name.equals( that.name ) : that.name != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceTypeId != null ? deviceTypeId.hashCode() : 0;
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        return result;
    }
}

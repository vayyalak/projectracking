package com.gridpoint.energy.domainmodel.exception;


import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * This exception is thrown when a device object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 * 
 */
public class InvalidDeviceException extends Exception {

    private static final long serialVersionUID = 0L;

    private Long deviceId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public InvalidDeviceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidDeviceException(Throwable throwable) {
        super(throwable);
    }

    public InvalidDeviceException() {
        super();
    }

    public InvalidDeviceException(String message) {
        super(message);
    }

    public InvalidDeviceException(Long deviceId) {
        this.deviceId = deviceId;
    }

    public InvalidDeviceException(String s, Long deviceId) {
        super(s);
        this.deviceId = deviceId;
    }

    public InvalidDeviceException(String s, Throwable throwable, Long deviceId) {
        super(s, throwable);
        this.deviceId = deviceId;
    }

    public InvalidDeviceException(Throwable throwable, Long deviceId) {
        super(throwable);
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("deviceId", deviceId)
                .toString();
    }
}

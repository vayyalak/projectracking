package com.gridpoint.energy.domainmodel.exception;


import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * This exception is thrown when a device object cannot be resolved based on identifying
 * criteria provided to the throwing method.
 *
 */
public class InvalidChannelException
        extends Exception {

    private static final long serialVersionUID = 0L;

    /**
     * Identifies the invalid channel that was referenced.
     */
    Long channelId;

    public InvalidChannelException () {}

    public InvalidChannelException (String message){
        super(message);
    }

    public InvalidChannelException (String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidChannelException (Throwable cause) {
        super(cause);
    }

    public InvalidChannelException(Long channelId) {
        this.channelId = channelId;
    }

    public InvalidChannelException(String s, Long channelId) {
        super(s);
        this.channelId = channelId;
    }

    public InvalidChannelException(String s, Throwable throwable, Long channelId) {
        super(s, throwable);
        this.channelId = channelId;
    }

    public InvalidChannelException(Throwable throwable, Long channelId) {
        super(throwable);
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("channelId", channelId).
                toString();
    }
}
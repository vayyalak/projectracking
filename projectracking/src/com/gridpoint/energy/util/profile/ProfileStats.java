package com.gridpoint.energy.util.profile;

/**
 * This is a work around because in the JEE environment you can't have a singleton
 * and I'm not going to add the overhead of a service to track profiling data.
 */
public interface ProfileStats
{
    public void logCall( final String methodName, final int lengthMillis );
}

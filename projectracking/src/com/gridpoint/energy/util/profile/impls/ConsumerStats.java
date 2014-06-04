package com.gridpoint.energy.util.profile.impls;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import com.gridpoint.energy.util.profile.SimpleMethodProfileStats;

import java.util.List;

@ManagedResource (objectName="com.gridpoint.energy.util.profile.impl:type=ConsumerStats")
public class ConsumerStats extends SimpleMethodProfileStats 
{
    @ManagedAttribute ( description="get All Method Names")
    public List<String> getAllDetailNames() {
        return( super.getAllDetailNames() );
    }

    @ManagedOperation ( description="get Total number of calls for given method")
    public int getCallCount( final String methodName ) {
        return( super.getCallCount( methodName ) );
    }

    @ManagedOperation ( description="get The last call length in millis")
    public int getLastCallLength( final String methodName ) {
        return( super.getLastCallLength( methodName ) );
    }

    @ManagedOperation ( description="get The Max call length ever")
    public int getMaxCallLength ( final String methodName ) {
        return( super.getMaxCallLength( methodName ) );
    }

    @ManagedOperation ( description="get The Avg call length ever")
    public int getAvgCallLength ( final String methodName ) {
        return( super.getAvgCallLength( methodName ) );
    }

    @ManagedOperation ( description="get Total number of calls for given method period")
    public int getPeriodicCallCount( final String methodName ) {
        return( super.getPeriodicCallCount( methodName ) );
    }

    @ManagedOperation ( description="get The Max call length in the last sample period")
    public int getPeriodicMaxCallLength ( final String methodName ) {
        return( super.getPeriodicMaxCallLength( methodName ) );
    }

    @ManagedOperation ( description="get The Avg call length in the last sample period")
    public int getPeriodicAvgCallLength ( final String methodName ) {
        return( super.getPeriodicAvgCallLength( methodName ) );
    }
}
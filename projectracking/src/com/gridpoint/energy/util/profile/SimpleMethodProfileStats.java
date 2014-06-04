package com.gridpoint.energy.util.profile;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.apache.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Iterator;
import javax.management.openmbean.*;

/**
 * Simple Profiler used for trending.
 * Activated by annotating a method with @SimpleProfile
 * For a more complete / enterprisey / expensive solution see: http://www.jinspired.com/
 */
@ManagedResource (objectName="com.gridpoint.energy.util.profile:type=SimpleMethodProfileStats" )
public class SimpleMethodProfileStats implements ProfileStats
{
    private static final Logger logger = Logger.getLogger(SimpleMethodProfileStats.class);

    private final Timer                                      resetTimer  = new Timer("ProfilePeriodResetTimer", true);
    private final ConcurrentHashMap<String, MethodDetails>   detailsMap  = new ConcurrentHashMap<String, MethodDetails>();
    //I don't trust the key.itterator in the ConcHashMap..
    private final List<String>                               methodNames = new CopyOnWriteArrayList<String>();

    public SimpleMethodProfileStats ()
    {
        this( 60 * 60 * 1000 );
    }

    public SimpleMethodProfileStats ( final int periodLength )
    {
        resetTimer.schedule( new TimerTask(){
            @Override
            public void run ()
            {
                try
                {
                    Iterator<String> namesIterator = methodNames.iterator();
                    while( namesIterator.hasNext() ) {
                        MethodDetails details = detailsMap.get( namesIterator.next() );
                        details.resetPeriod();
                    }
                }catch( Exception ex )
                {
                    logger.error("resetTask",ex);
                }
            }
        }, periodLength, periodLength );
    }

    @ManagedAttribute ( description="get All Method Names")
    public List<String> getAllDetailNames() {
        return( methodNames );
    }

    @ManagedOperation ( description="get Total number of calls for given method")
    public int getCallCount( final String methodName ) {
        MethodDetails details = getMethodDetails( methodName );
        if( details != null ) {
            return( details.getCallCount() );
        }
        return( 0 );
    }

    @ManagedAttribute ( description="getCallCounts")
    public CompositeData getCallCounts() {
        CompositeData data = null;
        try
        {
            String[]    names       = getNames();
            if( names == null  ||  names.length == 0 ) {
                return( null );
            }
            Integer[]   values      = new Integer[ names.length ];
            OpenType[]  openTypes   = new OpenType[ names.length ];
            for( int x=0;x<names.length;x++)
            {
                openTypes[x] = SimpleType.INTEGER;
                values[x] = getCallCount( names[x] );
            }
            data = new CompositeDataSupport(new CompositeType("callCounts",
                                                              "callCounts",
                                                              names,
                                                              names, //descriptions
                                                              openTypes),
                                            names,
                                            values);
        }catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return( data );
    }
    private String[] getNames()
    {
        return( methodNames.toArray( new String[methodNames.size()]) );
    }

    @ManagedOperation ( description="get The last call length in millis")
    public int getLastCallLength( final String methodName ) {
        MethodDetails details = getMethodDetails( methodName );
        if( details != null ) {
            return( details.getLastCallLength() );
        }
        return( -1 );
    }
    @ManagedAttribute ( description="get The last call length in millis")
    public CompositeData getLastCallLength() {
        CompositeData data = null;
        try
        {
            String[]    names       = getNames();
            if( names == null  ||  names.length == 0 ) {
                return( null );
            }
            Integer[]   values      = new Integer[ names.length ];
            OpenType[]  openTypes   = new OpenType[ names.length ];
            for( int x=0;x<names.length;x++)
            {
                openTypes[x] = SimpleType.INTEGER;
                values[x] = getLastCallLength( names[x] );
            }
            data = new CompositeDataSupport(new CompositeType("callLength",
                                                              "callLength",
                                                              names,
                                                              names, //descriptions
                                                              openTypes),
                                            names,
                                            values);
        }catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return( data );
    }

    @ManagedOperation ( description="get The Max call length ever")
    public int getMaxCallLength ( final String methodName ) {
        MethodDetails details = getMethodDetails( methodName );
        if( details != null ) {
            return( details.getMaxLength() );
        }
        return( -1 );
    }
    @ManagedAttribute ( description="get The Max call length ever")
    public CompositeData getMaxCallLength() {
        CompositeData data = null;
        try
        {
            String[]    names       = getNames();
            if( names == null  ||  names.length == 0 ) {
                return( null );
            }
            Integer[]   values      = new Integer[ names.length ];
            OpenType[]  openTypes   = new OpenType[ names.length ];
            for( int x=0;x<names.length;x++)
            {
                openTypes[x] = SimpleType.INTEGER;
                values[x] = getMaxCallLength( names[x] );
            }
            data = new CompositeDataSupport(new CompositeType("maxCallLength",
                                                              "maxCallLength",
                                                              names,
                                                              names, //descriptions
                                                              openTypes),
                                            names,
                                            values);
        }catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return( data );
    }


    @ManagedOperation ( description="get The Avg call length ever")
    public int getAvgCallLength ( final String methodName ) {
        MethodDetails details = getMethodDetails( methodName );
        if( details != null ) {
            return( details.getAvgLength() );
        }
        return( -1 );
    }
    @ManagedAttribute ( description="get The Avg call length ever")
    public CompositeData getAvgCallLength() {
        CompositeData data = null;
        try
        {
            String[]    names       = getNames();
            if( names == null  ||  names.length == 0 ) {
                return( null );
            }
            Integer[]   values      = new Integer[ names.length ];
            OpenType[]  openTypes   = new OpenType[ names.length ];
            for( int x=0;x<names.length;x++)
            {
                openTypes[x] = SimpleType.INTEGER;
                values[x] = getAvgCallLength( names[x] );
            }
            data = new CompositeDataSupport(new CompositeType("avgCallLength",
                                                              "avgCallLength",
                                                              names,
                                                              names, //descriptions
                                                              openTypes),
                                            names,
                                            values);
        }catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return( data );
    }

    @ManagedOperation ( description="get Total number of calls for given method period")
    public int getPeriodicCallCount( final String methodName ) {
        MethodDetails details = getMethodDetails( methodName );
        if( details != null ) {
            return( details.getPeriodicCallCount() );
        }
        return( 0 );
    }
    @ManagedAttribute ( description="get Total number of calls for given method period")
    public CompositeData getPeriodicCallCount() {
        CompositeData data = null;
        try
        {
            String[]    names       = getNames();
            if( names == null  ||  names.length == 0 ) {
                return( null );
            }
            Integer[]   values      = new Integer[ names.length ];
            OpenType[]  openTypes   = new OpenType[ names.length ];
            for( int x=0;x<names.length;x++)
            {
                openTypes[x] = SimpleType.INTEGER;
                values[x] = getPeriodicCallCount( names[x] );
            }
            data = new CompositeDataSupport(new CompositeType("periodicCallCount",
                                                              "periodicCallCount",
                                                              names,
                                                              names, //descriptions
                                                              openTypes),
                                            names,
                                            values);
        }catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return( data );
    }

    @ManagedOperation ( description="get The Max call length in the last sample period")
    public int getPeriodicMaxCallLength ( final String methodName ) {
        MethodDetails details = getMethodDetails( methodName );
        if( details != null ) {
            return( details.getPeriodicMaxLength() );
        }
        return( -1 );
    }
    @ManagedAttribute ( description="get The Max call length in the last sample period")
    public CompositeData getPeriodicMaxCallLength() {
        CompositeData data = null;
        try
        {
            String[]    names       = getNames();
            if( names == null  ||  names.length == 0 ) {
                return( null );
            }
            Integer[]   values      = new Integer[ names.length ];
            OpenType[]  openTypes   = new OpenType[ names.length ];
            for( int x=0;x<names.length;x++)
            {
                openTypes[x] = SimpleType.INTEGER;
                values[x] = getPeriodicMaxCallLength( names[x] );
            }
            data = new CompositeDataSupport(new CompositeType("periodicMaxLength",
                                                              "periodicMaxLength",
                                                              names,
                                                              names, //descriptions
                                                              openTypes),
                                            names,
                                            values);
        }catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return( data );
    }

    @ManagedOperation ( description="get The Avg call length in the last sample period")
    public int getPeriodicAvgCallLength ( final String methodName ) {
        MethodDetails details = getMethodDetails( methodName );
        if( details != null ) {
            return( details.getPeriodicAvgLength() );
        }
        return( -1 );
    }
    @ManagedAttribute ( description="get The Avg call length in the last sample period")
    public CompositeData getPeriodicAvgCallLength() {
        CompositeData data = null;
        try
        {
            String[]    names       = getNames();
            if( names == null  ||  names.length == 0 ) {
                return( null );
            }
            Integer[]   values      = new Integer[ names.length ];
            OpenType[]  openTypes   = new OpenType[ names.length ];
            for( int x=0;x<names.length;x++)
            {
                openTypes[x] = SimpleType.INTEGER;
                values[x] = getPeriodicAvgCallLength( names[x] );
            }
            data = new CompositeDataSupport(new CompositeType("periodicAvgLength",
                                                              "periodicAvgLength",
                                                              names,
                                                              names, //descriptions
                                                              openTypes),
                                            names,
                                            values);
        }catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return( data );
    }

    public void logCall( final String methodName, final int lengthMillis ) {

        if( lengthMillis < 0 ) {
            logger.warn("logCall "+ methodName + " negative Time:" + lengthMillis);
            return;
        }

        //Get/Create a MethodDetails object for the given Method Name
        MethodDetails details = detailsMap.get( methodName );
        if(details == null ) {
            details = new MethodDetails();
            MethodDetails oldDetails = detailsMap.putIfAbsent( methodName, details );
            if( oldDetails != null ) {
                details = oldDetails;
            }
            else {
                methodNames.add( methodName );
            }
        }

        //Log the Call Details
        details.logCall( lengthMillis );
    }

    private MethodDetails getMethodDetails( final String methodName ) {
        return( detailsMap.get( methodName ) );
    }

    private static final class MethodDetails
    {
        private final AtomicInteger         lastCallLength      = new AtomicInteger();
        //Stats for the entire length of run
        private final Data                  totalData           = new Data();
        //stats for the period.
        private final AtomicReference<Data> periodicData        = new AtomicReference<Data>( new Data() );

        public void logCall( final int lengthMillis ) {
            totalData.updateData( lengthMillis );
            lastCallLength.set( lengthMillis );
            periodicData.get().updateData( lengthMillis );
        }

        public void resetPeriod()
        {
            //periodicReset.set(true);
            Data newData = new Data();
            periodicData.set( newData );
        }

        public int getCallCount() {
            return( totalData.count.get() );
        }

        public int getLastCallLength() {

            return( lastCallLength.get() );
        }

        public int getMaxLength() {
            return( totalData.max.get() );
        }

        public int getAvgLength( ) {
            long count = getCallCount();
            if( count == 0 ){
                return( 0 );
            } else {
                return( (int)(totalData.sumLength.get() / count) );
            }
        }

        public int getPeriodicCallCount() {
            return( periodicData.get().count.get() );
        }

        public int getPeriodicMaxLength() {
            return( periodicData.get().max.get() );
        }

        public int getPeriodicAvgLength( ) {
            long count = getPeriodicCallCount();
            if( count == 0 ){
                return( 0 );
            } else {
                return( (int)(periodicData.get().sumLength.get() / count) );
            }
        }

        private static final class Data {
            public final AtomicInteger  count       = new AtomicInteger();
            public final AtomicLong     sumLength   = new AtomicLong();
            public final AtomicInteger  max         = new AtomicInteger();

            public void updateData( final int length ) {
                setIfGreaterThan(max, length );
                count.addAndGet(1);
                sumLength.addAndGet( length );
            }
        }

        /**
         * IMplements set if target greater than value
         * @param target
         * @param value
         */
        private static void setIfGreaterThan ( final AtomicInteger target, final int value ) {
            //The naieve implementation
            int savedTarget = target.get();
            if( value > savedTarget ) {
                target.set( value );
            }

//The strict implementation
//            while( true ) {
//                int savedTarget = target.get();
//                if( value > savedTarget ) {
//                    if( target.compareAndSet( savedTarget, value ) ) {
//                        return;
//                    } //else concurrent race. try again.
//                } else {
//                    return; //not Greater than
//                }
//            }
        }
    }
}

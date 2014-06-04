package com.gridpoint.energy.util.stats;

import org.cliffc.high_scale_lib.Counter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A performance Counter convenience class that periodically resets so you can see min/max variations in the period.
 */
public class Stat
{
    public  static final long       HOUR    = 60*60*1000;
    private static final Timer      timer   = new Timer("StatResetTimer",true);
    private static final List<Stat> stats   = new CopyOnWriteArrayList<Stat>();

    static {
        timer.schedule( new TimerTask() {

            @Override
            public void run ()
            {
                try
                {
                    for(Stat stat : stats ) {
                        if( stat.shouldReset() ) {
                            stat.reset();
                        }
                    }
                }catch( Throwable ignored )
                {}
            }
        },60000,60000 );
    }
    private static final long       UNSET = -1;

    private final   Counter totalCalls    = new Counter();
    private final   Counter sum           = new Counter();
    private final   Counter min           = new Counter();
    private final   Counter max           = new Counter();
    private         long    lastResetTime = System.currentTimeMillis();
    private         long    resetPeriod   = 15 * 60 * 1000;


    public Stat () {
        this( 15 * 60 * 1000 );
    }
    /**
     *
     * @param resetPeriod Number of millis to reset values
     */
    public Stat (long resetPeriod) {
        this.resetPeriod = resetPeriod;
        this.max.set( UNSET );
        this.min.set( UNSET );
        stats.add( this );
    }


    /**
     * One Call took this much Time (no units)
     * @param length
     */
    public void logStat( long length ) {
        sum.add( length );
        totalCalls.increment();
        long val = min.estimate_get();
        if( val == UNSET || length < val ) {
            min.set( length );
        }
        val = max.estimate_get();
        if( val == UNSET || length > val ) {
            max.set( length );
        }
    }

    /**
     *
     * @param numCalls  this many calls
     * @param length took this much time (no units)
     */
    public void logStat( int numCalls, long length ) {
        sum.add( length );
        totalCalls.add( numCalls );
        long val = min.estimate_get();
        if( val == UNSET || length < val ) {
            min.set( length );
        }
        val = max.estimate_get();
        if( val == UNSET || length > val ) {
            max.set( length );
        }
    }


    public void reset() {
        totalCalls.set(0);
        sum.set(0);
        min.set(UNSET);
        max.set(UNSET);
        this.lastResetTime = System.currentTimeMillis();
    }

    public long getResetPeriod() {
        return( this.resetPeriod );
    }

    public void setResetPeriod (long resetPeriod) {
        this.resetPeriod = resetPeriod;
    }

    public long getLastResetTime() {
        return( this.lastResetTime );
    }

    public boolean shouldReset() {
        return( this.lastResetTime + resetPeriod < System.currentTimeMillis() );
    }


    public long getTotalCalls() {
        return( totalCalls.estimate_get() );
    }
    public long getSum() {
        return( sum.estimate_get() );
    }
    public long getMin() {
        return(min.estimate_get());
    }
    public long getMax() {
        return(max.estimate_get());
    }
    public double getAvg() {
        long totalCalls = this.totalCalls.estimate_get();
        if( totalCalls == 0 ) {
            return(0);
        }
        return( sum.estimate_get() / (double)totalCalls );
    }
}

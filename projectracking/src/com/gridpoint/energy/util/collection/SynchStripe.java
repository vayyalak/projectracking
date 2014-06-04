package com.gridpoint.energy.util.collection;

/**
 * Provides a Stipe of Synchronization objects..
 * This increases paralellism because it is assumed the input value will be statistically random...
 * But ensures sequential consistency because it is synchronized.
 */
public class SynchStripe
{
    private final Object[] synchObjects;

    public SynchStripe( )
    {
        this(997); //prime number
    }

    /**
     *
     * @param size  Size should probably be a prime number to deter cycles hashing to same bucket. 
     */
    public SynchStripe( int size )
    {
        synchObjects = new Object[size];
        for( int x=0;x<size;x++)
        {
            synchObjects[x] = new Object();
        }
    }

    public Object getSynch( long val )
    {
        return( synchObjects[(int)(val % synchObjects.length)] );
    }
}

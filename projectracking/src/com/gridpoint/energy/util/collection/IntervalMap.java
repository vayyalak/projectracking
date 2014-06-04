package com.gridpoint.energy.util.collection;

import java.io.Serializable;
import java.util.*;

/**
 * Need to find the free interval tree map that does this for us.
 * TODO: make this more concurrent.
 */
public class IntervalMap<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final TreeMap<Interval,T> map;

    public IntervalMap( )
    {
        this.map = new TreeMap<Interval,T>( new Comparer() );
    }

    private IntervalMap( TreeMap<Interval,T> map )
    {
        this.map = map;
    }

    public void clear() {
        map.clear();
    }

    /**
     *
     * @param intervalKey
     * @param val
     * @throws Exception Exception if overlapping
     */
    synchronized public T putInterval ( Interval intervalKey, T val )
        throws OverlappingIntervalException
    {
        Map.Entry<Interval,T> ceil = map.ceilingEntry( intervalKey );

        if( ceil == null )
        {
            return( map.put( intervalKey, val ) );
        }
        else if( ceil.getKey().equals(intervalKey) )
        {
            if( ceil.getValue() == null )
            {
                return( map.put( intervalKey, val ) );
            }
            else
            {
                throw new OverlappingIntervalException();
            }
        }
        else
        {
            if( intervalKey.getEnd() < ceil.getKey().getStart() )
            {
                return( map.put( intervalKey, val ) );
            }
            else
            {
                throw new OverlappingIntervalException();
            }
        }
    }

    synchronized public T getByPoint( long point )
    {
        Interval testInterval = new Interval(point, point );
        Map.Entry<Interval,T> floor = map.floorEntry( testInterval );
        Map.Entry<Interval,T> ceil  = map.ceilingEntry( testInterval );

        if( floor != null  &&  floor.getKey().contains( point ) )
        {
            return( floor.getValue() );
        }
        else if( ceil != null  &&  ceil.getKey().contains( point ) )
        {
            return( ceil.getValue() );
        }

        return( null );
    }

    synchronized public T getByInterval( Interval interval )
    {
        return( map.get( interval ) );
    }

    synchronized public Interval[] getIntervals ()
    {
        return( map.keySet().toArray( new Interval[map.size() ] ) );
    }

    synchronized public T remove( Interval intervalKey )
    {
        return( map.remove( intervalKey ) );
    }


    synchronized public boolean contains (Interval interval)
    {
        return( map.containsKey( interval ) );
    }

    @SuppressWarnings ({"unchecked"})
    synchronized public IntervalMap<T> snapshot ()
    {
        return( new IntervalMap<T>( (TreeMap<Interval,T>) map.clone() ) );
    }

    public void clearMapping (Interval interval)
    {
        map.put( interval, null );
    }

    synchronized public String dump ()
    {
        String result = "";
        for( Map.Entry<Interval,T> entry : map.entrySet()) {
            result += ( entry.getKey() + "::" + entry.getValue() + "\n" );
        }
        return( result );
    }

    private static final class Comparer implements Comparator<Interval>, Serializable
    {
        private static final long serialVersionUID = 1L;
        @Override
        public int compare (Interval o1, Interval o2)
        {
            if( o1.getStart() < o2.getStart() )
            {
                return( -1 );
            }
            if( o1.getStart() > o2.getStart() )
            {
                return( 1 );
            }
            else
            {
                return 0;
            }
        }
    }

}

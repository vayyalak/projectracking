package com.gridpoint.energy.util.tree;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A useful head start for implementing indexed domain object hierarchies.
 *
 * In this context, a "domain" object is a JavaBean that has a Long-valued property that uniquely identifies
 * itself within another domain object.
 *
 * @author dhorlick
 */
public abstract class AbstractDomainIndexTreeNode<K, T> implements Iterable<T>
{
    private SortedMap<K, T> childNodes = new TreeMap<K, T> ();

    public abstract Object key();

    public T value;

    public Iterator<T> iterator()
    {
        return childNodes.values().iterator();
    }

    public T getOrCreate(final K key)
    {
        if (key==null)
            throw new IllegalArgumentException("No key provided.");

        if (childNodes.containsKey(key))
            return childNodes.get(key);

        final T node = newElementInstance(key);
        childNodes.put(key, node);
        return node;
    }
    
    public boolean exists(final K key) {
        return childNodes.containsKey(key);
    }

    public abstract T newElementInstance(final K key);

    public long size()
    {
        return childNodes.size();
    }

    @Override
    public int hashCode()
    {
        return key().hashCode();
    }
}

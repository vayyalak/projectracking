package com.gridpoint.energy.util.caching;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Cache of basic sessions.
 *
 * <b>Note</b>: For speed we don't synchronize access to the cache, so
 * some of the statistics may appear wonky at times.
 */
@ManagedResource
public abstract class AbstractCache<K,V> {

    private static final Logger log = Logger.getLogger(AbstractCache.class);
    
    protected Map<K,V> cache = new HashMap<K,V>();

    private long requests = 0;

    private long misses = 0;

    @ManagedAttribute
    public long getRequests() {
        return this.requests;
    }

    @ManagedAttribute
    public long getMisses() {
        return this.misses;
    }

    @ManagedAttribute
    public int getSize() {
        return cache.size();
    }

    /**
     * It is expected that subclasses of this class
     * override this method, then call super.get
     * to retrieve the value.
     */
    protected V get(K key) {
        requests++;
        
        V value = cache.get(key);
        
        if (value == null) {
            misses++;
        }

        return value;
    }

    /**
     * It is expected that subclasses of this class
     * override this method, then call super.put
     * to store the value.
     */
    protected void put(K key, V value) {
        synchronized(cache) {
            cache.put(key, value);
        }
    }

    @ManagedOperation
    public void reset() {
        misses = 0;
        requests = 0;
    }

    protected String key(Object ... values) {
        StringBuffer buffer = null;

        for (Object value : values) {
            if (buffer == null) {
                buffer = new StringBuffer(String.valueOf(value));
            } else {
                buffer.append(":");
                buffer.append(value);
            }
        }

        return buffer.toString();
    }

    @Override
    @ManagedOperation
    public String toString() {
        return cache.toString();
    }
}
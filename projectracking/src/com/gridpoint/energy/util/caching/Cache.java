package com.gridpoint.energy.util.caching;

/**
 * Interface for caching arbitrary data in the application.
 */
public interface Cache<K,V> {

    /**
     * Returns the value associated with the given key, or null
     * if the key does not exist in the cache.
     *
     * @param key the key used to lookup the value.  Make sure
     * you use an immutable data structure, such as a String.
     * @return the value associated with the given key, or null
     * if no such value exists.
     */
    V get(K key);

    /**
     * Insert the given key, value pair into the cache.  Works
     * just like a map, if the key already exists, the value
     * vill be overridden.
     *
     * @param key the key that will be used to retrieve the
     * value in the future.
     * @param value the value to associate with the key.
     */
    void put(K key, V value);

    /**
     * Removes the given key from the cache.  Has no effect
     * if the key does not exist in the cache.
     *
     * @parma key the key to remove from the cache.
     */
    void remove(K key);
}

package com.gridpoint.energy.util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class UnmodifiableHashtable<K, V> extends Hashtable<K, V> {
    private static final long serialVersionUID = 1L;

    public static <K, V> UnmodifiableHashtable<K, V> empty() {
        UnmodifiableHashtable<K, V> result = new UnmodifiableHashtable<K, V>(new Hashtable<K, V>());
        return result;
    }

    private final Hashtable<K, V> table;

    public UnmodifiableHashtable(Hashtable<K, V> table) {
        this.table = table;
    }

    public int size() {
        return table.size();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

    public Enumeration<K> keys() {
        return table.keys();
    }

    public Enumeration<V> elements() {
        return table.elements();
    }

    public boolean contains(Object value) {
        return table.contains(value);
    }

    public boolean containsValue(Object value) {
        return table.containsValue(value);
    }

    public boolean containsKey(Object key) {
        return table.containsKey(key);
    }

    public V get(Object key) {
        return table.get(key);
    }

    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K, ? extends V> t) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Object clone() {
        return table.clone();
    }

    public String toString() {
        return table.toString();
    }

    public Set<K> keySet() {
        return Collections.unmodifiableSet(table.keySet());
    }

    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(table.entrySet());
    }

    public Collection<V> values() {
        return Collections.unmodifiableCollection(table.values());
    }

    public boolean equals(Object o) {
        return table.equals(o);
    }

    public int hashCode() {
        return table.hashCode();
    }
}

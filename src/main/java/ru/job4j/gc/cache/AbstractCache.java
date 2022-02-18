package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
    this.cache.put(key, (SoftReference<V>) value);
    }

    public V get(K key) {
        return (V) cache.get(key);
    }

    protected abstract V load(K key);

}

package ru.job4j.gc.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> softReference = new SoftReference<>(value);
        this.cache.put(key, softReference);
    }

    public V get(K key) {
        return cache.getOrDefault(key, new SoftReference<>(null)).get();
    }

    protected abstract V load(K key) throws IOException;

}

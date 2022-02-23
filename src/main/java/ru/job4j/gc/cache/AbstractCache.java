package ru.job4j.gc.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
    }

    public V get(K key) throws IOException {
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        SoftReference<V> softReference = new SoftReference<>(value);
        if (value == null) {
            this.cache.put(key, softReference);
        }
        return load(key);
    }

    protected abstract V load(K key) throws IOException;

}

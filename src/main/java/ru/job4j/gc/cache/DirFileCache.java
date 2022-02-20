package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        SoftReference<String> softStringKey = new SoftReference<>(key);
            cache.put(this.cachingDir, softStringKey);
        return key;
    }

}

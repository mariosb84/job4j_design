package ru.job4j.gc.cache;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.SoftReference;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        SoftReference<String> softStringKey = new SoftReference<>(key);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(this.cachingDir))) {
            out.write(key);
            out.write(System.lineSeparator());
            cache.put(this.cachingDir, softStringKey);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return key;
    }

}

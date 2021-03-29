package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        if (findById(id) != null) {
            mem.set(Integer.parseInt(id), model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (findById(id) != null) {
            mem.remove(Integer.parseInt(id));
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        for (T t : mem) {
            if (t.equals(mem.get(Integer.parseInt(id)))) {
                return t;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MemStore<? extends Base> memStore = new MemStore<>();
        memStore.add(null);                                         // wildcards extends - only read
        memStore.add(null);
        memStore.add(null);
        memStore.add(null);
        System.out.println(memStore.findById("1"));
        System.out.println(memStore.mem);
        //memStore.replace("0", null);                       // wildcards extends - only read
       // memStore.delete("0");
       // System.out.println(memStore.findById("0"));
        System.out.println(memStore.mem);
    }
}

package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        MemStore memStore = new MemStore<>();
        memStore.add(new Base("1") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        memStore.add(new Base("2") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        memStore.add(new Base("3") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        System.out.println(Objects.requireNonNull(memStore.findById("0")).getId());
        memStore.replace("0", new Base("4") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        System.out.println(Objects.requireNonNull(memStore.findById("0")).getId());
        memStore.delete("0");
        System.out.println(Objects.requireNonNull(memStore.findById("0")).getId());

    }


}

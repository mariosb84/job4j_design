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
            mem.set(indexOf(id), model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (findById(id) != null) {
            mem.remove(indexOf(id));
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T t = null;
        int i = indexOf(id);
       if (i != -1) {
          t = mem.get(i);
       }
        return t;
    }
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
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
        System.out.println((memStore.indexOf("1")));
        memStore.replace("1", new Base("4") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        System.out.println((memStore.indexOf("1")));
        System.out.println((memStore.indexOf("4")));
        memStore.delete("4");
        System.out.println((memStore.indexOf("4")));
        System.out.println((memStore.indexOf("2")));
        System.out.println((memStore.indexOf("3")));


    }


}

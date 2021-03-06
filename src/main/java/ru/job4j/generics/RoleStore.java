package ru.job4j.generics;

import java.util.Objects;

public class RoleStore implements Store<Role> {
    private final Store<Role> storeSecond = new MemStore<>();


    @Override
    public void add(Role model) {
        storeSecond.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return storeSecond.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return storeSecond.delete(id);
    }

    @Override
    public Role findById(String id) {
        return storeSecond.findById(id);
    }

    public static void main(String[] args) {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        roleStore.add(new Role("2") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        roleStore.add(new Role("3") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        System.out.println((roleStore.findById("1")).getId());
        roleStore.replace("1", new Role("4") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        System.out.println((roleStore.findById("4")).getId());
        roleStore.delete("4");
        System.out.println((roleStore.findById("2")).getId());
        System.out.println((roleStore.findById("3")).getId());
    }
}

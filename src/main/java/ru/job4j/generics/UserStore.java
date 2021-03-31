package ru.job4j.generics;

import java.util.Objects;

public class UserStore implements Store<User>  {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }

    public static void main(String[] args) {
        UserStore userStore = new UserStore();
        userStore.add(new User("1") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        userStore.add(new User("2") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        userStore.add(new User("3") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        System.out.println((userStore.findById("1").getId()));
        userStore.replace("1", new User("4") {
            @Override
            public String getId() {
                return super.getId();
            }
        });
        System.out.println((userStore.findById("4").getId()));
        userStore.delete("4");
        System.out.println((userStore.findById("2").getId()));
        System.out.println((userStore.findById("3").getId()));

    }
}

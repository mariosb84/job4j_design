package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> map = new HashMap<>();
        int add = 0, change = 0, delete = 0;
        for (User userPrevious : previous) {
            map.put(userPrevious.getId(), userPrevious);
        }
        for (User userCurrent : current) {
            if  (!map.containsKey(userCurrent.getId())) {
                add = 1;
            }
            if (map.containsKey(userCurrent.getId())
                    && (!map.get(userCurrent.getId()).equals(userCurrent))) {
                change = 1;
            }

                delete = previous.size() + add - current.size();
        }

        return new Info(add, change, delete);
    }

}

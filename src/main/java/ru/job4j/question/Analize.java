package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int add = 0, change = 0, delete = 0;
        for (User userPrevious : previous) {
        for (User userCurrent : current) {
                 if (userChange(userPrevious, userCurrent)) {
                change = 1;
                           }
            if ((!current.contains(userPrevious)) && (!userChange(userPrevious, userCurrent))) {
                delete = 1;
                        }
            if ((!previous.contains(userCurrent)) && (!userChange(userPrevious, userCurrent))) {
                add = 1;
              }

            }

        }
        return new Info(add, change, delete);
    }
    private static boolean userChange(User userPrevious, User userCurrent) {
        return (Objects.equals(userPrevious.getId(), userCurrent.getId())
                && (!Objects.equals(userPrevious.getName(), userCurrent.getName())));
    }

}

package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSort {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        User user1 = new User(23);
        User user2 = new User(4);
        User user3 = new User(55);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
               return o2.getId().compareTo(o1.getId());
            }
        });

        for (User user : list) {
            System.out.println(user.getId());
        }
    }
}

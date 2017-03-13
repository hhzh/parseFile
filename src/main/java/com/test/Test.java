package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "tom"));
        users.add(new User(1, "tom"));
        users.add(new User(2, "lily"));
        users.add(new User(3, "aa"));
        users.add(new User(2, "lily"));
        //for (User user : users) {
        //	if (user.getName().equals("lily")) {
        //		users.remove(user);
        //	}
        //}

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equals("lily")) {
                iterator.remove();
            }
        }

        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}

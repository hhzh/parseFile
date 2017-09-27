package com.test;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setName("zhangsan");
        list.add(user);
        list.add(null);
        User user1 = new User();
        user1.setName("lisi");
        list.add(user1);
        list.add(null);

        for (User user2 : list) {
            System.out.println(user2);
        }
    }
}

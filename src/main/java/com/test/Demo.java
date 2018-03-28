package com.test;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //List<User> list = new ArrayList<User>();
        //User user = new User();
        //user.setName("zhangsan");
        //list.add(user);
        //list.add(null);
        //User user1 = new User();
        //user1.setName("lisi");
        //list.add(user1);
        //list.add(null);
        //
        //for (User user2 : list) {
        //    System.out.println(user2);
        //}

        //System.out.println(Runtime.getRuntime().availableProcessors());

        //for (int i = 1; i < 10001; i++) {
        //    System.out.println("D:/imgtest/img/" + i + ".jpg");
        //}
        //String name = "cropImg2.jpg";
        //System.out.println(name.substring(name.lastIndexOf(".") + 1));
        //String ab = "ab";
        //String a = "a";
        //String b = "b";
        //String abObj = new String("ab");
        //String abbb = a + b;
        //System.out.println(ab.equals(abbb));
        //System.out.println(ab.equals(abObj));
        //System.out.println(ab==abbb);
        //System.out.println(ab==abObj);
        //Object obj = new Object();

        String groupPath = "group1/M00/01/3A/cnBodVq5wq-AYi7yACttOcwyD8c864.jpg";
        System.out.println(groupPath.substring(0, groupPath.indexOf("/")));
        System.out.println(groupPath.substring(groupPath.indexOf("/") + 1));
    }
}

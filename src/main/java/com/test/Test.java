package com.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        //List<User> users = new ArrayList<User>();
        //users.add(new User(1, "tom"));
        //users.add(new User(1, "tom"));
        //users.add(new User(2, "lily"));
        //users.add(new User(3, "aa"));
        //users.add(new User(2, "lily"));
        //
        ////for (User user : users) {
        ////	if (user.getName().equals("lily")) {
        ////		users.remove(user);
        ////	}
        ////}
        //
        //Iterator<User> iterator = users.iterator();
        //while (iterator.hasNext()) {
        //    User user = iterator.next();
        //    if (user.getName().equals("lily")) {
        //        iterator.remove();
        //    }
        //}
        //
        //for (User user : users) {
        //    System.out.println(user.toString());
        //}

        //String head = "";
        //System.out.println("\\u".substring(0));
        //System.out.println("wefe\"\"f\\uwefwf");
        //System.out.println("dfsd中文" + cnToUnicode("中文"));
        //System.out.println("中文");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        System.out.println(now);
        Map<String, String> map = new HashMap<>();
        //map.get()

    }

    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }
}

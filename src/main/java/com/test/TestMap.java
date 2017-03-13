package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map<String, List> listMap = new HashMap<String, List>();
        List<String> list = new ArrayList<String>();
        list.add("cc");
        listMap.put("aa", list);

        List list1 = listMap.get("aa");
        list1.add("bb");
        List list2 = listMap.get("aa");
        System.out.println(list2.size());
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
    }
}

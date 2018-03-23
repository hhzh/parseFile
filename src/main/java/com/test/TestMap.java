package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMap {

    public static void main(String[] args) {
        //Map<String, List> listMap = new HashMap<String, List>();
        //List<String> list = new ArrayList<String>();
        //list.add("cc");
        //listMap.put("aa", list);
        //
        //List list1 = listMap.get("aa");
        //list1.add("bb");
        //List list2 = listMap.get("aa");
        //System.out.println(list2.size());
        //System.out.println(list2.get(0));
        //System.out.println(list2.get(1));
        //Iterator<Map.Entry<String, List>> iterator = listMap.entrySet().iterator();
        //while (iterator.hasNext()) {
        //    Map.Entry<String, List> next = iterator.next();
        //    String key = next.getKey();
        //    List value = next.getValue();
        //}
        //
        //for (Map.Entry<String, List> stringListEntry : listMap.entrySet()) {
        //    String key = stringListEntry.getKey();
        //    List value = stringListEntry.getValue();
        //}

        //for (int i = 1; i < 1001; i++) {
        //    System.out.println("E:/img/"+i+".jpg");
        //}

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(3);
        atomicInteger.incrementAndGet();
        //concurrentHashMap.putIfAbsent();
    }
}

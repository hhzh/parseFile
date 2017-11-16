package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestCon {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
        }

        for (Map.Entry<String, String> next : map.entrySet()) {
            String key = next.getKey();
            String value = next.getValue();
        }
    }

    public void test() {
        Map<String, String> map = new HashMap<>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
        }

    }
}

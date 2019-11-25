package com.tech;

public class Demo3 {

    public static void main(String[] args) {
        final LRU<String, String> lru = new LRU<>(3);
        lru.put("k1", "v1");
        lru.put("k2", "v2");
        lru.put("k3", "v3");
        System.out.println(lru.toString());
        System.out.println("---------------------");
        lru.put("k4", "v4");
        System.out.println(lru.toString());
        System.out.println("---------------------");
        lru.remove("k2");
        System.out.println(lru.toString());
    }


}

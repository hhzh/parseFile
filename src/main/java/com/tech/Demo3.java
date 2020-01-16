package com.tech;

public class Demo3 {

    public static void main(String[] args) {
        final LRU<String, String> lru = new LRU<>(3);
        String str = "ab";
        String cc = new String("ab");
        System.out.println(str == cc);
        System.out.println(str.equals(cc));
        System.out.println(100>>>1);
        System.out.println(100>>1);
    }


}

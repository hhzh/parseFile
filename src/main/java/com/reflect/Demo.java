package com.reflect;

public class Demo {
    public Demo() {
    }

    public Demo(String name) {
        System.out.println("---"+name);
    }

    protected Demo(String name1, String name2) {
        System.out.println("--"+name1+"--"+name2);
    }

    private String hello() {
        return "hello";
    }

    public void world(String world) {
        System.out.println("++="+world);
    }
}

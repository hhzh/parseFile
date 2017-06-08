package com.test;

public class TestStringBuilder {

    public static void main(String[] args) {
        String temp = null;
        StringBuilder sb = new StringBuilder();
        sb.append("sdl");
        sb.append(temp);
        sb.append("sedf");
        System.out.println(sb.toString());
    }
}

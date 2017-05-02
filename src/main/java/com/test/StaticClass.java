package com.test;

public class StaticClass {

    private int a;

    public StaticClass test1(int a) {
        this.a=a;
        return this;
    }

    public StaticClass test2(int a) {
        this.a=a;
        return this;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        StaticClass staticClass=new StaticClass();
        staticClass.test1(1);
        staticClass.test2(2);
        System.out.println(staticClass.getA());
    }
}

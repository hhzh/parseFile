package com.test;

public class TestException {

    public static void main(String[] args) {
        int returnint = new TestException().returnint();
        System.out.println(returnint);
    }


    public int returnint() {
        try {
            return 2;
        } catch (Exception e) {
            return 0;
        }finally {
            return 1;
        }

    }
}

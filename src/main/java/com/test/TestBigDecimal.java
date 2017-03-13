package com.test;

import java.math.BigDecimal;

public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("5.6");
        bigDecimal = bigDecimal.multiply(new BigDecimal(2));
        System.out.println(bigDecimal);
    }
}

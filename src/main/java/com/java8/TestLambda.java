package com.java8;

import java.util.ArrayList;
import java.util.List;


public class TestLambda {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(9);
        list.add(5);
        list.add(8);

        list.sort((Integer a, Integer b) -> b.compareTo(a));

        for (Integer integer : list) {
            System.out.println(integer);
        }

        //List<Integer> inList = filter(list, (Integer i) -> i > 4);
    }
}

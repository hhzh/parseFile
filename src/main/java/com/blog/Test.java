package com.blog;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static List<Apple> filterApples(List<Apple> apples,Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green",12));
        apples.add(new Apple("red", 10));
        apples.add(new Apple("red", 20));

        //List<Apple> apples1 = filterApples(apples, predicate -> "red".equals(predicate.getColor()));
        List<Apple> apples1 = filterApples(apples, predicate -> predicate.getWeight() > 15);
        apples1.forEach(System.out::println);
    }
}

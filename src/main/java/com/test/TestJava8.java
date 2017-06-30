package com.test;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestJava8 {

    public static void main(String[] args) {
        //list.forEach(System.out::println);

        //IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).forEach(n-> System.out.print(n+","));

        //Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).forEach(
        //        t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        //System.out.println(new Date());
        //System.out.println(LocalDate.of(2017, 6, 29));
        //System.out.println(LocalDate.now());
        //System.out.println(LocalDateTime.now());
        //System.out.println(LocalTime.now());
        //System.out.println(ChronoField.YEAR);
        //LocalDate localDate = LocalDate.now();
        //System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        //new ArrayList<>();
        //Object object = null;

        //Optional<User> userOptional = Optional.empty();
        //System.out.println(userOptional.map(user -> user.getName()));
        //Optional<Object> o = Optional.ofNullable(null);
        //System.out.println(Optional.ofNullable(null));

        List<User> users = new ArrayList<>();
        users.add(new User(1));
        users.add(new User(22));
        users.add(new User(5));
        users.forEach(user -> user.setName("ZhangSan"));
        //List<User> zhangSan = users.stream().map(user -> {
        //    user.setName("ZhangSan");
        //    return user;
        //}).collect(Collectors.toList());
        //zhangSan.forEach(System.out::println);

        users.forEach(System.out::println);
        System.out.println(users.size());
    }
}

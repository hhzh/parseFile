package com.test;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        //List<User> users = new ArrayList<>();
        //users.add(new User(1));
        //users.add(new User(22));
        //users.add(new User(5));
        //users.forEach(user -> user.setName("ZhangSan"));
        //List<User> zhangSan = users.stream().map(user -> {
        //    user.setName("ZhangSan");
        //    return user;
        //}).collect(Collectors.toList());
        //zhangSan.forEach(System.out::println);

        //users.forEach(System.out::println);
        //System.out.println(users.size());

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Tony", "BeiJing", 20));
        users.add(new User(5, "Kevin", "ShangHai", 18));
        users.add(new User(6, "Alan", "ShangHai", 22));
        users.add(new User(3, "Hugo", "BeiJing", 19));
        users.add(new User(9, "Martin","BeiJing", 39));

        //users = users.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());

        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getCity));
        collect.forEach((k,v)-> System.out.println(k+"="+v));

        //users.forEach(System.out::println);

        //Map<String, String> map = new HashMap<>();
        //map.put("1,", "v1");
        //map.put("2", "v2");
    }
}

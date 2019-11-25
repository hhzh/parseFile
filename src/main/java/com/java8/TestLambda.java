package com.java8;

import com.test.User;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;


public class TestLambda {

    public static void main(String[] args) {
        //List<Integer> integers = Arrays.asList(1, 2, 3);
        //integers=integers.stream().limit(5).collect(Collectors.toList());
        ////integers=integers.subList(0,5);
        //integers.forEach(System.out::println);
        //
        //List<String> keys = Arrays.asList("key1", "key2", "key3");
        //keys.forEach(System.out::println);

        //Date date = new Date(1529374810000L);
        //System.out.println(date);
        //date=new Date(1529394762000L);
        //System.out.println(date);

        int result = 100;
        int num = 0;
        for (int i = 0; i < 10000; i++) {
            num++;
            result -= 2 * num;
            boolean nextBoolean = new Random().nextBoolean();
            if (nextBoolean) {
                result += 4 * num;
                num = 0;
            }
            System.out.println(result);
        }

        //String btc = "btc";
        //System.out.print("mkdir");
        //for (int i = 1; i <= 1000; i++) {
        //    System.out.print(" "+btc+i);
        //}
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //LocalDateTime start = LocalDateTime.parse("2018-01-01 00:00:00", format);
        //LocalDateTime end = LocalDateTime.parse("2019-01-01 00:00:00", format);
        //LocalDateTime temp = start;
        //while (temp.isBefore(end)) {
        //    System.out.println(temp);
        //    temp = temp.plusMinutes(1);
        //}

        //System.out.println(start);
        //System.out.println(start.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        //
        //System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(1514736000000L),ZoneId.of("Asia/Shanghai")));
        //LocalDateTime now = LocalDateTime.now();
        //System.out.println(now);
        //System.out.println(now.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        //System.out.println(now.getDayOfWeek());
        //System.out.println(now.getDayOfYear());
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
        //LocalDateTime localDateTime = LocalDateTime.parse("2018-07-02-12:12", format);
        //System.out.println(localDateTime);
        //System.out.println(localDateTime.format(format));
        //LocalDate parse = LocalDate.parse("20180702", DateTimeFormatter.BASIC_ISO_DATE);
        //System.out.println(parse);

        //List<Integer> users = new ArrayList<>();
        //for (Integer user : users) {
        //    System.out.println(user);
        //}

        //System.out.println((char) 129);//15293748100000.01.02.03.04.00.0;
        //
        //List<Integer> list = new ArrayList<>();
        //for (int i = 0; i < 10; i++) {
        //    list.add(i);
        //}
        //if (list.size() > 8) {
        //    list = list.subList(list.size() - 8, list.size());
        //}
        //System.out.println(list);

        //List<String[]> list = new ArrayList<>();
        //list.add(new String[]{"aa","bb","cc"});
        //String[] strings1 = list.get(0);
        //for (String s : strings1) {
        //    System.out.println(s);
        //}
        //System.out.println("----");
        //String[] strings = list.get(0);
        //strings[2]="dd";
        //for (String string : strings) {
        //    System.out.println(string);
        //}
        //System.out.println("----");
        //String[] strings2 = list.get(0);
        //for (String s : strings2) {
        //    System.out.println(s);
        //}

        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //Executors.newCachedThreadPool();
        //Executors.newFixedThreadPool(3);
        //Executors.newScheduledThreadPool(3);


        //List<Integer> list = new ArrayList<>();
        //list.add(3);
        //list.add(9);
        //list.add(5);
        //list.add(8);
        //
        //list.sort(Comparator.naturalOrder());
        //
        //for (Integer integer : list) {
        //    System.out.println(integer);
        //}

        //List<Integer> inList = filter(list, (Integer i) -> i > 4);

        //List<User> users = new ArrayList<>();
        //for (int i = 2; i < 5; i++) {
        //    User user = new User();
        //    user.setId(i);
        //    user.setName("name"+i);
        //    users.add(user);
        //}
        //
        //users.add(new User(9,"kk"));
        //users.add(new User(1,"kk"));
        //
        //Integer integer = users.stream().map(User::getId).max(Comparator.naturalOrder()).orElse(0);
        //System.out.println(integer);

        //LocalDateTime now = LocalDateTime.now();
        //System.out.println(now.getMinute());
        //
        //System.out.println(new Date().getMinutes());
        //System.out.println(Double.NaN);
        //double dd=0;
        //System.out.println(dd);

    }
}

//{"code":0,"data":[{"high":717.0621,"usdCnyRate":6.423,"indexType":10001,"last":"702.0531","low":650.8535,"indexName":"OK05","changePercent":5.467,"indexCode":"OK5","open":665.6614389},],"detailMsg":"","msg":""}
//
//        {"high":966.4176,"usdCnyRate":6.423,"indexType":10002,"last":"945.9940","low":874.8372,"indexName":"OK06","changePercent":5.7591,"indexCode":"OKX","open":894.48000484}

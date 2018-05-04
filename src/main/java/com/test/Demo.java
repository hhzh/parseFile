package com.test;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        //List<User> list = new ArrayList<User>();
        //User user = new User();
        //user.setName("zhangsan");
        //list.add(user);
        //list.add(null);
        //User user1 = new User();
        //user1.setName("lisi");
        //list.add(user1);
        //list.add(null);
        //
        //for (User user2 : list) {
        //    System.out.println(user2);
        //}

        //System.out.println(Runtime.getRuntime().availableProcessors());

        //for (int i = 1; i < 10001; i++) {
        //    System.out.println("D:/imgtest/img/" + i + ".jpg");
        //}
        //String name = "cropImg2.jpg";
        //System.out.println(name.substring(name.lastIndexOf(".") + 1));
        //String ab = "ab";
        //String a = "a";
        //String b = "b";
        //String abObj = new String("ab");
        //String abbb = "a" + b;
        //System.out.println(ab.equals(abbb));
        //System.out.println(ab.equals(abObj));
        //System.out.println(ab == abbb);
        //System.out.println(ab == abObj);
        //Object obj = new Object();

        String temp1 = "a";
        String temp2 = "b";
        String temp3 = "ab";
        String temp4 = "a" + "b";
        String temp5 = temp1 + temp2;
        System.out.println(temp3 == temp4);
        System.out.println(temp3 == temp5);

        //String groupPath = "group1/M00/01/3A/cnBodVq5wq-AYi7yACttOcwyD8c864.jpg";
        //System.out.println(groupPath.substring(0, groupPath.indexOf("/")));
        //System.out.println(groupPath.substring(groupPath.indexOf("/") + 1));

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date date = new Date();
        //System.out.println(date);
        //System.out.println(sdf.format(date));

        //LocalDate now = LocalDate.now();
        //System.out.println(now);
        //LocalDateTime now1 = LocalDateTime.now();
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss");
        //System.out.println(now1);
        //String format = dateTimeFormatter.format(now1);
        //System.out.println(format);
        //LocalDateTime localDateTime = now1.minusMinutes(3);
        //System.out.println(localDateTime);

        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        //LocalDateTime now = LocalDateTime.now();
        //LocalDateTime localDateTime = now.minusMinutes(3);
        //String formatDate = dateTimeFormatter.format(localDateTime);
        //System.out.println(formatDate);

        //Map[] arr = new HashMap[10];
        //Map<String, String> map = new HashMap<>();
        //map.put("key1", "value1");
        //arr[0] = map;
        //for (Map stringStringMap : arr) {
        //    System.out.println(stringStringMap);
        //}

        //System.out.println(new Date().getTime());
        //String str = "中文字幕到底到";
        //System.out.println(getMD5(str));
        //System.out.println(getMD52(str));
        //
        //new Thread(() -> {
        //
        //}).start();

    }

    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes("UTF-8"));
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5 = new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:" + e.getMessage(), e);
        }
    }

    public static String getMD52(String str) {
        MessageDigest digester = null;
        try {
            digester = MessageDigest.getInstance("MD5");
            ByteBuffer b = ByteBuffer.wrap(digester.digest(str.getBytes("gbk"))).order(ByteOrder.BIG_ENDIAN);
            String sign = new StringBuilder().append(Long.toHexString(b.getLong())).append(Long.toHexString(b.getLong())).toString();
            return sign;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String fillMD5(String md5) {
        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }
}

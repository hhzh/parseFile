package com.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestString {

    public static void main(String[] args) {
        //String businessCode = "0101010101";
        //String cityCode = businessCode.substring(0, 6);
        //System.out.println(cityCode);

        //String res = "nullnull看到nullnull";
        //System.out.println(removeEndNullString(res));

        //String str="刊bac";
        //byte[] bytes = str.getBytes();
        //System.out.println(bytes.toString());
        //System.out.println(new String(bytes));

        //String content = "{\"text\":\"薛泳回答了您的专家咨询.\",\"type\":1,\"consultid\":210,\"answerid\":45}";
        //content = content.substring(1, content.length() - 1);
        //String[] split = content.split(",");
        //for (String s : split) {
        //    String[] split1 = s.split(":");
        //    for (int i = 0; i < split1.length; i++) {
        //        if (split1[i].contains("\"")) {
        //            split1[i] = split1[i].substring(1, split1[i].length() - 1);
        //        }
        //    }
        //    for (String s1 : split1) {
        //        System.out.println(s1);
        //    }
        //    System.out.println();
        //}
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //list.add(6);
        //list.add(7);
        //String ids = "";
        //for (Integer integer : list) {
        //    ids += integer + ",";
        //}
        //System.out.println(ids);
        //System.out.println(ids.substring(0, ids.length() - 1));

        //String aa = "23423";
        //String[] split = aa.split(",");
        //System.out.println(split.length);
        //for (String s : split) {
        //    System.out.println(s);
        //}
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

    private static String removeNullString(String note) {
        if (note != null && note.startsWith("null")) {
            note = note.substring(note.indexOf("null") + 4);
            note = removeNullString(note);
        }
        return note;
    }

    private static String removeEndNullString(String note) {
        if (note != null && note.endsWith("null")) {
            note = note.substring(0, note.lastIndexOf("null"));
            note = removeEndNullString(note);
        }
        return note;
    }
}

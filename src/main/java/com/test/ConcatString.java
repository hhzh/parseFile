package com.test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;

public class ConcatString {

    public static void main(String[] args) {
        //String str = "begin";
        //Date date = new Date();
        //String[] arr = {"aa", "bb", "cc", "dd"};
        //str = String.join(",", arr);
        //System.out.println(String.join(",", arr));
        //BigDecimal amount = new BigDecimal(23);
        //System.out.println(str + date + amount);

        //System.out.println(String.format("%0"+8+"d",88));

        System.out.println("中文".getBytes());
        try {
            System.out.println("中文".getBytes("gbk"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

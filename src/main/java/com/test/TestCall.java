package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCall {

    static int temp=1;
    public static void main(String[] args) {
        TestCall tc=new TestCall();
        //List<String> list = new ArrayList<String>();
        //list.add("a");
        //tc.function(list);
        //for (String s : list) {
        //    System.out.print(s+"--");
        //}

        //String[] arr=new String[3];
        //arr[0] = "a";
        //tc.function2(arr);
        //for (String s : arr) {
        //    System.out.print(s+"--");
        //}

        //String str = "aaa";
        //tc.function3(str);
        //System.out.println(str);

        //Integer temp=new Integer(123);
        //tc.function6(temp);
        //System.out.println(temp);


        //Date date=new Date("2016-11-01");
        //tc.function5(date);
        //System.out.println(date.getTime());

        //User user = new User();
        //user.setId(10);
        //tc.function7(user);
        //System.out.println(user.getId());
        //System.out.println(user.getName());


        //tc.function8(tc.temp);
        //System.out.println(tc.temp);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
    }

    public void function(List<String> list) {
        list.add("test");
    }

    public void function2(String[] arr) {
        arr[0] = "test";
    }

    public void function3(String str) {
        str = "bbb";
    }

    public void function4(Integer temp) {
        temp = new Integer(321);
    }

    public void function5(Date temp) {
        temp = new Date("2016-11-02");
    }

    public void function6(Integer temp) {
        temp ++;
    }

    public void function7(User user) {
        user.setId(11);
        user.setName("ZHNAGsan");
    }

    public void function8(int temp) {
        temp =temp+1;
    }

    public void function8(List<Integer> list) {
        //list.get(0)=list.get(0)+1;
    }

}

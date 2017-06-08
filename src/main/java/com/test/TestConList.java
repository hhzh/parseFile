package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestConList {
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<Integer>();

        //List<Integer> list = new CopyOnWriteArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(5);
        list1.add(1);
        list1.add(3);
        list1.add(8);
        list1.add(7);

        //List<Integer> list = list1.subList(1, list1.size());
        //System.out.println(list);
        //if (list1.contains(3)) {
        //    System.out.println("hh");
        //} else {
        //    System.out.println("bbb");
        //}
        //list.addAll(list1);
        //list.add(6);
        //list.add(2);
        //list.add(7);
        //for (Integer integer : list) {
        //    if (integer == 6) {
        //        list.remove(integer);
        //    }
        //}
        //for (Integer integer : list) {
        //    System.out.println(integer);
        //}

        List<Integer> tempList = new ArrayList<Integer>();
        tempList.add(5);
        tempList.add(8);
        //for (Integer integer : list1) {
        //    if (integer == 3) {
        //        tempList.remove(integer);
        //    }
        //}

        list1.removeAll(tempList);

        for (Integer integer : list1) {
            System.out.println(integer);
        }
    }
}

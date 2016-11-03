package com.testTreeSet;

import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new OrderNumberComparator());//降序
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(39);
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }
}

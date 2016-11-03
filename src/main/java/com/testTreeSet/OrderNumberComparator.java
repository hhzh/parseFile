package com.testTreeSet;

import java.util.Comparator;

public class OrderNumberComparator implements Comparator<Integer> {

    //@Override
    public int compare(Integer orderNumber1, Integer orderNumber2) {
        if (orderNumber1 > orderNumber2) {
            return -1;
        } else if (orderNumber1 < orderNumber2) {
            return 1;
        } else {
            return 0;
        }
    }

}

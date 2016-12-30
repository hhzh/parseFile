package com.test;

import java.math.BigDecimal;
import java.util.*;

public class TestBigd {
    public static void main(String[] args) {
        //BigDecimal a = BigDecimal.ZERO;
        ////a = a.add(new BigDecimal(3));
        //System.out.println(a);
        //int bo=a.compareTo(new BigDecimal(0));
      //System.out.println();

        //String mm = "-33";
        //Integer res = Integer.parseInt(mm);
        //Integer a=-1;
        //System.out.println(res);

        //BigDecimal ab=new BigDecimal("1000");
        //BigDecimal ac = new BigDecimal("200");
        //BigDecimal ad = new BigDecimal("303");
        //BigDecimal res=ab.subtract(ac).subtract(ad);
        //System.out.println(res);

        //List<String>employee=new ArrayList<String>();
        //employee.add("add");
        //System.out.println(employee.get(0));

        //BigDecimal ab = new BigDecimal(3815.123);
        //BigDecimal re=ab.divide(new BigDecimal("1000"),3,BigDecimal.ROUND_CEILING);
        //re = re.subtract(new BigDecimal(3));
        //re=re.setScale(0,BigDecimal.ROUND_DOWN);
        //System.out.println(re);

        BigDecimal ab = new BigDecimal(5);
        ab = ab.add(ab.subtract(new BigDecimal(2)).multiply(new BigDecimal(2)));
        System.out.println(ab);
    }
}

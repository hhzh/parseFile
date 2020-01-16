package com.parsetxt;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CalBill {

    public static void main(String[] args) throws Exception {
        //final File file = new File("demo.txt");
        //System.out.println(file.getAbsolutePath());
        new CalBill().generateEntity("demo.txt");
    }

    public void generateEntity(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        Map<String, BigDecimal> map = new HashMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            final String[] split = line.split(",");
            final BigDecimal decimal = map.get(split[0]);
            if (decimal == null) {
                map.put(split[0], new BigDecimal(split[1]));
            } else {
                map.put(split[0], map.get(decimal.add(new BigDecimal(split[1]))));
            }
        }
        bufferedReader.close();
        System.out.println(JSON.toJSON(map));
        BufferedWriter writer = new BufferedWriter(new FileWriter( "export_bill.csv"));
        for (Map.Entry<String, BigDecimal> stringBigDecimalEntry : map.entrySet()) {
            System.out.println(stringBigDecimalEntry.getKey()+","+stringBigDecimalEntry.getValue());
            writer.write(stringBigDecimalEntry.getKey()+","+stringBigDecimalEntry.getValue());
            writer.write("\n");
        }
        writer.close();

    }
}

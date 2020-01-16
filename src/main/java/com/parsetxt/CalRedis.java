package com.parsetxt;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalRedis {

    public static void main(String[] args) throws Exception {
        new CalRedis().generateEntity("demo.txt");
    }

    public void generateEntity(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        String btc = "hset PERPETUAL_SIMULA_CONTRACT_80";
        String eth = "hset PERPETUAL_SIMULA_CONTRACT_82";
        String eos = "hset PERPETUAL_SIMULA_CONTRACT_86";
        while ((line = bufferedReader.readLine()) != null) {
            final String[] split = line.split(",");
            if (split[1].equals("80")) {
                btc = btc + " " + split[0] + " " + "\"" + split[2] + "\"";
            } else if (split[1].equals("82")) {
                eth = eth + " " + split[0] + " " + "\"" + split[2] + "\"";
            } else if (split[1].equals("86")) {
                eos = eos + " " + split[0] + " " + "\"" + split[2] + "\"";
            }
        }
        System.out.println(btc);
        System.out.println(eth);
        System.out.println(eos);
        bufferedReader.close();

    }
}

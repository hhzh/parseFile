package com.parsetxt;

import com.alibaba.fastjson.JSON;
import com.util.DateUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParseTxt {

    public static void main(String[] args) throws Exception {
        //new ParseTxt().generateEntity("/Users/oker/Downloads/ods_transaction_okex_pp_markprice_usdt/ods_transaction_okex_pp_markprice_usdt_20191216.csv");
        //new ParseTxt().generateEntity("/Users/oker/Downloads/ods_transaction_okex_pp_markprice_usdt/ods_transaction_okex_pp_markprice_usdt_20191217.csv");
        //new ParseTxt().generateEntity("/Users/oker/Downloads/ods_transaction_okex_pp_markprice_usdt/ods_transaction_okex_pp_markprice_usdt_20191218.csv");
        new ParseTxt().generateEntity("/Users/oker/Downloads/ods_transaction_okex_pp_markprice_usdt/ods_transaction_okex_pp_markprice_usdt_20191219.csv");
    }

    private void generateEntity(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int n = 0;
        List<MarkPrice> markPrices = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            n++;
            if (n == 1) {
                continue;
            }
            final String[] split = line.split(",");
            //System.out.println(split[13]+"---"+split[16]);
            markPrices.add(new MarkPrice(Integer.valueOf(split[13]), DateUtil.getDateByString(split[16])));
        }
        bufferedReader.close();

        if (CollectionUtils.isNotEmpty(markPrices)) {
            for (int i = 0; i < markPrices.size() - 1; i++) {
                if (markPrices.get(i).getSide() == 23 && markPrices.get(i + 1).getSide() != 23) {
                    System.out.println(JSON.toJSONString(markPrices.get(i)) + "----" + JSON.toJSONString(markPrices.get(i + 1)));
                }
            }
        }

    }
}

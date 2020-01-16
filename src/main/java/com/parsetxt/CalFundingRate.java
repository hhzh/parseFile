package com.parsetxt;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalFundingRate {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("btc_mark_price.csv")));
            BufferedWriter writer = new BufferedWriter(new FileWriter("btc_funding_rate.csv"));

            String line;
            BigDecimal fundingRate = BigDecimal.ZERO;
            BigDecimal sum = BigDecimal.ZERO;
            int n = 0;
            writer.write("n,futureMid,index,X,fundingFee,create_time");
            writer.write("\n");
            while ((line = bufferedReader.readLine()) != null) {
                n++;
                if (n == 1) {
                    continue;
                }
                final String[] split = line.split(",");
                final BigDecimal spotIndexPrice = new BigDecimal(split[5].replace("\"", ""));
                final BigDecimal bestBid = new BigDecimal(split[6].replace("\"", ""));
                final BigDecimal bestAsk = new BigDecimal(split[7].replace("\"", ""));
                final BigDecimal futureMid = bestBid.add(bestAsk).divide(new BigDecimal("2"), 16, RoundingMode.FLOOR);
                sum = futureMid.subtract(spotIndexPrice).divide(spotIndexPrice, 16, RoundingMode.FLOOR).add(sum);
                fundingRate = sum.divide(new BigDecimal(n), 16, RoundingMode.FLOOR);
                if (fundingRate.compareTo(new BigDecimal("-0.3")) < 0) {
                    fundingRate = new BigDecimal("-0.3");
                }
                if (fundingRate.compareTo(new BigDecimal("0.3")) > 0) {
                    fundingRate = new BigDecimal("0.3");
                }
                System.out.println(n + "," + futureMid.stripTrailingZeros().toPlainString() + "," + spotIndexPrice.stripTrailingZeros().toPlainString() + "," + sum.stripTrailingZeros().toPlainString() + "," + fundingRate.setScale(5, RoundingMode.FLOOR) + "," + split[16]);
                writer.write(n + "," + futureMid.stripTrailingZeros().toPlainString() + "," + spotIndexPrice.stripTrailingZeros().toPlainString() + "," + sum.stripTrailingZeros().toPlainString() + "," + fundingRate.setScale(5, RoundingMode.FLOOR) + "," + split[16]);
                writer.write("\n");
            }
            bufferedReader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.parsetxt;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalFundingFee {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("etc_user_contract.csv")));
            BufferedWriter writer = new BufferedWriter(new FileWriter("etc_fee.csv"));

            String line;
            BigDecimal fundingRate = BigDecimal.ZERO;
            BigDecimal sum = BigDecimal.ZERO;
            int n = 1;
            writer.write("user_id,long_pos_pty,short_pos_qty,mark_price,fee,real_fee");
            writer.write("\n");
            BigDecimal total1 = BigDecimal.ZERO;
            BigDecimal total2 = BigDecimal.ZERO;
            BigDecimal markPrice = new BigDecimal("3.8738065650709257");
            while ((line = bufferedReader.readLine()) != null) {
                n++;
                if (n == 2) {
                    continue;
                }
                final String[] split = line.split(",");
                final BigDecimal longPosQty = new BigDecimal(split[1].replace("\"", ""));
                final BigDecimal shortPosQty = new BigDecimal(split[2].replace("\"", ""));
                String result;
                final BigDecimal fee = shortPosQty.subtract(longPosQty).multiply(new BigDecimal("10"))
                        .divide(markPrice, 16, RoundingMode.FLOOR)
                        .multiply(new BigDecimal("0.0006"));
                result = split[0] + "," + longPosQty.stripTrailingZeros().toPlainString() + ","
                        + shortPosQty.stripTrailingZeros().toPlainString() + ","
                        + markPrice.stripTrailingZeros().toPlainString() + ","
                        + fee.stripTrailingZeros().toPlainString() + ","
                        + split[3];
                if (fee.compareTo(BigDecimal.ZERO) > 0) {
                    total1 = total1.add(fee);
                } else {
                    total2 = total2.add(fee);
                }
                System.out.println(result);
                writer.write(result);
                writer.write("\n");
                //n++;
            }
            writer.write("receive=" + total1.stripTrailingZeros().toPlainString());
            writer.write("\n");
            writer.write("pay=" + total2.stripTrailingZeros().toPlainString());
            System.out.println("total1=" + total1.stripTrailingZeros().toPlainString());
            System.out.println("total2=" + total2.stripTrailingZeros().toPlainString());
            bufferedReader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

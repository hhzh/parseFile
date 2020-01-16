package com.parsetxt;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GenerateRiskConfig {

    public static void main(String[] args) throws Exception {
        new GenerateRiskConfig().generateEntity("demo.txt");
    }

    private void generateEntity(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] split = line.split(",");
            long contractId = Long.valueOf(split[0]);
            BigDecimal baseAmount = new BigDecimal(split[1]);
            BigDecimal ladderAmount = new BigDecimal(split[2]);
            BigDecimal positionRateBase = new BigDecimal(split[3]);
            BigDecimal marginRate = new BigDecimal(split[4]);
            System.out.println(split[0] + split[1] + split[2] + split[3] + split[4]);
            BufferedWriter writer = new BufferedWriter(new FileWriter("insert_risk_config_"+split[0] + ".sql"));
            writer.write("insert into pp_risk_config_" + contractId + " (`id`, `coin_id`, `contract_id`, `min_amount`, `max_amount`, `position_margin_rate`, `liquidate_margin_rate`, `max_lever_open_margin_rate`, `max_lever_rate`, `create_time`, `modify_time`) values ");
            writer.write("\n");
            BigDecimal minAmount = BigDecimal.ZERO;
            BigDecimal maxAmount = BigDecimal.ZERO;
            for (int i = 1; i < 100000; i++) {
                if (i == 1) {
                    minAmount = BigDecimal.ZERO;
                    maxAmount = baseAmount;
                } else {
                    minAmount = maxAmount.add(BigDecimal.ONE);
                    maxAmount = maxAmount.add(ladderAmount);
                }
                BigDecimal basePositionRate = positionRateBase.add(new BigDecimal("0.005").multiply(new BigDecimal(i - 1))).setScale(8, RoundingMode.FLOOR).stripTrailingZeros();
                BigDecimal baseMargeRate = marginRate.add(new BigDecimal("0.005").multiply(new BigDecimal(i - 1))).setScale(8, RoundingMode.FLOOR).stripTrailingZeros();
                writer.write("(" + i + ",7," + contractId + "," + minAmount + "," + maxAmount + ","
                        + basePositionRate + "," + basePositionRate.add(new BigDecimal("0.03")).setScale(8, RoundingMode.FLOOR).stripTrailingZeros()
                        + "," + baseMargeRate + "," + BigDecimal.ONE.divide(baseMargeRate, 2, RoundingMode.FLOOR).stripTrailingZeros().toPlainString()
                        + ",now(),now())"
                );
                if (baseMargeRate.compareTo(new BigDecimal("0.5")) >= 0) {
                    writer.write(";");
                    break;
                } else {
                    writer.write(",");
                    writer.write("\n");
                }
            }
            writer.close();
        }
        bufferedReader.close();


    }
}

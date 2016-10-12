package com.parsetxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AutoGenerateEntity {

    public static void main(String[] args) throws Exception {
        new AutoGenerateEntity().generateEntity("d:/test.txt");
    }

    public void generateEntity(String fileName) throws Exception {
        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line=line.trim();
            line=line.substring(line.indexOf('`')+1,line.indexOf(' '));
            if (line.contains("_")) {
                line=line.substring(0,line.indexOf('_'))+line.substring(line.indexOf('_')+1,1).toUpperCase()+line.substring(line.indexOf('_')+2,line.indexOf('`'));
            }
            System.out.println(line);
        }

        bufferedReader.close();
    }
}

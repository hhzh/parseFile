package com.parsetxt;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * author: ruite.wang
 * date: 2019-12-17 10:49
 */
public class FindLogUtil {

    private static final List<String> Paths = new ArrayList<>();

    private static final String FilePathNamePrefix = "perpetual-";

    private static final String TargetFilePath = "/Users/oker/Documents/log/error/";
    //private static final String TargetFilePath = "/Users/oker/log/info/";

    private static final String LogName = "log.error";

    static {

        //模块java路径
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-api/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-common/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-dao/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-data/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-domain/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-dto/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-dts/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-exchange/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-rest/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-risk/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-service/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-task/src/main/java");
        Paths.add("/Users/oker/Documents/okcoin-perpetual/perpetual-trade/src/main/java");

    }

    public static void main(final String[] args) {
        Paths.forEach(e -> {
             final List<String> errorList = new ArrayList<>();

             getFileNames(e).stream()
                            .filter(k -> Optional.ofNullable(k).isPresent())
                            .filter(k -> k.endsWith("java"))
                            .forEach(k -> errorList.addAll(readLines(k)));

             final String nameSufix = getFilePathName(e);
            try {
                writeFile(errorList,TargetFilePath+nameSufix+"_"+LogName+".txt");
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        });
    }


    private static List<String> readLines(final String filePath){

        final ArrayList<String> arrayList = new ArrayList<>();
        try {
            final String namePrex = getLastFileName(filePath);
            final File file = new File(filePath);
            final InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            final BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            long line = 0;
            while ((str = bf.readLine()) != null) {
                line++;
                if(str.contains(LogName)){
                    arrayList.add("name = "+namePrex+",line = "+line+"\n");
                }

            }
            bf.close();
            inputReader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return arrayList;

    }


    private static String getLastFileName(final String path){
       return Optional.ofNullable(path).map(e -> {
            String[] split = e.split("/");
            return split[split.length -1];
        }).orElse(null);
    }




    private static String getFilePathName(final String path){
         return Optional.ofNullable(path)
                .map(e -> Arrays.stream(e.split("/")))
                .flatMap(e -> e.filter(k -> k.contains(FilePathNamePrefix)).findFirst())
                .orElse(null);

    }


    private  static void writeFile(final List<String> lines , final String filePathName) throws Exception{

        final File file =new File(filePathName);
        if(!file.exists()){
            final boolean newFile = file.createNewFile();
        }
        final FileWriter fileWritter = new FileWriter(file.getAbsoluteFile(),true);

        final BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

        lines.forEach(e ->{
            try {
                bufferWritter.write(e);
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        });

        bufferWritter.close();
        fileWritter.close();

    }


    private static List<String> getFileNames(final String path){
        final List<String> list = new ArrayList<>();
        final File file = new File(path);
        final File[] files = file.listFiles();
        for (final File file1 : files) {
            if(file1.isFile()){
                list.add(file1.getAbsolutePath());
            }else{
                list.addAll(getFileNames(file1.getPath()));
            }
        }
        return list;
    }









}

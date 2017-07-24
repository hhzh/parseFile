package com.parseExcel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiExcel {
    public static void main(String[] args) {
        //writeExcel();
        //writeExcel2();
        readExcel();
    }

    public static void writeExcel() {
        String[] title = {"id", "name", "sex"};

        //创建Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建一个工作表sheet
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;
        //插入第一行数据 id,name,sex
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //追加数据
        for (int i = 1; i <= 10; i++) {
            HSSFRow nextRow = sheet.createRow(i);
            cell = nextRow.createCell(0);
            cell.setCellValue("a" + i);
            cell = nextRow.createCell(1);
            cell.setCellValue("user" + i);
            cell = nextRow.createCell(2);
            cell.setCellValue("男");
        }
        //创建一个文件
        File file = new File("e:/poi_test.xls");
        try {
            file.createNewFile();
            //将Excel内容存盘
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeExcel2() {
        String[] title = {"id", "name", "sex"};

        //创建Excel工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个工作表sheet
        Sheet sheet = workbook.createSheet();
        //创建第一行
        Row row = sheet.createRow(0);
        Cell cell = null;
        //插入第一行数据 id,name,sex
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //追加数据
        for (int i = 1; i <= 10; i++) {
            Row nextRow = sheet.createRow(i);
            cell = nextRow.createCell(0);
            cell.setCellValue("a" + i);
            cell = nextRow.createCell(1);
            cell.setCellValue("user" + i);
            cell = nextRow.createCell(2);
            cell.setCellValue("男");
        }
        //创建一个文件
        File file = new File("e:/poi_test2.xlsx");
        try {
            file.createNewFile();
            //将Excel内容存盘
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExcel() {
        //需要解析的Excel文件
        File file = new File("e:/poi_test.xls");
        try {
            //创建Excel，读取文件内容
            HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
            //获取第一个工作表workbook.getSheet("Sheet0");
//			HSSFSheet sheet = workbook.getSheet("Sheet0");
            //读取默认第一个工作表sheet
            HSSFSheet sheet = workbook.getSheetAt(0);
            int firstRowNum = 0;
            //获取sheet中最后一行行号
            int lastRowNum = sheet.getLastRowNum();
            for (int i = firstRowNum; i <= lastRowNum; i++) {
                HSSFRow row = sheet.getRow(i);
                //获取当前行最后单元格列号
                int lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j++) {
                    HSSFCell cell = row.getCell(j);
                    String value = cell.getStringCellValue();
                    System.out.print(value + "\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

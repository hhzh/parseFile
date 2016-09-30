package com.parseExcel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Readshbj {

    public static void main(String[] args) throws IOException {
        new Readshbj().resdSHBJ();
    }

    public void resdSHBJ() throws IOException {
        File file = new File("d:/shbj.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
        XSSFSheet sheet = workbook.getSheetAt(0);

        String result = "(";

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            XSSFCell gridIdCell=row.getCell(0);

            String gridIdString=getStringCellValue(gridIdCell);
            int gridId=(int)Double.parseDouble(gridIdString);

            result=result+"'"+gridId+"',";
        }
        result = result.substring(0, result.length() - 1) + ")";
        System.out.println(result);
    }

    private String getStringCellValue(XSSFCell cell) {
        String strCell = null;
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;

            case XSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;

            case XSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;

            case XSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;

            default:
                strCell = "";
                break;
        }

        return strCell;
    }
}

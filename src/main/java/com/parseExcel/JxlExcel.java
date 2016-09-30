package com.parseExcel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;

public class JxlExcel {
	public static void main(String[] args) {
		writeExcel();
//		readExcel();
	}
	
	public static void writeExcel(){
		String[] title={"id","name","sex"};
		File file=new File("E:/test.xlsx");
		try {
			file.createNewFile();
			//����������
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			//����sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			//��һ����������
			for (int i = 0; i < title.length; i++) {
				label = new Label(i,0,title[i]);
				sheet.addCell(label);	
			}
			//׷������
			for (int i = 1; i < 10; i++) {
				label = new Label(0,i,"a" + 1);
				sheet.addCell(label);
				label = new Label(1,i,"user" + i);
				sheet.addCell(label);
				label = new Label(2,i,"��");
				sheet.addCell(label);
			}
			//д������
			workbook.write();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	public static void readExcel(){
		try {
			//����workbook
			Workbook workbook = Workbook.getWorkbook(new File("e:/jxl_test.xls"));
			//��ȡ��һ��������sheet
			Sheet sheet = workbook.getSheet(0);
			//��ȡ����
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j,i);
					System.out.print(cell.getContents() + "  ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

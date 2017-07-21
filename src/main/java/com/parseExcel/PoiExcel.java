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
//		writeExcel();
//		writeExcel2();
//		readExcel();
	}
	
	public static void writeExcel(){
		String[] title = {"id","name","sex"};
		
		//����Excel������
		HSSFWorkbook workbook = new HSSFWorkbook();
		//����һ��������sheet
		HSSFSheet sheet = workbook.createSheet();
		//������һ��
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		//�����һ������ id,name,sex
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//׷������
		for (int i = 1; i <= 10; i++) {
			HSSFRow nextrow = sheet.createRow(i);
			HSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue("a" + i);
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user" + i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("��");
		}
		//����һ���ļ�
		File file = new File("e:/poi_test.xls");
		try {
			file.createNewFile();
			//��Excel���ݴ���
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeExcel2(){
		String[] title = {"id","name","sex"};
		
		//����Excel������
		XSSFWorkbook workbook = new XSSFWorkbook();
		//����һ��������sheet
		Sheet sheet = workbook.createSheet();
		//������һ��
		Row row = sheet.createRow(0);
		Cell cell = null;
		//�����һ������ id,name,sex
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//׷������
		for (int i = 1; i <= 10; i++) {
			Row nextrow = sheet.createRow(i);
			Cell cell2 = nextrow.createCell(0);
			cell2.setCellValue("a" + i);
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user" + i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("��");
		}
		//����һ���ļ�
		File file = new File("e:/poi_test2.xlsx");
		try {
			file.createNewFile();
			//��Excel���ݴ���
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readExcel(){
		// ��Ҫ������Excel�ļ�
		File file = new File("e:/poi_test.xls");
		try {
			// ����Excel����ȡ�ļ�����
			HSSFWorkbook workbook = new HSSFWorkbook(
					FileUtils.openInputStream(file));
			// ��ȡ��һ��������workbook.getSheet("Sheet0");
			// HSSFSheet sheet = workbook.getSheet("Sheet0");
			// ��ȡĬ�ϵ�һ��������sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			int firstRowNum = 0;
			// ��ȡsheet�����һ���к�
			int lastRowNum = sheet.getLastRowNum();
			for (int i = firstRowNum; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);
				// ��ȡ��ǰ�����Ԫ���к�
				int lastCellNum = row.getLastCellNum();
				for (int j = 0; j < lastCellNum; j++) {
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value + "  ");
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package org.mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void main(String[] args) throws Exception {
		File excel=new File("D:\\Users\\Vasan\\eclipse-workspace\\Maven16\\Files\\TestCaseData.xlsx");
		
		Workbook book=new XSSFWorkbook();
		
		Sheet sheet = book.createSheet("LogIn");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("UserName");
		
		Row row2 = sheet.createRow(1);
		Cell cell2 = row2.createCell(0);
		cell2.setCellValue("Srinivasan");
		
		FileOutputStream save=new FileOutputStream(excel);
		book.write(save);
		
		System.out.println("Sheet is Successfully Created");
		
			}
		
		
	

}

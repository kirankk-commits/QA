package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {
	static FileReaderManager fileReader; 
		
	public static String readParticularData(int rowValue,int columValue) {
		String formatCellValue = null;
		try {
			File file = new File(fileReader.getDataProperty("excelpath"));
			Workbook workbook  = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("DATA");
			Row row = sheet.getRow(rowValue);
			Cell cell = row.getCell(columValue);
			DataFormatter dataFormatter = new DataFormatter ();
		    formatCellValue = dataFormatter.formatCellValue(cell);
			System.out.println("particulat cell value:" + formatCellValue);	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return formatCellValue;
		
		
	}
	
	public static void main(String[] args) throws InvalidFormatException,IOException {
		//readParticularData() ; 
	}

	public static Object[][] getExcelData(String filepath, String sheetName) {
		// TODO Auto-generated method stub
		return null;
	}

}

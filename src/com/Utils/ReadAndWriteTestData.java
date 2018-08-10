package com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadAndWriteTestData {
	
		
	
	@SuppressWarnings({ "resource" })
	
	public void getCellData() throws InvalidFormatException, IOException{
		
		
		String home = System.getProperty("user.dir");
		
		File file = new File(home+"/TestData/ipi-path-urls.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet s  = wb.getSheetAt(0);
		
//		Workbook wb = new XSSFWorkbook(fis);
//		
//		Sheet s = wb.getSheet("URLs-for-Removal");
		
		int rowCount = s.getLastRowNum() - s.getFirstRowNum();
		
		System.out.println(rowCount);
		
		
		for (int i = 1; i < rowCount+1; i++) {
			
			Row row = s.getRow(i);
			
			Cell cell  = row.getCell(0);
			
			String CellUrl = cell.getStringCellValue();
			
			System.out.println(CellUrl);
			
			
		}

				
	}
	
	public static void main(String agrs[]) throws InvalidFormatException, IOException{
		
		ReadAndWriteTestData objectFile = new ReadAndWriteTestData();
		
		objectFile.getCellData();
		
	
		
	}

}

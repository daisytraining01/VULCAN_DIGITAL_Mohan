

package com.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;

	
	public static Object[][]getTestData(String SheetPath, String sheetName){
		
		//used to create connection to any kind of file:
		try {
		FileInputStream ip=new FileInputStream(SheetPath);
		//creating local copy inside java memory
		book=WorkbookFactory.create(ip);
		sheet=book.getSheet(sheetName);
		}
	catch(FileNotFoundException e)	{
		e.printStackTrace();
	}
	catch(IllegalFormatException e)	{
		e.printStackTrace();
	}
	catch(IOException e)	{
		e.printStackTrace();
	}
	
	Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
		
	}
	return data;
}
}
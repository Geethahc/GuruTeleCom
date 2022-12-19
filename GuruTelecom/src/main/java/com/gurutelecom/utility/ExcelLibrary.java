package com.gurutelecom.utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelLibrary {
	
	FileInputStream fs;
	XSSFWorkbook wBook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	
	public static String filePath ;
	public ExcelLibrary(String filepath)
	{
		filePath = filepath;
		try {
			fs = new FileInputStream(filepath);
			wBook = new XSSFWorkbook(fs);
			sheet = wBook.getSheetAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getRowCount(String sheetName)
	{
		int rowCount =0;
		if(!isSheetExists(sheetName)) 
			return -1;
		sheet= wBook.getSheet(sheetName);
		rowCount =sheet.getLastRowNum();		
		return rowCount +1;
	}
	public int getColumnCount(String sheetName)
	{
		if(!isSheetExists(sheetName)) 
			return -1; 
		sheet= wBook.getSheet(sheetName);
		row= sheet.getRow(1);
		if(row == null)
			return -1;
		else 
			return row.getLastCellNum();	
	}
	
	public boolean isSheetExists(String sheetName)
	{
		int index = wBook.getSheetIndex(sheetName);
		if(index == -1)
		{
			index = wBook.getSheetIndex(sheetName.toUpperCase());
		if(index==-1)
			return false;
		else
			return true;
		}
		else 
			return true;
		
	}
	
	public String getCellData(String sheetName , int rowNum, int colNum)
	{
		String cellText ="";
		if(!isSheetExists(sheetName))
			return "";
		if(rowNum<0)
			return "";
		sheet= wBook.getSheet(sheetName);
		row =sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		if(cell.getCellType()== CellType.STRING)
			return cellText =cell.getStringCellValue();
		if((cell.getCellType()== CellType.NUMERIC )|| cell.getCellType() == CellType.FORMULA)
			cellText = String.valueOf(cell.getNumericCellValue());
		if(DateUtil.isCellDateFormatted(cell))
		{
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtil.getJavaDate(cell.getNumericCellValue()));
		cellText = String.valueOf(cal.get(Calendar.YEAR)).substring(2);
		cellText = cal.get(Calendar.MONTH)+1+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cellText;
	
		}	
		
		return cellText;
		
	}


}

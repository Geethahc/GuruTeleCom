package com.gurutelecom.dataprovider;
import java.util.HashMap;
import org.testng.annotations.DataProvider;
import java.util.Map;

import com.gurutelecom.base.BaseClass;
import com.gurutelecom.utility.ExcelLibrary;

public class DataProviders extends BaseClass {
	ExcelLibrary lib;
	public DataProviders()
	{
		lib = new ExcelLibrary(prop.getProperty("dataFilePath"));
	}
	
	@DataProvider(name="CustomerData")
	public Object[][] addCustomerData() throws NoSuchMethodException
	{
		Object[][] dataObj;
		
		try {
			
		
		int rowCount = lib.getRowCount("addCustomerData");
		int colCount = lib.getColumnCount("addCustomerData");
		dataObj= new Object[rowCount -1][1];
		
		
		for(int i=0;i<rowCount-1;i++)
		{
			Map<String, String> hashMap = new HashMap<>();
			for(int j=0 ;j<colCount;j++)
			{
			hashMap.put(lib.getCellData("addCustomerData", 0, j), lib.getCellData("addCustomerData", i +1, j));
			}
			dataObj[i][0] = hashMap;
		}
		System.out.println(dataObj.length);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		return dataObj;
		
	}



}

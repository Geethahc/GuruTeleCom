package com.gurutelecom.testcases;


import java.math.BigInteger;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gurutelecom.base.BaseClass;
import com.gurutelecom.dataprovider.DataProviders;
import com.gurutelecom.pageobjects.AccessPage;
import com.gurutelecom.pageobjects.AddCustomerPage;
import com.gurutelecom.pageobjects.HomePage;
import com.gurutelecom.utility.Globals;
import com.gurutelecom.utility.Log;
@Guice
public class AddCustomerPageTest extends BaseClass {
    @Parameters("browser")
	@BeforeMethod
	public void Setup(String browser) throws NoSuchMethodException {

		System.out.println("inside AddCustomerPageTest+Appsetup()");
		launchApp(browser);
	}

	@AfterMethod
	public void tearDown() {
		getdriver().quit();
		System.out.println("inside AddCustomerPageTest+quitapp()");
	}

	HomePage objHomePage;
	AddCustomerPage objAddCustomer;
	AccessPage objAccessPage;

	@Test(dataProvider  = "CustomerData", dataProviderClass = DataProviders.class)
	//@Test
	public void verifyAddNewCustomer(HashMap<String , String> objHashMap) throws Throwable {
	//public void verifyAddNewCustomer() throws Throwable {
		try {

			Log.startTestCase("verifyAddNewCustomer");
			if(objHashMap != null) {
			objHomePage = new HomePage();
			objAddCustomer = objHomePage.clickOnAddCustomer();
			//objAddCustomer.addCustomer("done", "g", "e", "e@abc.in", "tha", 111111);
			objAddCustomer.addCustomer(
					objHashMap.get("BGC"),
					objHashMap.get("FirstName"),
					objHashMap.get("LastName"),
					objHashMap.get("Email"),
					objHashMap.get("Address"),
					objHashMap.get("MobileNum"));
			objAccessPage = objAddCustomer.validateCustomerCreation();
			if (!(objAccessPage.getCustomerId() == 0)) {
				
				System.out.println("inside verifyAddNewCustomer -->Customer ID  is -->" +objAccessPage.getCustomerId());
				 Globals.customerID = objAccessPage.getCustomerId();
			} else {
				Assert.assertTrue(false);
			}
			}
			else
				Log.logErrorMessage("excel data to add new customer is empty");
			Log.endTestCase("verifyAddNewCustomer");
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			Log.logErrorStacktrace(ex);
			Assert.assertTrue(false);
			
			// ExceptionUtils.getStackTrace(ex);
		}
	}
}

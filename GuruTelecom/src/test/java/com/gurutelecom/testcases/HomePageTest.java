package com.gurutelecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gurutelecom.base.BaseClass;
import com.gurutelecom.pageobjects.HomePage;
import com.gurutelecom.utility.Log;

public class HomePageTest extends BaseClass  {
	private String browserName;
	private HomePage objHomePage ;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void Setup(String browser) throws NoSuchMethodException {

		System.out.println("inside HomePageTest+Appsetup()");
		this.browserName= browser;
		launchApp(browserName);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		getdriver().quit();
		System.out.println("inside HomePageTest+quitapp()");
	}

	@Test(groups = {"Smoke"})
	public void verifyLogo()
	{
		Log.startTestCase(""+browserName+"Browser : verifyLogo");
		objHomePage = new HomePage();
		boolean result = objHomePage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase(""+browserName+"Browser : verifyLogo");
	}
	@Test(groups = {"Smoke"})
	public void verifyTitle() {
		Log.startTestCase(""+browserName+"Browser :verifyTitle ");
        String str = prop.getProperty("xxx");
		String result = objHomePage.getHomePageTitle();
		Assert.assertEquals(result, "Guru99 Telecom1");
		Log.endTestCase(""+browserName+"Browser :verifyTitle  completed ");


	}
}

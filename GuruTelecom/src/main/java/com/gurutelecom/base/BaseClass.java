package com.gurutelecom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.gurutelecom.dataprovider.DataProviders;
import com.gurutelecom.utility.ExtentManager;
import com.gurutelecom.utility.Globals;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	//public  final  int customerID = 1;
	
	public void launchApp( String BrowserName) throws NoSuchMethodException {

		
		 System.out.println("inside BaseClass +LaunchApp()");
		//
		// String expected = "aaa";
		// String actual = "aaa";
		// Assert.assertEquals(actual, expected);
		
        DOMConfigurator.configure("Log4j.xml");
		

		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();

		

		String browserName = BrowserName;
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver.set(new ChromeDriver());
			driver.set(new ChromeDriver());
		}
		if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver.set(new FirefoxDriver());
			driver.set(new FirefoxDriver());
		}
		if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			// driver.set(new InternetExplorerDriver());
			driver.set(new InternetExplorerDriver());
		}
		getdriver().manage().window().maximize();
		getdriver().manage().deleteAllCookies();
		getdriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		getdriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeOut"))));
		getdriver().get(prop.getProperty("url"));
		System.out.println(prop.getProperty("dataFilePath"));
		//DataProviders data = new DataProviders(prop.getProperty("dataFilePath"));
		//DataProvider data = new DataProvider("D:\\GEETHA\\Selenium\\Projects\\GuruTelecom\\src\\test\\resources\\TestData.xlsx");
		//data.addCustomerData();
	}

	public static WebDriver getdriver() {
		return driver.get();
	}
	
	@AfterSuite
	public void quitapp()
	{
		 System.out.println("inside BaseClass + Quitapp()");
		 System.out.println(" customerID is : " +	 Globals.customerID);
		 ExtentManager.endReport();
		 
	}
@BeforeSuite(groups="Smoke")
	public static void readConfig() {
		try {
			//ExtentManager.createInstance();
			
			prop = new Properties();
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

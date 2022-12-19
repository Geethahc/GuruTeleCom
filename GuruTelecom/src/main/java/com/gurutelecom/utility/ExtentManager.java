package com.gurutelecom.utility;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.*;



public class ExtentManager {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports report; 
	
	public static void createInstance() throws IOException {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReports/MyReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("ProjectName", "GuruTelecom");
		report.setSystemInfo("Tester", "Geetha");
		report.setSystemInfo("OS", "Win10");
		report.setSystemInfo("Browser", "Chrome");
		
		
		
	}
	
	 public static ExtentReports getInstance() throws IOException {
	        if (report == null)
	            createInstance();
	        return report;
	    }
	
	
	
	public static synchronized void endReport() {
		if(report!= null)
		report.flush();
	}

}

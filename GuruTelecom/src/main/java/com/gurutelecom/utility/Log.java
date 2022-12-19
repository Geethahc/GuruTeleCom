package com.gurutelecom.utility;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String stestCaseName) {
		log.info("======================" +stestCaseName+ "TEST STRT==================");
		
	}
	
	public static void endTestCase(String stestCaseName) {
		log.info("======================" +stestCaseName+ "TEST END==================");
		
	}
	
	public static void logErrorMessage(String sErrorMessage) {
		log.error(sErrorMessage);
	}
	public static void logErrorStacktrace(Exception ex) {
		//log.error(ex.getMessage());
		log.error("--------------->");
		//log.error(ex.getStackTrace().toString());
		ex.printStackTrace(System.out);
	}
	
	public static void logWarning(String sWarningMessage) {
		log.warn(sWarningMessage);
	}

}

package com.demo.utils;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demo.constants.IGlobalConstants;

/**
 * ReportManager is to give an instance of ExtentReports. This is created as
 * Singleton such that each VM will have one instance of ExtentReport running
 * 
 */
public final class ReportManager {

    /** Extent reports instance variable. */
    private static  ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    
    // to make a singleton hide the constructor
    // to ensure no other instance of ReportManager exists in a machine
    private ReportManager() {

    }
        
    /**
     * getInstance method returns an instance of extent report.
     * 
     * @return {@link ExtentReports}
     */
    public static synchronized ExtentReports getExtentReport() {
    	if (extent == null) {
            // dynamic report file creation
            Date d = new Date();
            String fileName = d.toString().replace(" ", "_").replace(":", "_");
            String reportFileNamePath = System.getProperty("user.dir") + IGlobalConstants.REPORT_FILE_PATH + fileName
                    + ".html";
	 		htmlReporter= new ExtentHtmlReporter(reportFileNamePath);
	 		extent = new ExtentReports();
	 		extent.attachReporter(htmlReporter);
	 		extent.setSystemInfo("User Name", System.getProperty("user.name"));
	 		extent.setSystemInfo("OS", System.getProperty("os.name"));
	 		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	 		extent.setSystemInfo("Selenium Version", "3.141.59");
	    	extent.setSystemInfo("Test Environment", IGlobalConstants.ENVIRONMENT);
	    	extent.setSystemInfo("Browser Name", DataUtil.getEnvParametersSpecificToTestEnvironment("testBrowser"));
	    	extent.setSystemInfo("Application URL", DataUtil.getEnvParametersSpecificToTestEnvironment("applicationURL"));
	 		htmlReporter.config().setDocumentTitle("AutomationReport");
	 		htmlReporter.config().setReportName("DemoTestSuite");
	 		htmlReporter.config().setTheme(Theme.DARK);
    	}
    	return extent;
 	}	
    
    /**
	 * Initialize Logger.
	 */
//    public static synchronized Logger getLogs(){
//		if (log == null){
//			// Initialize Log4j logs
//			DOMConfigurator.configure(System.getProperty("user.dir") + IGlobalConstants.GLOBAL_REPORT_CONFIG_FOLDER + File.separator + "log4j.xml");
//			log = Logger.getLogger("MyLogger");
//			log.info("Logger is initialized..");
//		}
//		return log;
//	}
}

package com.demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.demo.pages.BlazeHome;
import com.demo.pages.BookFlight;
import com.demo.pages.Confirmation;
import com.demo.pages.SelectFlight;
import com.demo.constants.IGlobalConstants;
import com.demo.utils.DataUtil;
import com.demo.utils.ReportManager;

public class TestBase {

	private WebDriver driver = null;
	private Properties envConfig = null;
	private HashMap<String, String> environmentData = null;	
	private HashMap<String, String> testData = null;
			
	protected static ExtentTest logger;	
	protected static BlazeHome pageBlazeHome;
	protected static SelectFlight pageSelectFlight;
	protected static BookFlight pageBookFlight;
	protected static Confirmation pageConfirmation;
	
	protected static final Logger log = Logger.getLogger("MyLogger");
	protected ExtentReports extent = ReportManager.getExtentReport();	
	
	public TestBase() {
		setEnvConfig(readConfigProperties(System.getProperty("user.dir") + IGlobalConstants.ENVIRONMENT_PROPERTIES_PATH));
        setEnvironmentData(DataUtil.loadEnvironmentData(getEnvConfig().getProperty("environment")));
        setBrowserType();
        initializePageModel();
        DOMConfigurator.configure(System.getProperty("user.dir") + IGlobalConstants.GLOBAL_REPORT_CONFIG_FOLDER + File.separator + "log4j.xml");
	}
	
	/**
     * Initialize page model
     */
	public  void initializePageModel()
	{
		pageBlazeHome=PageFactory.initElements(getDriver(), BlazeHome.class);
		pageBookFlight = PageFactory.initElements(getDriver(), BookFlight.class);
		pageConfirmation = PageFactory.initElements(getDriver(), Confirmation.class);
		pageSelectFlight = PageFactory.initElements(getDriver(), SelectFlight.class);
		getDriver().navigate().refresh();
        waitUntilPageLoadFinishesCompletely();		
	}
			
	/**
     * initializes the Browser
     */
	private void setBrowserType() {
		if (getEnvironmentData().get("testBrowser").equalsIgnoreCase("Firefox")) {
            initializeFirefoxHeadless(false);
        } 
		else if (getEnvironmentData().get("testBrowser").equalsIgnoreCase("FirefoxHeadless")) {
            initializeFirefoxHeadless(true);
        } 
		else if (getEnvironmentData().get("testBrowser").equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + IGlobalConstants.IE_DRIVER_PATH);
            setDriver(new InternetExplorerDriver());
        } 
		else if (getEnvironmentData().get("testBrowser").equalsIgnoreCase("Chrome")) {
            initializeChromeHeadless(false);
        } 
		else if (getEnvironmentData().get("testBrowser").equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver",
                    System.getProperty("user.dir") + IGlobalConstants.EDGE_DRIVER_PATH);
            setDriver(new EdgeDriver());
        } 
		else if (getEnvironmentData().get("testBrowser").equalsIgnoreCase("ChromeHeadless")) {
            initializeChromeHeadless(true);
        } 
		else 		{
            log.error("Invalid browserName specified. Please check environment.properties config");
            throw new RuntimeException("Invalid browserName specified: "+getEnvironmentData().get("testBrowser"));
        }		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}
	
	 /**
     * initializes the FirefoxDriver
     */
    private void initializeFirefoxHeadless(final boolean headless) {
        if (!headless) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + System.getProperty("user.dir") + IGlobalConstants.GECKO_DRIVER_PATH);
            setDriver(new FirefoxDriver());
        } else {
        	 System.setProperty("webdriver.gecko.driver",
                     System.getProperty("user.dir") + System.getProperty("user.dir") + IGlobalConstants.GECKO_DRIVER_PATH);
             setDriver(new FirefoxDriver()); 
        }              
    }
    
    /**
     * initializes the ChromeDriver
     */
    private void initializeChromeHeadless(final boolean headless) {
        if (!headless) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + IGlobalConstants.CHROME_DRIVER_PATH);
            setDriver(new ChromeDriver());
        } else{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + IGlobalConstants.CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            setDriver(new ChromeDriver(options));
        } 
    }
    
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
     * private Getter to get the envConfig.
     * 
     * @return the envConfig
     */
    public Properties getEnvConfig() {
        return this.envConfig;
    }

    /**
     * private Setter to set the envConfig.
     * 
     * @param configuration
     *            the envConfig to set
     */
    public void setEnvConfig(final Properties envConfig) {
        this.envConfig = envConfig;
    }
	
	/** * Gets the environmentData field. * * @return the environmentData */
    
    public HashMap<String, String> getEnvironmentData() {
        return environmentData;
    }

    /**
     * * Sets the environmentData field. * * @param environmentData the
     * environmentData to set
     */

    public void setEnvironmentData(HashMap<String, String> environmentData) {
        this.environmentData = environmentData;
    }
	
    /** * Gets the test data field. * * @return the testData */
    
    public HashMap<String, String> getTestData() {
        return testData;
    }

    /**
     * * Sets the testData field. * * @param testData the
     * testData to set
     */

    public void setTestData(HashMap<String, String> testData) {
        this.testData = testData;
    }
    
    /**
     * Reads the properties file passed and returns it
     * 
     * @param fileName
     * @return Properties
     */
    private Properties readConfigProperties(final String fileName) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }	
	
	 /**
     * Helper method to wait until the page load finishes completely
     */
    protected void waitUntilPageLoadFinishesCompletely() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @return the report
     */
    public ExtentReports getReport() {
        return extent;
    }

    /**
     * @param report
     *            the report to set
     */
    public void setReport(ExtentReports report) {
        this.extent = report;
    }
   
    /**
     * to report to both log and to the extent report simultaneously
     * 
     * @param log
     *            - {@link Logger}
     * @param logger
     *            - {@link ExtentTest}
     * @param status
     *            - info, error, fail, warn, fatal
     * @param message
     *            - String description of the message to log
     */
    public void reportLog(final String status, final String message) {
        if (status.equalsIgnoreCase("info")) {
            log.info(message);
            logger.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.TRANSPARENT));
        } else if (status.equalsIgnoreCase("error")) {
        	log.info(message);
            logger.log(Status.ERROR, MarkupHelper.createLabel(message, ExtentColor.RED));
            takeScreenshot(message);
        } else if (status.equalsIgnoreCase("fail")) {
        	log.info(message);
            logger.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
            takeScreenshot(message);
        } else if (status.equalsIgnoreCase("warn")) {
        	log.info(message);
            logger.log(Status.WARNING, MarkupHelper.createLabel(message, ExtentColor.YELLOW));
        } else if (status.equalsIgnoreCase("fatal")) {
        	log.info(message);
            logger.log(Status.FATAL, MarkupHelper.createLabel(message, ExtentColor.RED));
            takeScreenshot(message);
        } else if (status.equalsIgnoreCase("pass")) {
        	log.info(message);
            logger.log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
        } else {
        	log.info("Invalid log input provided");
            logger.log(Status.INFO, MarkupHelper.createLabel("Invalid log input provided", ExtentColor.ORANGE));
        }
    }    
    
    /**
     * to attach the screenshot to the extent report
     * 
     * * @param status
     *            - info, error, fail, warn, fatal
     * @param message
     *            - String description of the message to log
     * @throws IOException 
     */
    public void screenshotLog(final String status, final String screenshotName) {
    	try {
	        if (status.equalsIgnoreCase("info")) {
	        	logger.info(screenshotName, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(screenshotName)).build());
	        } else if (status.equalsIgnoreCase("pass")) {
	        	logger.pass(screenshotName, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(screenshotName)).build());
	        } else {
	        	log.info("Invalid log input provided");
	            logger.log(Status.INFO, MarkupHelper.createLabel("Invalid log input provided", ExtentColor.ORANGE));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }    

    /**
     * Close the report
     */
 	@AfterTest
 	public void teardown()
 	{
 		extent.flush();
 	}
 	
 	/**
     * Set method Pass/Fail report
     * * @param result
     */
 	@AfterMethod
 	public void afterMethod(ITestResult result) throws IOException
 	{		
 		if(result.getStatus() == ITestResult.FAILURE) {			    
             logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
             logger.fail(result.getThrowable().getMessage());
             logger.addScreenCaptureFromPath(takeScreenshot(result.getName()));
         }		
         else if(result.getStatus() == ITestResult.SUCCESS) {
             logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
         }
         else {
             logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
             logger.skip(result.getThrowable());
         }
 		driver.quit();
 	}
 	
 	/**
     * takeScreenShot - this method takes the screenshots and saves under
     * "screenshots" folder under the current directory of test.
     *
     * @param screenshotName
     **/
	protected String takeScreenshot(String screenshotName) {		
		Date d = new Date();
        String fileName = screenshotName.toString().replace(" ", "_") + "_" + d.toString().replace(" ", "_").replace(":", "_");
		String filePath = System.getProperty("user.dir") + IGlobalConstants.GLOBAL_SCREENSHOTS_FOLDER + fileName
                + ".jpg";
		try 
		{
			if (driver instanceof TakesScreenshot) {
				File tmpFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				org.openqa.selenium.io.FileHandler.copy(tmpFile, new File(filePath));
			}
		} 
		catch (Exception e) {
            log.error("Test failed due to IOException");
            log.error("IOException " + e.getMessage());
        }
		return filePath;		
	}
	
}

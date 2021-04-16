package base;


import org.openqa.selenium.WebDriver;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
// import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.SpiceHome;
import pages.SpiceNewAccount;
import pages.TeamPageModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class TestBase extends	ExcelDataProvider {
	protected static WebDriver driver ;
	protected static DataExcel excelData;
	protected static DataConfig properties;	
	protected static  ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest logger;
	private static final String PROPERTIES_DATA_FILE="config/spice.properties";
	protected static final String EXCEL_DATA_FILE="config/excelData.xlsx";
	protected static final String EXCEL_FILE_PATH="config/SpiceData.xlsx";
	protected static final String EXCEL_FILE_NAME="SpiceData.xlsx";
	protected static final String EXCEL_SHEET_NAME="Sheet1";
	protected static TeamPageModel pageModel;
	protected static SpiceHome pageSpiceHome;
	protected static SpiceNewAccount pageSpiceNewAccount;
	private static final String ROOT_DIRECTORY="user.dir";
	static String excelFileName="CreateAccount.xlsx";
	static String sheetName="Sheet1";	
	static String filePath="config/CreateAccount.xlsx";
	

	    
//	protected TestBase() throws IOException {
//		properties=DataConfig.getInstance(PROPERTIES_DATA_FILE);		    
//		// driver=FactoryPattern.getDriver("IE");
//		driver=FactoryPattern.getDriver(properties.getProperty("Browser"));
//		initializePageModel();
//	}
	
	@BeforeSuite
	public void setUpExecution() {
		properties=DataConfig.getInstance(PROPERTIES_DATA_FILE);
		//excelData=DataExcel.getInstance(EXCEL_FILE_PATH, EXCEL_FILE_NAME, EXCEL_SHEET_NAME);
		
		driver=FactoryPattern.getDriver(BrowserFactory.CHROME);
		//driver=FactoryPattern.getDriver(properties.getProperty("Browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		initializePageModel();
	}
	
	// Initialize page model
	public  void initializePageModel()
	{
		pageModel=PageFactory.initElements(driver, TeamPageModel.class);
		pageSpiceHome=PageFactory.initElements(driver, SpiceHome.class);
		pageSpiceNewAccount=PageFactory.initElements(driver, SpiceNewAccount.class);
	}
	
	// Set report format
	@BeforeTest
	public void initReports()
	{
		htmlReporter= new ExtentHtmlReporter(System.getProperty(ROOT_DIRECTORY)+File.separator+"Reports"+File.separator+"Report"+getCurrentTime()+".html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("AutomationReport");
		htmlReporter.config().setReportName("DemoTestSuite");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}	

	// Close driver and report
	@AfterTest
	public void teardown()
	{
		//driver.quit();
		extent.flush();
	}
		
	public void initBrowser() {
		//driver=FactoryPattern.getDriver(properties.getProperty("Browser"));
		driver=FactoryPattern.getDriver(BrowserFactory.CHROME);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get(properties.getProperty("Website"));
	}
	
	// Set method Pass/Fail report
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{		
		if(result.getStatus() == ITestResult.FAILURE) {			    
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            logger.fail(result.getThrowable().getMessage());
            logger.addScreenCaptureFromPath(getScreenshot(result.getName()));
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
	
	// Current time
	public String getCurrentTime()
	{
		SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyyyhhmmss");
		return sdf.format(new Date());
	}
	
	// Sleep Method
	public void setSleep(long milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	//Screenshot method
	protected String getScreenshot(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		String ext = ".png";
		String path = getScreenshotSavePath() + File.separator + date + "_" + name + ext;
		try 
		{
			if (driver instanceof TakesScreenshot) {
				File tmpFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				org.openqa.selenium.io.FileHandler.copy(tmpFile, new File(path));
			}
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return path;
	}
	
	// Create Screenshot path
	protected String getScreenshotSavePath() 
	{
		String packageName = this.getClass().getPackage().getName();
		File dir = new File(System.getProperty(ROOT_DIRECTORY)+File.separator+"screenshot"+File.separator + packageName + File.separator);
		dir.mkdirs();
		return dir.getAbsolutePath();
	}
		
	// Assert Actual and Expected Strings
	protected void assertStrings(String actual, String expected){
		try {
			Assert.assertEquals(actual, expected);
		}
		catch(AssertionError e){	

		}
	}
	

}

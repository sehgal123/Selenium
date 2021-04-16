package sanitySuite;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.DataExcel;
import base.TestBase;

public class SpiceJet extends TestBase{	

	static String fileName="SpiceData.xlsx";
	static String sheetName="Sheet1";	
	static String filePath="config/SpiceData.xlsx";
	
//	static String fileName="SpiceData.xlsx";
//	static String sheetName="Sheet1";	
//	static String filePath="config/SpiceData.xlsx";
//	
//	static String fileName="SpiceData.xlsx";
//	static String sheetName="Sheet1";	
//	static String filePath="config/SpiceData.xlsx";
	
	/*private static String screenshotPath=System.getProperty("user.dir")+ File.separator+ "screenshot";*/
	
	@Test (priority=1, description = "Open Google Search URL")	
	public void TC001() throws InterruptedException  {
		logger=extent.createTest("TCOO1");
		
		driver.get(properties.getProperty("Website"));
		Thread.sleep(1000);
	    logger.log(Status.PASS,  MarkupHelper.createLabel("URL is hit", ExtentColor.GREEN));
       
	    pageSpiceHome.NavigateToSignup();
        logger.log(Status.PASS,  MarkupHelper.createLabel("Succesfully clicked on SingUp Link", ExtentColor.GREEN));
        logger.log(Status.PASS,  MarkupHelper.createLabel("test case passed", ExtentColor.GREEN));
	}
	
	//@Test (priority=1, description = "Open Google Search URL")	
	public void TC0012(String User, String Pass, String Account) throws InterruptedException {
		logger=extent.createTest("TCOO2");
		
		driver.get(properties.getProperty("Website"));
		Thread.sleep(1000);
	    logger.log(Status.PASS,  MarkupHelper.createLabel("URL is hit", ExtentColor.GREEN));
       
	    pageSpiceHome.NavigateToSignup();
        logger.log(Status.PASS,  MarkupHelper.createLabel("Succesfully clicked on SingUp Link", ExtentColor.GREEN));
        logger.log(Status.PASS,  MarkupHelper.createLabel("test case passed", ExtentColor.GREEN));
	}
	
	//@Test
	public void TC002() {
		logger=extent.createTest("TCOO2");
		System.out.println(excelData.getProperty("Test Case ID"));
		System.out.println(excelData.getProperty("Account"));
		logger.log(Status.PASS,  MarkupHelper.createLabel("Excel Data read successfully", ExtentColor.GREEN));
	}
	
	//@Test
	public void ReadExcelData() {
		logger=extent.createTest("ReadExcelData");
		excelData=DataExcel.getInstance(filePath, fileName, sheetName);
		System.out.println(excelData.getProperty("Test Case ID"));
		System.out.println(excelData.getProperty("Account"));
		logger.log(Status.PASS,  MarkupHelper.createLabel("Excel Data read successfully", ExtentColor.GREEN));
	}	
}	
	

	
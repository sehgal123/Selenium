package sanitySuite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import base.DataExcel;
import base.TestBase;

public class TestCase_1_GoogleSearch extends TestBase{
	

	

	protected TestCase_1_GoogleSearch() throws IOException {
		super();
		
	}

	static String fileName="excelData.xlsx";
	static String browser="IE";
	static String sheetName2="Sheet2";
	static String sheetName1="Sheet1";
	
	static String filePath="C:/Users/vijay.a.rawat/eclipse-workspace/Java-Selenium-TestNG-Automation-Framework-master.zip_expanded/config/excelData.xlsx";
	
	/*private static String screenshotPath=System.getProperty("user.dir")+ File.separator+ "screenshot";*/
	@Test (priority=1, description = "Open Google Search URL")	
	public void TC001()  {
		logger=extent.createTest("TCOO1");
		
		driver.get(properties.getProperty("Website"));
	    logger.log(Status.PASS,  MarkupHelper.createLabel("URL is hit", ExtentColor.GREEN));
       
        pageModel.getBlog().click();
        logger.log(Status.PASS,  MarkupHelper.createLabel("Succesfully clicked on Blog", ExtentColor.GREEN));
        pageModel.getInputGroup().sendKeys("hsagfdsgfg");
       
        logger.log(Status.PASS,  MarkupHelper.createLabel("Entered data in textbox", ExtentColor.GREEN));
        System.out.println( properties.getProperty("Website"));
        logger.log(Status.PASS,  MarkupHelper.createLabel("test case passed", ExtentColor.GREEN));
	}
	
	

	@Test(priority=2)
	public void TC002()
	{
		logger=extent.createTest("TCOO2");
		driver.get(properties.getProperty("Website"));
	    logger.log(Status.PASS,  MarkupHelper.createLabel("URL is hit", ExtentColor.GREEN));
       
        pageModel.getBlog().click();
        logger.log(Status.PASS,  MarkupHelper.createLabel("Succesfully clicked on Blog", ExtentColor.GREEN));
        pageModel.getInputGroup().sendKeys("hsagfdsgfg");
       
        logger.log(Status.PASS,  MarkupHelper.createLabel("Entered data in textbox", ExtentColor.GREEN));
        System.out.println( properties.getProperty("Website"));
        Assert.assertTrue(true);
        logger.log(Status.PASS,  MarkupHelper.createLabel("test case passed", ExtentColor.GREEN));
        Assert.assertTrue(true);
        logger.log(Status.PASS,  MarkupHelper.createLabel("test case passed", ExtentColor.GREEN));
     
	}
	
	@Test(priority=3)
	public void TC003()
	{
		 logger=extent.createTest("TC003");
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test case 1st step", ExtentColor.GREEN));
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test case 2nd step", ExtentColor.GREEN));
		 Assert.assertTrue(false);
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test case Passed", ExtentColor.GREEN));
		 
		 
	}
	
	@Test(priority=4)
	public void TC004()
	{
		 logger=extent.createTest("TC004");
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test case 1st step", ExtentColor.GREEN));
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test case 2nd step", ExtentColor.GREEN));
		 Assert.assertTrue(false);
		 logger.log(Status.PASS, MarkupHelper.createLabel("Test case Passed", ExtentColor.GREEN));
		 
		 
	}
	
	@Test(enabled=false)
	public void testDataExcel()
	{
		logger=extent.createTest("testDataExcel");
		 long start = System.nanoTime();
		  excelData=DataExcel.getInstance(filePath, fileName, sheetName1);
		  
		  long finish = System.nanoTime();
		  long timeElapsed = finish - start;
		  
		  System.out.println("Time taken while loading excel sheet first time=>"+timeElapsed);
		  logger.log(Status.PASS, MarkupHelper.createLabel("Time taken while loading excel sheet first time=>"+timeElapsed, ExtentColor.GREEN));
		  
		  long start1 = System.nanoTime();
   	      excelData= DataExcel.getInstance(filePath, fileName, sheetName1);
		  System.out.println(excelData.getProperty("Website"));
		  long finish1 = System.nanoTime();
		  long timeElapsed1 = finish1 - start1;
		  double seconds1 = (double)timeElapsed1 / 1_000_000_000.0;
		  logger.log(Status.PASS, MarkupHelper.createLabel("Time taken while loading excel sheet first time=>"+timeElapsed1, ExtentColor.GREEN));
		  
		  
		  long start2 = System.nanoTime();
		  excelData= DataExcel.getInstance(filePath, fileName, sheetName2);
		  System.out.println(excelData.getProperty("Website"));
		  long finish2 = System.nanoTime();
		  long timeElapsed2 = finish2 - start2;
		  double seconds2 = (double)timeElapsed2 / 1_000_000_000.0;
		  logger.log(Status.PASS, MarkupHelper.createLabel("Time taken while loading excel sheet first time=>"+timeElapsed2, ExtentColor.GREEN));
		 
         
		  long start3 = System.nanoTime();
		  excelData= DataExcel.getInstance(filePath, fileName, sheetName2);
		  System.out.println(excelData.getProperty("Website"));
		 
		  long finish3 = System.nanoTime();
		  long timeElapsed3 = finish3 - start3;
		  double seconds3 = (double)timeElapsed3 / 1_000_000_000.0;
		  logger.log(Status.PASS, MarkupHelper.createLabel("Time taken while loading excel sheet first time=>"+timeElapsed3, ExtentColor.GREEN));
        
    }
	
	
	
}

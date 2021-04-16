package com.demo.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demo.base.TestBase;
import com.demo.utils.DataUtil;

public class TestSuite extends TestBase {
	
	SoftAssert softAssert = new SoftAssert();

	static String testDataExcel="TestData.xlsx";
	static String testDataSheet="Sheet1";	
	static String colName="TC01";
	
	//***********************************
	// Booking Flight
	//***********************************
	@Test (priority=1, testName = "TC01_SIT_Flight_Booking")	
	public void TC01_SIT_Flight_Booking() throws Exception {
		
		//test = getReport().startTest("TC01_SIT_Flight_Booking");
		logger=getReport().createTest("TC01_SIT_Flight_Booking");
		
		setTestData(DataUtil.loadTestData(testDataExcel, testDataSheet, colName));
			
		System.out.println(getTestData().get("Test Case ID"));		
		String strFrom = getTestData().get("From");
		String strTo = getTestData().get("To");
		String strName = getTestData().get("Name");
		String strAddress = getTestData().get("Address");
		String strCity = getTestData().get("City");
		String strState = getTestData().get("State");
		String iZipCode = getTestData().get("ZipCode");
		String strCardType = getTestData().get("CardType");
		String iCardNum = getTestData().get("CardNumber");
		String iMonth = getTestData().get("Month");
		String iYear = getTestData().get("Year");
		String strCardName = getTestData().get("CardName");		
		
		reportLog("info", "Launch Blaze Demo Application");
		pageBlazeHome.fnNavigateToLoginPage(getEnvironmentData().get("applicationURL"));
		pageBlazeHome.fnHomePageDisplayed();	    
	    screenshotLog("info", "AppLaunched");
	    	    
	    reportLog("info", "Find Flight Details");
	    pageBlazeHome.fnFindFlight(strFrom, strTo);
	    
	    reportLog("info", "Select Flight");
	    pageSelectFlight.fnSelectFilght();
	    
	    reportLog("info", "Enter Details To Book the Flight");
	    pageBookFlight.fnBookFlight(strName, strAddress, strCity, strState, iZipCode, strCardType, iCardNum, iMonth, iYear, strCardName);
	    reportLog("info", "Flight Details Entered");
	    
	    reportLog("info", "Click on Book Flight Button");
	    String fightId = pageConfirmation.fnValidateFilghtBooking();  
	    reportLog("pass", "Flight Booked with Flight Id: " + fightId);
	    screenshotLog("pass", "Flight_Booked");
	    
	    reportLog("info", "Close Application");
	    pageBlazeHome.closeApplication();	    
	}
	
	//***********************************
	// New User Registration
	//***********************************
	@Test (priority=2, description = "New User Registration")	
	public void TC02_SIT_New_User_Registration() throws Exception  {
		logger=extent.createTest("TC02_SIT_New_User_Registration");
		/* 
		 ***********************************
		 Code for New User Registration
		 **********************************
		*/
	}
	
	//***********************************
	// Valid Login
	//***********************************
	//@Test (priority=3, description = "Valid Login", dataProvider = "Test3")	
	public void TC03_SIT_Valid_Login(String countryValue, String countryName) throws Exception  {
		logger=extent.createTest("TC03_SIT_Valid_Login");
		/* 
		 ***********************************
		 Code for valid login
		 **********************************
		*/
		System.out.println(countryValue);// + " - " + country);
	}
	
	@DataProvider(name = "Test3")
    public Object[][] getData() {
        return DataUtil.getDataFromSpreadSheet("TestDatas.xlsx", "Test3");
    }
	
}
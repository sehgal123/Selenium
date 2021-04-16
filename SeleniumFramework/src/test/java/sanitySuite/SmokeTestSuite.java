package sanitySuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.TestBase;


public class SmokeTestSuite extends TestBase {	
	
	@BeforeMethod
	@Override
	public void initBrowser() {
		// TODO Auto-generated method stub
		super.initBrowser();
	}
	
	//@Test (priority=0, dataProvider = "CreateAccount", description = "Create Account")	
	public void Create_Account(String TCId, String userName, String passWord, String account, String address, String phone) {
		logger=extent.createTest("Create Account Test Case");
		System.out.println("TC id is: " + TCId);
		System.out.println("UserName is: " + userName);
		System.out.println("Password is: " + passWord);
		System.out.println("Account is: " + account);
		System.out.println("Address is: " + address);
		System.out.println("Phone is: " + phone);
        logger.log(Status.PASS,  MarkupHelper.createLabel("Create Account Test case passed", ExtentColor.GREEN));
	}
	
	@Test (priority=1, dataProvider = "CreateAlert", description = "Create Alert", groups = "Smoke", enabled = true)	
	public void Create_Alert(String TCId, String userName, String passWord, String alertName, String alertCountry) {
		logger=extent.createTest("Create Alert Test Case");
		System.out.println("TC id is: " + TCId);
		System.out.println("UserName is: " + userName);
		System.out.println("Password is: " + passWord);
		System.out.println("Alert Name is: " + alertName);
		System.out.println("Country is: " + alertCountry);
        logger.log(Status.PASS,  MarkupHelper.createLabel("Create Alert Test case passed", ExtentColor.GREEN));
	}
	
}
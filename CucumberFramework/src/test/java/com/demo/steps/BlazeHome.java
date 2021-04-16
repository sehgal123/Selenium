package com.demo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.PageBase;
import com.demo.constants.IBlazeHome;
import com.demo.utils.SeleniumUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BlazeHome extends PageBase {	
	
	public BlazeHome(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = IBlazeHome.WELCOME_MSG)
	private WebElement welcome_msg;
	public WebElement getWelcomeMsg()
	{
		return welcome_msg;
	}
	
	@FindBy(xpath = IBlazeHome.FROM_DDWN)
	private WebElement from_ddwn;
	public WebElement getFromPort()
	{
		return from_ddwn;
	}
	
	@FindBy(xpath = IBlazeHome.TO_DDWN)
	private WebElement to_ddwn;
	public WebElement getToPort()
	{
		return to_ddwn;
	}
	
	@FindBy(xpath = IBlazeHome.FINDFLIGHTS_BTN)
	private WebElement findFlights_btn;
	public WebElement getFindFlights()
	{
		return findFlights_btn;
	}	
	
	//Methods	
	//Launch Page to load the application URL	
	@Given("User is on Blaze demo application home page")
    public void user_is_on_blaze_demo_application_home_page() {		
	    SeleniumUtil.navigateToURL("https://blazedemo.com/", driver);
        SeleniumUtil.waitForLoad(driver);
        SeleniumUtil.loadUrl();
        SeleniumUtil.verifyElementExists(getWelcomeMsg());
    }
    
	@When("User Find the flight {string} {string}")
	public void fnNavigateToLoginPage(String strFrom, String strTo){
		if(getFromPort().isDisplayed()) {
			SeleniumUtil.selectbyValuesFromDropbox(getFromPort(), strFrom, driver);			
			SeleniumUtil.selectbyValuesFromDropbox(getToPort(), strTo, driver);			
			SeleniumUtil.clickElementAssert(getFindFlights(), driver);
		}
	}
	
	public void closeApplication() {
        driver.close();
    }
}

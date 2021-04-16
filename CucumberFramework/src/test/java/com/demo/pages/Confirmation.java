package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.PageBase;
import com.demo.constants.IConfirmation;
import com.demo.utils.SeleniumUtil;

public class Confirmation extends PageBase {
	
	public Confirmation(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = IConfirmation.CONFIRMATION_MSG)
	private WebElement confirmation_msg;
	public WebElement getConfirmationMsg()
	{
		return confirmation_msg;
	}
	
	@FindBy(xpath = IConfirmation.CONFIRMATIONID_TBL)
	private WebElement confirmationId;
	public WebElement getConfirmationId()
	{
		return confirmationId;
	}	
	
	//Methods
	public String fnValidateFilghtBooking(){
		SeleniumUtil.verifyElementExists(getConfirmationMsg());
		String id = SeleniumUtil.getElementText(getConfirmationId());
		// getScreenshot("ConfirmationDetails");
		return id;
	}
}

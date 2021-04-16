package com.demo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.PageBase;
import com.demo.constants.IConfirmation;
import com.demo.utils.SeleniumUtil;

import io.cucumber.java.en.Then;

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
	@Then("Flight should book successfully and Flight Id should Generated")
	public String flight_should_book_successfully_and_flight_id_should_generated(){
		SeleniumUtil.verifyElementExists(getConfirmationMsg());
		String id = SeleniumUtil.getElementText(getConfirmationId());
		// getScreenshot("ConfirmationDetails");
		return id;
	}
}

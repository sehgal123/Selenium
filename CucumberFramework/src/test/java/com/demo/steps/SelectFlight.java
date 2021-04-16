package com.demo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.PageBase;
import com.demo.constants.ISelectFlight;
import com.demo.utils.SeleniumUtil;

import io.cucumber.java.en.And;

public class SelectFlight extends PageBase {
	
	public SelectFlight(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = ISelectFlight.SELECTFLIGHT_INPUT)
	private WebElement selectFlight_input;
	public WebElement getSelectFlight()
	{
		return selectFlight_input;
	}
	
	//Methods
	@And("Select the Flight")
	public void select_the_flight(){
		SeleniumUtil.clickElementAssert(getSelectFlight(), driver);
		// getScreenshot("BookingPage");
	}
}

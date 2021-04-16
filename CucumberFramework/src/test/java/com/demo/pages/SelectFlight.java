package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.PageBase;
import com.demo.constants.ISelectFlight;
import com.demo.utils.SeleniumUtil;

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
	public void fnSelectFilght(){
		SeleniumUtil.clickElementAssert(getSelectFlight(), driver);
		// getScreenshot("BookingPage");
	}
}

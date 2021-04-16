package com.demo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.base.PageBase;
import com.demo.constants.IBookFlight;
import com.demo.utils.SeleniumUtil;

import io.cucumber.java.en.And;

public class BookFlight extends PageBase {	
	
	public BookFlight(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(css = IBookFlight.NAME_TXT)
	private WebElement name_txt;
	public WebElement getName()
	{
		return name_txt;
	}
	
	@FindBy(css = IBookFlight.ADDRESS_TXT)
	private WebElement address_txt;
	public WebElement getAddress()
	{
		return address_txt;
	}
	
	@FindBy(css = IBookFlight.CITY_TXT)
	private WebElement city_txt;
	public WebElement getCity()
	{
		return city_txt;
	}
	
	@FindBy(css = IBookFlight.STATE_TXT)
	private WebElement state_txt;
	public WebElement getState()
	{
		return state_txt;
	}
	
	@FindBy(css = IBookFlight.ZIP_TXT)
	private WebElement zip_txt;
	public WebElement getZip()
	{
		return zip_txt;
	}
	
	@FindBy(css = IBookFlight.CARDTYPE_DDWN)
	private WebElement cardType_ddwn;
	public WebElement getCardType()
	{
		return cardType_ddwn;
	}
	
	@FindBy(css = IBookFlight.CARDNUMBER_TXT)
	private WebElement cardNumber_txt;
	public WebElement getCardNumber()
	{
		return cardNumber_txt;
	}
	
	@FindBy(css = IBookFlight.CARDMONTH_TXT)
	private WebElement cardMonth_txt;
	public WebElement getCardMonth()
	{
		return cardMonth_txt;
	}
	
	@FindBy(css = IBookFlight.CARDYEAR_TXT)
	private WebElement cardYear_txt;
	public WebElement getCardYear()
	{
		return cardYear_txt;
	}
	
	@FindBy(xpath = IBookFlight.NAMEONCARD_TXT)
	private WebElement nameOnCard_txt;
	public WebElement getNameOnCard()
	{
		return nameOnCard_txt;
	}
	
	@FindBy(xpath = IBookFlight.PURCHASEFLIGHT_TXT)
	private WebElement purchaseFlight_txt;
	public WebElement getPurchaseFlight()
	{
		return purchaseFlight_txt;
	}
	
	//Methods
	@And("Enter the Details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}  To Book the Flight")
	public void enter_the_details_to_book_the_flight(String strName, String strAddress, String strCity, String strState, String iZipCode, 
			String strCardType, String iCardNum, String iMonth, String iYear, String strCardName){
		
		/* **********************************
		 Validation points for mandatory fields and minimum characters can include.
		********************************** 
		*/
		
		SeleniumUtil.typeValuesInATextBox(getName(), strName, driver);
		SeleniumUtil.typeValuesInATextBox(getAddress(), strAddress, driver);
		SeleniumUtil.typeValuesInATextBox(getCity(), strCity, driver);
		SeleniumUtil.typeValuesInATextBox(getState(), strState, driver);
		SeleniumUtil.typeValuesInATextBox(getZip(), String.valueOf(iZipCode), driver);
		SeleniumUtil.selectbyVisibleTextFromDropbox(getCardType(), strCardType, driver);
		SeleniumUtil.typeValuesInATextBox(getCardNumber(), iCardNum, driver);
		SeleniumUtil.typeValuesInATextBox(getCardMonth(), iMonth, driver);
		SeleniumUtil.typeValuesInATextBox(getCardYear(), iYear, driver);
		SeleniumUtil.typeValuesInATextBox(getNameOnCard(), strCardName, driver);
			
	}
	
	@And("Click on Book Flight Button")
	public void click_on_book_flight_button() {	
		SeleniumUtil.clickElementAssert(getPurchaseFlight(), driver);	
	}
}

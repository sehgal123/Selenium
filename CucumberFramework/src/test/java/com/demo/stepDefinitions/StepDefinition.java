package com.demo.stepDefinitions;

import com.demo.base.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends TestBase {
	//***********************************
	// Booking Flight
	//***********************************				
	@Given("User is on Blaze demo application home page")
    public void user_is_on_blaze_demo_application_home_page() {		
		pageBlazeHome.fnNavigateToLoginPage(getEnvironmentData().get("applicationURL"));
	}
	
	@When("User Find the flight {string} {string}")
	public void fnNavigateToLoginPage(String strFrom, String strTo){
		pageBlazeHome.fnFindFlight(strFrom, strTo);
	}	
	
	@And("Select the Flight")
	public void select_the_flight(){
		pageSelectFlight.fnSelectFilght();
	}
   
	@And("Enter the Details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}  To Book the Flight")
	public void enter_the_details_to_book_the_flight(String strName, String strAddress, String strCity, String strState, String iZipCode, 
			String strCardType, String iCardNum, String iMonth, String iYear, String strCardName){		
		pageBookFlight.fnBookFlight(strName, strAddress, strCity, strState, iZipCode, strCardType, iCardNum, iMonth, iYear, strCardName);
	}
	
	@And("Click on Book Flight Button")
	public void click_on_book_flight_button() {	
		pageBookFlight.fnClickBookFlight();
	}
	
	@Then("Flight should book successfully and Flight Id should Generated")
	public void flight_should_book_successfully_and_flight_id_should_generated(){
		String flightId = pageConfirmation.fnValidateFilghtBooking(); 
		System.out.println("Flight id is: " + flightId);
	    pageBlazeHome.closeApplication();
	}
	
}
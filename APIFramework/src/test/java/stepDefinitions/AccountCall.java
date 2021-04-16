package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class AccountCall {
	
	@Given("User is on Login page of Salesforce application")
	public void user_is_on_login_page_of_salesforce_application() {
	   System.out.println("User is on Login page of Salesforce application");
	}

	@When("User enters {string} and {string} and login to application")
	public void user_enters_and_and_login_to_application(String username, String password) {
		System.out.println("User enters {string} and {string} and login to application");
		System.out.println(username);
		System.out.println(password);
	}
	
	@And("Search for the {string}")
	public void search_for_the(String accountName) {
		System.out.println("Search for the {string}");
		System.out.println(accountName);
	}
	
	@And("Click on the Record a Call button")
	public void click_on_the_record_a_call_button() {
		System.out.println("Click on the Record a Call button");
	}
	
	@And("Enters the required fields in call record form")
	public void enters_the_required_fields_in_call_record_form() {
		System.out.println("Enters the required fields in call record form");
	}
	
	@And("Add the {string} and {string} in Attendees section")
	public void add_the_and_in_attendees_section(String attendee1, String attendee2) {
		System.out.println("Add the {string} and {string} in Attendees section");
		System.out.println(attendee1);
		System.out.println(attendee2);
	}
	
	@And("Select the {string} in Product Section")
	public void select_the_in_product_section(String product) {
		System.out.println("Select the {string} in Product Section");
		System.out.println(product);
	}
	
	@Then("Click on Save button and Submit the form")
	public void click_on_save_button_and_submit_the_form() {
		System.out.println("Click on Save button and Submit the form");
	}
	
	@And("Verify that Call is created successfully")
	public void verify_that_call_is_created_successfully() {
		System.out.println("Verify that Call is created successfully");
	}
}

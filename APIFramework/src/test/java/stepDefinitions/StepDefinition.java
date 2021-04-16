package stepDefinitions;


import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

@RunWith(Cucumber.class)
public class StepDefinition extends Utils {
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	
    @Given("AddPlace API Payload with {string} {string} and {string}")
    public void addplace_api_payload_with_and(String name, String language, String address) throws Throwable {						
		res  = given().log().all().spec(requestSpecification())
				.body(data.addPlacePayLoad(name, language, address));
    }

    @When("User calls {string} with {string} HTTP request")
    public void user_calls_with_http_request(String resource, String method) throws Throwable {
    	
    	APIResources resourceAPI = APIResources.valueOf(resource);
    	System.out.println(resourceAPI.getResource());
    	
    	resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	
    	if(method.equalsIgnoreCase("POST")) {
    		response = res.when().post(resourceAPI.getResource());
    	}
    	else if(method.equalsIgnoreCase("GET")) {
    		response = res.when().get(resourceAPI.getResource());
    	}
    	
    	
    	//response = res.when().post(resourceAPI.getResource())
    	//		.then().spec(resSpec).extract().response();
    }

    @Then("API call is success with Status code {int}")
    public void api_call_is_success_with_status_code(Integer code) throws Throwable {
    	assertEquals(response.getStatusCode(),200);
    }

    @And("^\"([^\"]*)\" in response is \"([^\"]*)\"$")
    public void something_in_response_is_something(String keyValue, String expectedValue) throws Throwable {
    	String responseString = response.asString();
		System.out.println("Add Place is " + responseString);
		// JsonPath js = new JsonPath(responseString);		
		assertEquals(getJsonPath(response, keyValue), expectedValue);
    }
    
    @And("Verify place_id created is maps to {string} using {string}")
    public void verify_place_id_created_is_maps_to_using(String expectedName, String resource) throws Throwable {
    	place_id = getJsonPath(response, "place_id");
    	res = given().spec(requestSpecification()).queryParam("place_id", place_id);
    	user_calls_with_http_request(resource, "GET");
    	String actualName = getJsonPath(response, "name");
    	assertEquals(actualName, expectedName);    	
    }
    
    @Given("DeletePlace API payload")
    public void deletaplace_api_payload() throws IOException {
    	res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }
    
    /*@Given("Test API Give")
    public void test_api_give() {
    	System.out.println("test api give");
    }
    */
    @When("Test API Wen")
    public void test_api_wen() {
    	System.out.println("test api wen");
    }
    
    @Then("Test API Ten")
    public void test_api_ten() {
    	System.out.println("test api ten");
    }
}

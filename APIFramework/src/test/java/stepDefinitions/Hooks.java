package stepDefinitions;

import com.fasterxml.jackson.databind.type.PlaceholderForType;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace or @TestTag")
	public void beforeScenario() throws Throwable {
		
		StepDefinition m = new StepDefinition();
		if(StepDefinition.place_id == null) {
			m.addplace_api_payload_with_and("Sumit", "French", "USA");
			m.user_calls_with_http_request("addPlaceAPI", "Post");
			m.verify_place_id_created_is_maps_to_using("Sumit", "getPlaceAPI");
		}
	}
}
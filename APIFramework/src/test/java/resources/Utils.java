package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static Properties prop = null;
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			RestAssured.baseURI="https://rahulshettyacademy.com";
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
		}
		return req;
	}
	
	public String getGlobalValue(String key) throws IOException {
		if(prop == null) {
			prop = new Properties();
			FileInputStream fs = new FileInputStream("C:\\Users\\sumit.a.sehgal\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
			prop.load(fs);
		}
		String value = prop.getProperty(key);
		return value;
	}
	
	public String getJsonPath(Response response, String key) {
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		return js.get(key).toString();
	}
	
	
}

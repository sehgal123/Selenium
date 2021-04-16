package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/features/"}, tags="@accountCall or @placeValidation", glue={"stepDefinitions"}, plugin="json:target/jsonReports/cucumber-reports.json")

//tags= "@DeletePlace"

public class TestRunnerCall {

}

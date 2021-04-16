package com.demo.cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	 features = {"src/test/java/com/demo/tests/TestSuite.feature"}, glue= {"com/demo/steps"},
	 plugin= {"html:target/jsonReports/cucumber-reports.html", "json:target/jsonReports/cucumber-reports.json"}
)
//"html:target/jsonReports/cucumber-reports.html", "json:target/jsonReports/cucumber-reports.json",
public class TestRunner {

}
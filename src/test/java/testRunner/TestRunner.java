package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features",
		glue={"stepDefinition","hooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"pretty","html:target/CucumberReport.html"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
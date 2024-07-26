package com.qa.restfulbooker.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features", 
		glue = {
					"com.qa.restfulbooker.stepdefs"
				}, 
		plugin = "json:target/jsonReports/cucmber-reports.json",
		dryRun=false,
		tags="@DeleteBooking"
	)
public class TestRunner {

}

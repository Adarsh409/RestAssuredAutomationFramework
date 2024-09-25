package com.qa.restfulbooker.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features", glue = { "com.qa.restfulbooker.stepdefs" }, plugin = {
		"json:target/jsonReports/cucmber-reports.json","pretty", "html:test-output.html" }, dryRun = false)
public class TestRunner {

}

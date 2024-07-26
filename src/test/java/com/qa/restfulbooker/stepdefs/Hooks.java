package com.qa.restfulbooker.stepdefs;

import com.qa.restfulbooker.resources.SpecBuilders;
import com.qa.restfulbooker.testcontext.TestContext;

import io.cucumber.java.Before;
import io.restassured.*;

public class Hooks {

	@Before
	public void beforeHooks() {
		TestContext.requestSpec = RestAssured.given().spec(SpecBuilders.getRequestSpec());
		
	}

}

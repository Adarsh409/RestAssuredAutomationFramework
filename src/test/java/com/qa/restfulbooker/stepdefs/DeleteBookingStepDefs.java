package com.qa.restfulbooker.stepdefs;

import com.qa.restfulbooker.testcontext.TestContext;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteBookingStepDefs {

	@Given("User does not provide access token")
	public void user_does_not_provide_access_token() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
		TestContext.requestSpec = RestAssured.given().contentType(ContentType.JSON);
	}

}

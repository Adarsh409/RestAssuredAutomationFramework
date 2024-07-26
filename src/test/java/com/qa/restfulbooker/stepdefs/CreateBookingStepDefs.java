package com.qa.restfulbooker.stepdefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.restfulbooker.resources.APIResources;
import com.qa.restfulbooker.resources.Payload;
import com.qa.restfulbooker.resources.SpecBuilders;
import com.qa.restfulbooker.testcontext.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class CreateBookingStepDefs {

//	@Given("User has CreateBooking payload")
//	public void user_has_create_booking_payload(DataTable dataTable) {
//		List<Map<String, String>> bookingDetailsList = dataTable.asMaps(String.class, String.class);
//		TestContext.resquestSpec = RestAssured.given().spec(SpecBuilders.getRequestSpec())
//				.body(Payload.formCreateBookingPayload(bookingDetailsList));
//
//	}
	
	@Given("User has {string} payload")
	public void user_has_payload(String apiName, DataTable dataTable) {
		List<Map<String, String>> bookingDetailsList = dataTable.asMaps(String.class, String.class);
		TestContext.requestSpec = TestContext.requestSpec.body(Payload.createPayload(apiName, bookingDetailsList));
	}

	@When("User calls {string} API with {string} http method")
	public void user_calls_api_with_http_method(String apiName, String httpMethod) {
		APIResources obj = APIResources.valueOf(apiName);
		if (httpMethod.equals("POST")) {
			TestContext.response = TestContext.requestSpec.when().post(obj.getResource());
		} else if (httpMethod.equals("GET")) {
			TestContext.response = TestContext.requestSpec.when().get(obj.getResource());

		} else if (httpMethod.equals("PUT")) {
			TestContext.response = TestContext.requestSpec.when().put(obj.getResource());
		}
		else if(httpMethod.equals("DELETE")) {
			TestContext.response = TestContext.requestSpec.when().delete(obj.getResource());
		}

	}

	@Then("User should get {int} response code")
	public void user_should_get_response_code(int responseCode) {
		System.out.println(TestContext.response.asString());
		Assert.assertEquals(responseCode, TestContext.response.getStatusCode());
	}

}

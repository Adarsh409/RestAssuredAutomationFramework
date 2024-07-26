package com.qa.restfulbooker.stepdefs;

import org.junit.Assert;

import com.qa.restfulbooker.pojo.Booking;
import com.qa.restfulbooker.pojo.BookingInfo;
import com.qa.restfulbooker.resources.SpecBuilders;
import com.qa.restfulbooker.testcontext.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;


public class GetBookingStepDefs {
	int bookingId;
	

	@Then("Booking id should be returned in reponse")
	public void booking_id_should_be_returned_in_reponse() {
		BookingInfo bookingInfoObj = TestContext.response.as(BookingInfo.class);
		bookingId = bookingInfoObj.getBookingid();
		System.out.println("Booking Id:"+bookingId);
		Assert.assertNotNull(bookingId);
	}

	@Given("User passes booking id in request URI")
	public void user_passes_booking_in_id_request_uri() {
		TestContext.requestSpec = TestContext.requestSpec.pathParam("bookingId",
				bookingId);

	}

	@Then("First name returned should be {string} and last name should be {string}")
	public void first_name_returned_should_be_and_last_name_should_be(String firstName, String lastName) {
		Booking bookingObj = TestContext.response.as(Booking.class);
		Assert.assertEquals(firstName, bookingObj.getFirstname());
		Assert.assertEquals(lastName, bookingObj.getLastname());
	}

}

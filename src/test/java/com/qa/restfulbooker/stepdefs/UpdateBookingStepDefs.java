package com.qa.restfulbooker.stepdefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.restfulbooker.pojo.Booking;
import com.qa.restfulbooker.resources.Payload;
import com.qa.restfulbooker.testcontext.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateBookingStepDefs {

	@Then("Check in date should be updated to {string} and Check out date should be updated to {string}")
	public void check_in_date_should_be_updated_to_and_check_out_date_should_be_updated_to(String checkInDate,
			String checkOutDate) {
		Booking bookingObj = TestContext.response.as(Booking.class);
		Assert.assertEquals(checkInDate, bookingObj.getBookingdates().getCheckin());
		Assert.assertEquals(checkOutDate, bookingObj.getBookingdates().getCheckout());

	}

	@Given("User has {string} payload to update booking dates")
	public void user_has_payload_to_update_booking_dates(String apiName, DataTable dataTable) {
		List<Map<String, String>> bookingDetailsList = dataTable.asMaps(String.class, String.class);
		TestContext.requestSpec = TestContext.requestSpec.body(Payload.createPayload(apiName, bookingDetailsList));
	}

}

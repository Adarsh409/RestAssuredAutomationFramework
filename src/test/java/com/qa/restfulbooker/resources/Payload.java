package com.qa.restfulbooker.resources;

import java.util.List;
import java.util.Map;

import com.qa.restfulbooker.pojo.Booking;
import com.qa.restfulbooker.pojo.BookingDates;

public class Payload {

	public static Object createPayload(String apiName, List<Map<String, String>> requestParametersList) {
		Object obj = null;
		switch (apiName) {
		case "CreateBooking": {
			obj = formCreateUpdateBookingPayload(requestParametersList);
			break;
		}
		case "UpdateBooking": {
			obj = formCreateUpdateBookingPayload(requestParametersList);
			break;
		}
		}
		
		return obj;

	}

	public static Booking formCreateUpdateBookingPayload(List<Map<String, String>> bookingDetailsList) {
		Booking bookingObj = new Booking();
		BookingDates bookingDatesObj = new BookingDates();
		bookingObj.setFirstname(bookingDetailsList.get(0).get("firstname"));
		bookingObj.setLastname(bookingDetailsList.get(0).get("lastname"));
		bookingObj.setTotalprice(Double.parseDouble(bookingDetailsList.get(0).get("totalprice")));
		bookingObj.setDepositpaid(Boolean.parseBoolean(bookingDetailsList.get(0).get("depositpaid")));
		bookingDatesObj.setCheckin(bookingDetailsList.get(0).get("checkindate"));
		bookingDatesObj.setCheckout(bookingDetailsList.get(0).get("checkoutdate"));
		bookingObj.setBookingdates(bookingDatesObj);
		bookingObj.setAdditionalneeds(bookingDetailsList.get(0).get("additionalneeds"));
		return bookingObj;

	}

	

}

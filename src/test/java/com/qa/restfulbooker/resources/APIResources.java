package com.qa.restfulbooker.resources;

public enum APIResources {
	
	CreateBooking(""),
	GetBooking("/{bookingId}"),
	UpdateBooking("/{bookingId}"),
	DeleteBooking("/{bookingId}"),
	PartialUpdateBooking("/{bookingId}");
	
	private String resource;
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}

package com.qa.restfulbooker.resources;

import io.restassured.specification.RequestSpecification;

import io.restassured.builder.*;
import io.restassured.http.ContentType;

public class SpecBuilders {

	public static RequestSpecification getRequestSpec() {
		RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/booking")
				.setContentType(ContentType.JSON).addHeader("Cookie", TokenGenerator.generateToken()).build();
		return res;

	}

}

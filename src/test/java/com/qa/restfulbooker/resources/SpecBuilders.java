package com.qa.restfulbooker.resources;

import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.*;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class SpecBuilders {
	public static RequestSpecification res;
	public static RequestSpecification getRequestSpec() {
		PrintStream log = null;
		if(res == null) {
			try {
				log = new PrintStream(
						new FileOutputStream(".//logging.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 res = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/booking")
					.setContentType(ContentType.JSON).addHeader("Cookie", TokenGenerator.generateToken())
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();
			
		}
		return res;
	}

}

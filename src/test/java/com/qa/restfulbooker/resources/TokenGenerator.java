package com.qa.restfulbooker.resources;

import com.qa.restfulbooker.pojo.Auth;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class TokenGenerator {

	// To generate access token
	public static String generateToken() {
		Auth authObj = new Auth();
		authObj.setUsername("admin");
		authObj.setPassword("password123");
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";
		String responseString = RestAssured.given().contentType(ContentType.JSON).body(authObj).when().post().then()
				.extract().response().asString();
		JsonPath jsonPath = new JsonPath(responseString);
		return "token=" + jsonPath.get("token");

	}

}

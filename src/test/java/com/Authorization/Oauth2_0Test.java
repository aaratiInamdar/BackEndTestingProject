package com.Authorization;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Oauth2_0Test {

	@Test
	public void sampleTest()
	{
//		API -1 get auth to API 1  [KeyClock ( Since we don't have access to the this client side application we used already available information)
		Response response = given()
						            .formParam("client_id","ninza-client")
						            .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
									.formParam("grant_type", "client_credentials")
							.when()
									.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
											
							response  .then()
							          .log().all();
							
//	capture the token from response from [KeyClock [Oauth 2.0] ] ] 
							
		String  token = response.jsonPath().get("access_token");
		given()
				.auth().oauth2(token)
				.log().all()
		.when()
				.get("http://49.249.28.218:8091/projects")
		
		.then()
				.log().all();
	}
}

package com.Practice.ResponseValidation;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class VerifyResponseHeaderTest {

	
	@Test
	public void verifyHeader()
	{
		Response resp= given().
		                    get("http://49.249.28.218:8091/projects");
		resp.then().log().all();
		
				resp.then().assertThat().statusCode(200);
				resp.then().assertThat().contentType(ContentType.JSON);
				
//				if we want to validate the any line from the response body
//				resp.then().assertThat().statusLine("line of response body");
				
//				if we want to validate the any key value pair fromt he body then we go for this method 
//				resp.then().assertThat().header("key", "value");
	}
}

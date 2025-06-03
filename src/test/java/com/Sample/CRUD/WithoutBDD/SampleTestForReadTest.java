package com.Sample.CRUD.WithoutBDD;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {

	
	@Test
	public void getDtaFromServer()
	{
		Response response = RestAssured.get("http://49.249.28.218:8091/projects");
		
//		prettyPrint() will display the resposne in the form of JSON
		System.out.println(response.prettyPrint());
		
		response.then().assertThat().statusCode(200);
		
//		it will display the complete log of the response body
		response.then().log().all();
//		asString() will give response in the form of String so we go for prettyPrint()
//		System.out.println(response.asString());
	}
}

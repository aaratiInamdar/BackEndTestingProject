package com.Sample.CRUD.WithoutBDD;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {

	
	@Test
	public void getDtaFromServer()
	{
		Response response = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_17994");
		
		response.then().assertThat().statusCode(204);
		response.then().log().all();

	}
}

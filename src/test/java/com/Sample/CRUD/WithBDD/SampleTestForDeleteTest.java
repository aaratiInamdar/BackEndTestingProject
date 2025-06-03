package com.Sample.CRUD.WithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class SampleTestForDeleteTest {

	
	@Test
	public void getDtaFromServer()
	{
		
		given()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_18029")
		
		.then()
		.assertThat().statusCode(204)
		.log().all();	

	}
}

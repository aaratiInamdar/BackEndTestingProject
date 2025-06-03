package com.TypesOfParameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class ParamParameterTest {

	@Test
	public void sampleTest()
	{
		given()
				.param("projectId", "NH_PROJ_18158")
				.log().all()
					
		.when()
				.post("http://49.249.28.218:8091/project")
		.then()
				.log().all();
	}
}

package com.Practice.PostRequestTypes;


import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PostReq_Via_HashMap {

	@Test
	public void postDataToServer()
	{
		HashMap<String,Object> map= new HashMap();
		map.put("createdBy", "Deepak");
		map.put("status", "created");
		map.put("teamSize",0);
		map.put("projectName", "Orange7");
		
	
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}

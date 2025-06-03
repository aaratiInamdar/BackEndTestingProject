package com.Sample.CRUD.WithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForPartialUpdate {

	
	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("projectName", "Navi_Mumbai_35");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString()).
		
		when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_18029")
	
		.then()
		.log().all();
		
			
		
	}
	
}

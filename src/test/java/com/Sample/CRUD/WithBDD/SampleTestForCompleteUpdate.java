package com.Sample.CRUD.WithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForCompleteUpdate {

	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Aarati");
		jsonObj.put("projectName", "Navi_Mumbai_1");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
			
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString()).
		
		when()
		.put("http://49.249.28.218:8091/project/NH_PROJ_18029").
		
		then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	
}

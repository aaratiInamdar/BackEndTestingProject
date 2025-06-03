package com.Sample.CRUD.WithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class SampleTestForCreateTest {

	
	@Test
	public void postDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Aarati");
		jsonObj.put("projectName", "Mumbai_38");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
			
//		precondition
		Response resp = given()
		.contentType(ContentType.JSON)
//		.auth().oauth2("")
		.body(jsonObj.toJSONString()).
		
//		http methods
		when()
		.post("http://49.249.28.218:8091/addProject");
		
//		validation
		resp.then()
		.assertThat().statusCode(201)
		.log().all();

		resp.then().assertThat().statusLine("HTTP/1.1 201 ");
	 resp.then().assertThat().header("Transfer-Encoding", "chunked");
		
	}
}

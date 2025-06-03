package com.Sample.CRUD.WithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {

	
	@Test
	public void postDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Aarati");
		jsonObj.put("projectName", "Mumbai_1");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
			
		RequestSpecification req = RestAssured.given();
		
		req.contentType(ContentType.JSON);
		
//		toJSONString() converts jsonObj map into the complete json format of string before passing inside the body 
		req.body(jsonObj.toJSONString());
		
		Response response = req.post("http://49.249.28.218:8091/addProject");
		response.then().log().all();
		response.then().assertThat().statusCode(201);
		
	}
}

package com.Sample.CRUD.WithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdate {

	
	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("projectName", "Navi_Mumbai_35");
		
			
		RequestSpecification req = RestAssured.given();
		
		req.contentType(ContentType.JSON);
		

		req.body(jsonObj.toJSONString());
		
		Response response = req.patch("http://49.249.28.218:8091/project/NH_PROJ_17994");
		response.then().log().all();
		response.then().assertThat().statusCode(200);
	}
	
}

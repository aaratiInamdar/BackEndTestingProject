package com.Practice.PostRequestTypes;

import org.testng.annotations.Test;
import com.POJOClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.Random;


public class PostReq_Via_POJOClass {

	@Test
	public void postDataToServer()
	{
	
//		create object for pojo class 
		Random random=new Random();
		int randomNum = random.nextInt(100);
		
		
		ProjectPojo pObj=new ProjectPojo("Orange"+randomNum, "Created", "Aarati", 0);
		given()
		.contentType(ContentType.JSON)
		.body(pObj)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}

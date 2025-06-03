package com.ReqChaining;

import org.testng.annotations.Test;
import com.POJOClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.Random;


public class Scenario1_DeletePrj_ReqChaining {

	@Test
	public void postDataToServer()
	{
	
//		create object for pojo class 
		Random random=new Random();
		int randomNum = random.nextInt(100);
		
//		API Request 1==> add project inside the server 
		ProjectPojo pObj=new ProjectPojo("Airtel"+randomNum, "Created", "Aarati", 0);
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pObj)
		
		.when()
		.post("http://49.249.28.218:8091/addProject");
		
		response.then()
		.assertThat().statusCode(201)
		.log().all();
		
//		capture data/project name from the response
		String  prjName = response.jsonPath().get("projectName");
		String prjId= response.jsonPath().get("projectId");
		System.out.println(prjId);
		
		
//		API 2 ==> delete the project
				given()
				   		.delete("http://49.249.28.218:8091/project/"+prjId)
				   		
			.then()
				 .log().all();
	}
}

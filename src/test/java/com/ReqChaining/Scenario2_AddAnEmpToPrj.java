package com.ReqChaining;

import static io.restassured.RestAssured.*;
import java.util.Random;
import org.testng.annotations.Test;

import com.POJOClassUtility.EmployeePojoClass;
import com.POJOClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario2_AddAnEmpToPrj {

	@Test
	public void sampleTest()
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
		System.out.println(prjName);
		
//		API2 ==>Add emp to same Project
//		String designation, String dob, String email, String empName, double experience,
//		String mobileNo, String project, String role, String username
		
		
		
		EmployeePojoClass empPojo=new EmployeePojoClass( "Architect", " 24/04/1983", "abc@gmail.com", "Rushi" +randomNum, 18,
				 "1234567890",  prjName,  "Role_Employee", "Rushi"+randomNum);
		
		 given()
			.contentType(ContentType.JSON)
			.body(empPojo)
			
		.when()
			.post("http://49.249.28.218:8091/employees")
			
		.then()
			.assertThat().statusCode(201)
		     .log().all();
		 
		 
		
	}
	
}

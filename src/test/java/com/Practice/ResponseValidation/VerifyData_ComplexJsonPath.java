package com.Practice.ResponseValidation;

import static io.restassured.RestAssured.*;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyData_ComplexJsonPath {

	@Test
	public void sampleTest()
	{
		
		Response responseBody = given()
				
		        .get("http://49.249.28.218:8091/projects-paginated");
		        
				responseBody.then().log().all();
				
				List<String> allProjectId = JsonPath.read(responseBody.asString(),"content[*].projectId");
				System.out.println(allProjectId);
				
				List<String> allProjectName = JsonPath.read(responseBody.asString(),"content[*].projectName");
				
//				we  used for loop for the better look of list...thats line by line 
				for (String prjName : allProjectName)
				{
					System.out.println(prjName);
				}
				
				List<String> prjNameOnConditions = JsonPath.read(responseBody.asString(),"content[*].[?(@.createdBy==\"deepak\")].projectName");
				System.out.println(prjNameOnConditions);
				
//				 if we want to fetch any one single data
				List<String> prjId = JsonPath.read(responseBody.asString(),"content[*].[?(@.createdBy==\"deepak\")].projectId");
				String actPrjId = prjId.get(0);
				Assert.assertEquals(actPrjId, "TY_Project_2001");
				
//				Extract any one data 
//				DB Validation 
//				Request Chaining 
		}
	
}

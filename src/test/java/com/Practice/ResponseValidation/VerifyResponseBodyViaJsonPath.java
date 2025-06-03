package com.Practice.ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBodyViaJsonPath {

	
	@Test
	public void sampleTest()
	{
		Response responseBody = given()
							        .get("http://49.249.28.218:8091/projects-paginated");
							        
									responseBody.then().log().all();
								
									responseBody.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
									responseBody.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
									responseBody.then().assertThat().body("content[0].projectId", Matchers.equalTo("TY_PROJ_4444"));

									
//									TestNG methods ..instead of these we go for assertion inbuilt methods
									
									int data1 = responseBody.jsonPath().get("numberOfElements");
									System.out.println(data1);
									boolean data2 = responseBody.jsonPath().get("pageable.sort.unsorted");
									System.out.println(data2);
									String data3 = responseBody.jsonPath().get("content[0].projectId");
									System.out.println(data3);
									
									ArrayList<String> allProjectId = responseBody.jsonPath().get("content.projectId");
									System.out.println(allProjectId);
	}	
}

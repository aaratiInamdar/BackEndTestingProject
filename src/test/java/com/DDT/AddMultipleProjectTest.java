package com.DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest {
	
	@Test(dataProvider = "getData")
	public void sampleTest(String projectName,String status)
	{
		
		String reqBody="{\r\n"
				+ "  \"createdBy\": \"string\",\r\n"
				+ "  \"projectName\": \""+projectName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given()	
					.contentType(ContentType.JSON)
					.body(reqBody)
		.when()
					.post("http://49.249.28.218:8091/addProject")
					
		.then()
					.log().all();	
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] objArray=new Object[3][2];
		objArray[0][0]="AirIndia-1";
		objArray[0][1]="Created";
		
		objArray[1][0]="AirIndia-2";
		objArray[1][1]="Created";
		
		objArray[2][0]="AirIndia-3";
		objArray[2][1]="Created";
		return objArray;
		
	}
}

package com.DDT;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.FileUtility.ExcelUtility;
import io.restassured.http.ContentType;

public class AddMultipleProjectUsingExcelTest {

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
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu=new ExcelUtility();
				int count= eu.getLastRowNum();
		Object[][] objArray=new Object[count][2];
		
		for(int i=0 ; i<count ; i++)
		{
			objArray[i][0]=eu.getDataFromExcel(i+1, 0);
			objArray[i][1]=eu.getDataFromExcel(i+1, 1);
		}
		
		return objArray;
		
	}
}

package com.Encryption;

import org.testng.annotations.Test;
import com.EncryptAndDecriptUtility.EncryptAndDecriptUtility;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UpdatePayrollViaAESEncryption {

	
	@Test
	public void sampleTest() throws Exception
	{
		EncryptAndDecriptUtility ed=new EncryptAndDecriptUtility();
		
		String jBody="{ \"employee\": { \"empId\":\"NH_03000\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"user_2799\", \"experience\": 7, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 5000, \"insurance\": 5000, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active” }";
		
		String jReqBody=ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		
		Response response = given()
					.body(jReqBody)
		.when()
					.put("http://49.249.28.218:8091/payroll");
		response.then()
					.log().all();
		
		String respBody = ed.encrypt(response.getBody().asString(), "Ac03tEam@j!tu_#1");
		System.out.println(respBody);
				
	}
}

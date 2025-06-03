package PracticeForCRUD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class ShopStack2 {

	@Test
	public void shopStack()
	{
		
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("email", "abcd3599@gmail.com");
		jsonObj.put("password", "test@123");
		jsonObj.put("role", "SHOPPER");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj)
		
		.when()
		.post("https://www.shoppersstack.com/shopping/users/login")
		
		.then()
		.log().all()
		.statusCode(200)
		.contentType(ContentType.JSON);
		
	}	
}

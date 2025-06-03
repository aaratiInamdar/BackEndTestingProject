package PracticeForCRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class ShopperStack {
	@Test
	public void shopperstack()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("city", "mumbai");
		jsonObj.put("country", "India" );
		jsonObj.put("email", "abcd35@gmail.com");
		jsonObj.put("firstname","aarati");
		jsonObj.put("gender", "female");
		jsonObj.put("lastname","inamdar");
		jsonObj.put("password","test@123");
		jsonObj.put("phone",9892-41240);
		jsonObj.put("state","maharashtra");
		jsonObj.put("zoneId", "ALPHA");
		
		given()	
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.queryParam("zoneId", "ALPHA")
			
		.when()
		.post("http://www.shoppersstack.com/shopping/shoppers")
		
		.then()
		.log().all()
//		.statusCode(201)
		.contentType(ContentType.JSON);
		
	}
}

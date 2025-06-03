package NinzaHrm;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.JavaUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class PostOperation {	

	 String  projectId;
	 JavaUtility ju=new JavaUtility();
	@Test
	public void performCreate()
	{		
		System.out.println("performCreate executed");
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "AARATI");
		jsonObj.put("projectName", "Hello" +ju.getRandomNumber(100));
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize",0);
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.post("http://49.249.28.218:8091/addProject");
		
		
		resp.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		projectId=  resp.path("projectId");
		System.out.println(projectId);
	}
	
	@Test
	public void getOperation()
	{
		System.out.println("getOperation executed");
		given()
		.contentType(ContentType.JSON)
				
		.when()
		.get("http://49.249.28.218:8091/project/" +projectId)
		
		.then()
		.assertThat().log().all()
		.contentType(ContentType.JSON);
	}
	
	@Test
	public void putOperation()
	{
		System.out.println("putOperation executed");
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "AARATI_Inamdar");
		jsonObj.put("projectName", "Hello" + ju.getRandomNumber(1000));
		jsonObj.put("status", "Completed");
		jsonObj.put("teamSize",0);
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		
		.when()
		.put("http://49.249.28.218:8091/project/" + projectId)
			
		.then()
		.log().all()
		.contentType(ContentType.JSON);
//		.statusCode(200);	
	}
	
	@Test
	public void performDelete() 
	
	{	
		System.out.println("performDelete executed");
		Response resp = given()
		.contentType(ContentType.JSON)
		
		.when()
		.delete("http://49.249.28.218:8091/project/" +projectId);
		
		resp.then()
		.contentType(ContentType.JSON)
		.statusCode(204);
		
		System.out.println("commit 1");
		System.out.println("commit 2");
		
		
	}
}

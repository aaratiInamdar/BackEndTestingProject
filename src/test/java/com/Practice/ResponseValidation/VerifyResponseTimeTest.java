package com.Practice.ResponseValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class VerifyResponseTimeTest {

	
	@Test
	public void verifyHeaderTime()
	{
		Response resp= given().
                get("http://49.249.28.218:8091/projects");
		
			resp.then().log().all();	
			long timeTaken = resp.time();
			
//			 it will give time in second
			long timeTakenSec = resp.timeIn(TimeUnit.SECONDS);

			System.out.println(timeTaken);
			System.out.println(timeTakenSec);			
			
			resp.then().assertThat().time(Matchers.lessThan(900L));
			resp.then().assertThat().time(Matchers.greaterThan(300L));
			resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
	}
}

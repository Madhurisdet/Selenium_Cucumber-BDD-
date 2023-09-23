package testbookApi;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class testUsersData {
	 
	@Test(priority =1)
	public void getUserDetails() 
	{
		given()
	
		.when()
		.get("https://reqres.in/api/users")
		
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void createUser() {
		
		HashMap data = new HashMap();
		data.put( "name", "madhuri");
		data.put("job", "leader");
		
		Response res =
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		
		.then()
		 .statusCode(201)
		 .log().all()
		 .extract().response();
		
		String stringJSon = res.asString();
		Assert.assertEquals(stringJSon.contains("George"), true);
		
		
	}

}

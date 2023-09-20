package testbookApi;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;

import org.testng.annotations.Test;

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
	void createUser() {
		
		HashMap data = new HashMap();
		data.put( "name", "madhuri");
		data.put("job", "leader");
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		
		.then()
		 .statusCode(201)
		 .log().all()
		;
	}

	
	
}

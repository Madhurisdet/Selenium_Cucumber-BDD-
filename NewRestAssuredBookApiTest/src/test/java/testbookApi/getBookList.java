package testbookApi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.ResponseBody;

public class getBookList {

	@Test
	public void getAllBookList()
	{
		given()
		
		.when()
		.get("https://simple-books-api.glitch.me/books")
		
		.then()
		.statusCode(200)
		.log().all();
	
	}
	
}

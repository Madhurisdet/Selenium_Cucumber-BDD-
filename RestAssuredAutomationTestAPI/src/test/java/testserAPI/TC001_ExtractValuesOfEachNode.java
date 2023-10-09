package testserAPI;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_ExtractValuesOfEachNode {
	
	@Test
	public void getEachNodeValue()
	{
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		
		//request object
		RequestSpecification httpRequest = RestAssured.given(); 
		
		//response object
		Response response = httpRequest.request(Method.GET,  "/4180"); //originally we get response in JSON format
		 
		//response into string
		 String  responsebody = response.getBody().asString();
		 System.out.println("Response body is:" +responsebody);
		 
		  JsonPath jsonpath = response.jsonPath();//to get values from response
		  System.out.println(jsonpath.get("id"));
		  System.out.println(jsonpath.get("name"));
		  System.out.println(jsonpath.get("email"));
		  System.out.println(jsonpath.get("gender"));
		  System.out.println(jsonpath.get("status"));
		  
		  Assert.assertEquals(jsonpath.get("name"), "Chakravarti Johar DVM");
		  Assert.assertEquals(response.getStatusCode(), 200);
		  
	

	}
}

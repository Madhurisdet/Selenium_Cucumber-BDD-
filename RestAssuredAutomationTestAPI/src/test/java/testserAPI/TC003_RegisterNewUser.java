package testserAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_RegisterNewUser {

	   @Test
	   public void testregisterNewuser() {
		
	    RestAssured.baseURI = "https://gorest.co.in/public/v2";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload sending along with the post request
		JSONObject reqparam = new JSONObject();
		reqparam.put("name", "Maaadhhurii12345 1KhatkePatil");
		reqparam.put("email", "Maaadhhurii12335_1krishnadasa@heller.co");
		reqparam.put( "gender", "female");
		reqparam.put("status", "active");
		
		//sending token key with request
		String token = "6879dfc387a689ebb193ac7dd112d0c61b5aa6cee294140cf31c0a3b0477f238";
		httpRequest.header("Authorization", "Bearer " +token);
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(reqparam.toJSONString());
		
		//using request object sending request of specific type
		Response response = httpRequest.request(Method.POST,"/users");
		
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody is :\n"+responseBody);
		
		
		//Status code validation 
		int statuscode =response.getStatusCode();
		System.out.println("Status Code is : "+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		//validating Status Line
		String statusLine =response.getStatusLine();
		System.out.println("Status Line is : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		
		//********Question to ask in class********
		//validating response id
		//String responseID = response.jsonPath().get("id");
		//Assert.assertEquals(responseID, );
		
		Assert.assertEquals(responseBody.contains("id"), true);
	}

		
	}


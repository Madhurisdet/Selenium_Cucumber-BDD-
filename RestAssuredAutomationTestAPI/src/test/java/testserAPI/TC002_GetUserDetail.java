package testserAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class TC002_GetUserDetail {
	
		@Test
	     void testUserDetail() {

			//specify base URI
			RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
			
			//Request object
			RequestSpecification httpRequest = RestAssured.given();
			
			
			//using request object sending request of specific type
			Response response = httpRequest.request(Method.GET,  "4179"); //returns response like header,status,cookies details
			
			//print response in console window
			String responseBody = response.getBody().asString(); //detail response in string format
			System.out.println("ResponseBody is :\n"+responseBody);
			
			
			//Status code validation 
			int statuscode =response.getStatusCode();
			System.out.println("Status Code is : "+statuscode);
			Assert.assertEquals(statuscode, 200);
			
			//validating Status Line
			String statusLine =response.getStatusLine();
			System.out.println("Status Line is : "+statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");	
			
			//validating/capture Content Type  header from response.
			String contentType = response.header("Content-Type");
			System.out.println("Content type is:"  +contentType);
			Assert.assertEquals(contentType, "application/json; charset=utf-8");
			
			
			//getting all the headers details
			 Headers allheaders = response.headers();  //headers() method will get all the headers details
			 
			 for(Header header : allheaders) //for each to iterate over all the headers value
			 {
				 System.out.println(header.getName() +" --> "+header.getValue()); //return all headers key value pair
			 }
			 
			 Assert.assertEquals(responseBody.contains("4179"), true);
			 
		}
	}

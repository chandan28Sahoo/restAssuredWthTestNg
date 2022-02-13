package basicsOfRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;







public class GetUsers {

	@Test
	public static void listOfUsers() {
		/*
		//specify base url
		RestAssured.baseURI = "https://reqres.in/api/users";
		// request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		Response response = httpRequest.request(Method.GET);
		
		String responsebodyString = response.getBody().asPrettyString();
		System.out.println(responsebodyString);
		*/
		Response response = get("https://reqres.in/api/users");
		String responsebodyString = response.getBody().asPrettyString();
		System.out.println(responsebodyString);
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		// status line
		String statuslinString = response.getStatusLine();
		System.out.println(statuslinString);
//		Assert.assertEquals(statuslinString, "HTTP/1.1 200 OK");

		
	}
	
	
	@Test
	public static void listOfUsers02() {
		given().get("https://reqres.in/api/users").then().statusCode(200);
		
	}
	@Test
	public static void listOfUsers03() {
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7)).log().all();
		
	}
	@Test
	public static void particularUserDetails() {
		/*
		//specify base url
		RestAssured.baseURI = "https://reqres.in/api/users?page=";
		// request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		Response response = httpRequest.request(Method.GET,"2");
		
		String responsebodyString = response.getBody().asPrettyString();
		System.out.println(responsebodyString);
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		// status line
		String statuslinString = response.getStatusLine();
		System.out.println(statuslinString);
		*/
	}
}

package basicsOfRestAssured;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUsser {
	@Test
	public static void updateUserDetails() {
		JSONObject requestJsonObject = new JSONObject();
		requestJsonObject.put("name", "raghabh");
		requestJsonObject.put("job", "teacher");
		System.out.println(requestJsonObject.toJSONString());
		given().body(requestJsonObject.toJSONString())
		.header("Content-Type","application/json").contentType(ContentType.JSON)
		.when()
		.put("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
	}
	
	@Test
	public static void updateUserDetailsWithPatch() {
		JSONObject requestJsonObject = new JSONObject();
		requestJsonObject.put("name", "raghabh");
		requestJsonObject.put("job", "dancer");
		System.out.println(requestJsonObject.toJSONString());
		given().body(requestJsonObject.toJSONString())
		.header("Content-Type","application/json").contentType(ContentType.JSON)
		.when()
		.patch("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
	}
}

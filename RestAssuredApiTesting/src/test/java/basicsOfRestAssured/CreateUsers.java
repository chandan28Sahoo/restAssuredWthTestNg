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

public class CreateUsers {
	@Test
	public static void createUser() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "raghabh");
//		map.put("job", "automation");
//		System.out.println(map);
		JSONObject requestJsonObject = new JSONObject();
		requestJsonObject.put("name", "raghabh");
		requestJsonObject.put("job", "automation");
		System.out.println(requestJsonObject.toJSONString());
		given().body(requestJsonObject.toJSONString())
		.header("Content-Type","application/json").contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then().statusCode(201).log();
	}
}

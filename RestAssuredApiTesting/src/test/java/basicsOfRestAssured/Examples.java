package basicsOfRestAssured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Examples {

	@Test
	public void test_get_user() {
		baseURI = "http://localhost:3000/";
		given().get("/users")
		.then().statusCode(200).log().all();
	}
	@Test
	public void test_get_subject() {
		baseURI = "http://localhost:3000/";
		given().param("name", "Automation").get("/subjects")
		.then().statusCode(200).log().all();
	}
	@Test
	public void test_post_user() {
		baseURI = "http://localhost:3000/";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", "debika");
		jsonObject.put("lastName", "das");
		jsonObject.put("subjectId", 1);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type","application/json")
		.body(jsonObject.toJSONString())
		.when().post("/users")
		.then()
		.statusCode(201).log().all();
	}
	@Test
	public void test_post_subject() {
		baseURI = "http://localhost:3000/";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 3);
		jsonObject.put("name", "devOps");

		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type","application/json")
		.body(jsonObject.toJSONString())
		.when().post("/subjects")
		.then()
		.statusCode(201).log().all();
	}
	@Test
	public void test_put_users() {
		baseURI = "http://localhost:3000/";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", "debika");
		jsonObject.put("lastName", "dass");
		jsonObject.put("subjectId", 1);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type","application/json")
		.body(jsonObject.toJSONString())
		.when().put("/users/4")
		.then()
		.statusCode(200).log().all();
	}
	
	@Test
	public void delete_user() {
		baseURI = "http://localhost:3000/";
		
		when().delete("/users/4").then().statusCode(200);
	}
}

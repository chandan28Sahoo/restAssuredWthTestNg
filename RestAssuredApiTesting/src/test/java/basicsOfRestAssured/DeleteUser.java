package basicsOfRestAssured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteUser {
	@Test
	public static void deleteUserDetatils() {
		when()
		.patch("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
	}
}

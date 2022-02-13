package basicsOfRestAssured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples1 {
	
	@DataProvider
	public Object[][] postData() {
		Object [][] dataObjects = new Object[2][3];
		dataObjects[0][0] = "debika";
		dataObjects[0][1] = "das";
		dataObjects[0][2] = 3;
		
		dataObjects[1][0] = "mihir";
		dataObjects[1][1] = "das";
		dataObjects[1][2] = 2;
		
		return dataObjects;
	}
	
	@Test(dataProvider = "postData")
	public void testPost(String firstName, String lastName, int subjectId) {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("firstName", firstName);
		jsonObject.put("lasttName", lastName);
		jsonObject.put("subjectId", subjectId);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type","application/json")
		.body(jsonObject.toJSONString())
		.when().post("/users").then().statusCode(201).log().all();	
	}
	@DataProvider
	public Object[] deleteData() {
		return new Object[] {
				4,5
		};
	}
	
	@Test(dataProvider = "deleteData")
	public void delete_user(int data) {
		baseURI = "http://localhost:3000/";
		
		when().delete("/users/"+data).then().statusCode(200);
	}
}

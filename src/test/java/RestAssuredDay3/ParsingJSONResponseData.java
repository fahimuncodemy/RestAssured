package RestAssuredDay3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ParsingJSONResponseData {

	@Test
	void testJSONResponse() throws FileNotFoundException
	{
		//Approach 1
		File fp=new File(".\\data.json");
		FileReader fr=new FileReader(fp);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject js=new JSONObject(jt);
		
		given()
			.contentType(ContentType.JSON)
			.body(js.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("name", equalTo("morpheus"))
			.body("skill[2]", equalTo("TestNG"))
			.body("Departments[1].Branch", equalTo("Science"));
	}
}

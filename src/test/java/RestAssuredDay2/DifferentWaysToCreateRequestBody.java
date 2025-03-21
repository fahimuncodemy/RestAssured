package RestAssuredDay2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DifferentWaysToCreateRequestBody {

//	@Test
	void test_usingHashMap()
	{
		HashMap data=new HashMap();
		data.put("name", "Ravi");		
		data.put("job", "Electric Engineer");
	
		given()
			.contentType(ContentType.JSON)
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.body("name", equalTo("Ravi"))
			.body("job", equalTo("Electric Engineer"))
			.log().all();
	}
	
//	@Test
	void test_usingJsonLibrary()
	{
		JSONObject js=new JSONObject();
		js.put("name", "John");
		js.put("job", "Mechanical Engineer");
		
		given()
			.contentType("application/json")
			.body(js.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}
//	@Test
	void test_Pojo()
	{
		Post_pojo po=new Post_pojo();
		po.setName("William");
		po.setJob("Civil Engineer");
		
		given()
			.contentType(ContentType.JSON)
			.body(po)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	void test_extFile() throws FileNotFoundException
	{
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
			.log().all();
		
		
	}
}

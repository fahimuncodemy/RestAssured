package RestAssuredDay1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class HTTPRequests {
	
	int id;
	
//	@Test(priority=1)
	void getUser()
	{
		when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.body("data.email", equalTo("janet.weaver@reqres.in"))
			.body("data.id", equalTo(2))
			.log().all();
		System.out.println("****************************************************************************");
	}
	@Test(priority=2)
	void createUser()
	{
		HashMap ha=new HashMap();
		ha.put("name", "Abhishek");
		ha.put("job", "QA Engineer");
		
		id=given()
			.contentType("application/json")
//			.contentType(ContentType.JSON)
			.body(ha)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.body("name", equalTo("Abhishek"))
//			.log().all();
	}
	
	@Test(priority=3, dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap haup=new HashMap();
		haup.put("name", "Aniket");
		haup.put("job", "Architect");
		
		given()
			.contentType(ContentType.JSON)
			.body(haup)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test(priority=4, dependsOnMethods= {"createUser", "updateUser"})
	void deleteUser()
	{
		given()
			
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}

}

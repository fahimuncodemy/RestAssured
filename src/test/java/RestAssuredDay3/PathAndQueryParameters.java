package RestAssuredDay3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	@Test
	void testQueryAndPathParameters()
	{
		//https://reqres.in/api/users?page=2&id=5
		given()
			.pathParam("path", "users")
			.pathParam("path2", "api")
			.queryParam("page", 2)
			.queryParam("id", 5)
			
		.when()
			.get("https://reqres.in/{path2}/{path}")
			
		.then()
			.statusCode(200)
			.log().all();
	}

}

package APIChaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetUser {

	@Test
	void getUser(ITestContext context)
	{

		int id= (Integer)context.getAttribute("user_id");
		String bearerToken= "e6d5e0d570690ee78a1f9565f191e6aecb13b9e7c416143fc62d6ff3b2649e26";
		
		given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType(ContentType.JSON)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
		
	}
}

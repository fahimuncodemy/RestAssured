package APIChaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteUser {

	@Test
	void deleteUser(ITestContext context)
	{

		String bearerToken= "e6d5e0d570690ee78a1f9565f191e6aecb13b9e7c416143fc62d6ff3b2649e26";
		int id= (Integer)context.getAttribute("user_id");
		given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
	}
}

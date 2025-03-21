package APIChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class UpdateUser {
	
	@Test
	void updateUser(ITestContext context)
	{
		Faker fake=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", fake.name().fullName());
		data.put("gender", "Male");
		data.put("email", fake.internet().emailAddress());
		data.put("status", "Inactive");
		
		String bearerToken= "e6d5e0d570690ee78a1f9565f191e6aecb13b9e7c416143fc62d6ff3b2649e26";
		
		int id= (Integer)context.getAttribute("user_id");
		given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType(ContentType.JSON)
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}

}

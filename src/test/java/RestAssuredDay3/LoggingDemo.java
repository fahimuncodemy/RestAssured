package RestAssuredDay3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {
	
	@Test
	void testLogs()
	{
		when()
			.get("https://reqres.in/api/users?page=2&id=5")
		.then()	
//			.log().all();
//			.log().cookies();
//			.log().body();
			.log().headers();
	}

}

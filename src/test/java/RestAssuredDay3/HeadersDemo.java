package RestAssuredDay3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	@Test
	void testHeaders()
	{
		Response response= when()
			.get("https://reqres.in/api/users?page=2&id=5");
//		.then()
//			.header("Content-Type", "application/json; charset=utf-8")
//			.and()
//			.header("Connection", "keep-alive")
//			.and()
//			.header("Vary", "Accept-Encoding");
			
			String header_value= response.getHeader("Content-Type");
			System.out.println("The value of 'Content-Type' header is-->"+header_value);
			
			//get all headers info
			Headers myheaders=response.getHeaders();
			
			for(Header hd:myheaders)
			{
				System.out.println(hd.getName()+"\t"+hd.getValue());
			}
		
		
	}
}

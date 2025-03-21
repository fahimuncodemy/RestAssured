package RestAssuredDay3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookieDemo {

	@Test
	void testCookies()
	{	
		Response res=when()
			.get("https://www.google.com/");
//		.then()
//			.cookie("AEC", "AZ6Zc-UtDsk_5f8ifreIOW-G6COLPRobxNty4SOM2j955bIb-DuwZ2sTZIs")
//			.log().all();
		
		//get single cookie information
		String cookie_value= res.getCookie("AEC");
		System.out.println("Value of cookie 'AEC' is --->"+cookie_value);
		
		//get all cookie information
		Map<String, String> cookie_values= res.getCookies();
		
		System.out.println(cookie_values.keySet());
		
		for(String k:cookie_values.keySet())
		{
			String cook_value=res.getCookie(k);
			System.out.println(k+"\t"+cook_value);
		}
		
		
		
	}
	
	//AZ6Zc-WAobLniG5CzR5tVdCckl3c315EURo8WBH9FQmW7qodSH71QkpEuMk
	//519=vHsXChDne3d6v39hdgllc8bW5--eUEDdjt6UNiI6CFUDo8YfbutSig3MfnwKAJuHQxhsszMoyYycl9MsVtZgNFOPlfxyXW4TCGrCXmEowszxLYYMZI_20Og0hNxPAkyBooWCDLHK6Dcqtb7nQ9MLLunp82AD52u8Cfu-qapSoK64wDLi_0dekeYQdzcoLE1omxtJ
}

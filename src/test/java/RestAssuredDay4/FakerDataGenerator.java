package RestAssuredDay4;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	void testGenerateDummyData()
	{
		Faker faker=new Faker();
		
		String fullname= faker.name().fullName();
		String firstname= faker.name().firstName();
		String lastname= faker.name().lastName();
		
		String password= faker.internet().password();
		String email= faker.internet().emailAddress();
		String phoneno= faker.phoneNumber().cellPhone();
		
		System.out.println(fullname);
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phoneno);
	}

}

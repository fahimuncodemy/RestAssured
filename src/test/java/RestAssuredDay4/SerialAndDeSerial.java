package RestAssuredDay4;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerialAndDeSerial {
	
//	@Test
	void PojoToJson() throws JsonProcessingException
	{
		Pojo_user po=new Pojo_user();
		po.setName("Michael");
		po.setJob("Architect");
		po.setEmail("Michael@arch.com");
		po.setUsername("micharch");
		String skillset[]= {"Selenium", "TestNG", "Core Java"};
		po.setSkills(skillset);
		
		//convert java object to json object
		ObjectMapper objmap=new ObjectMapper();
		
		String jsondata= objmap.writerWithDefaultPrettyPrinter().writeValueAsString(po);
		
		System.out.println(jsondata);
		
	}
	@Test
	void JsonToPojo() throws JsonMappingException, JsonProcessingException
	{
		String jsondata= "{\r\n"
				+ "  \"name\" : \"Michael\",\r\n"
				+ "  \"job\" : \"Architect\",\r\n"
				+ "  \"email\" : \"Michael@arch.com\",\r\n"
				+ "  \"username\" : \"micharch\",\r\n"
				+ "  \"skills\" : [ \"Selenium\", \"TestNG\", \"Core Java\" ]\r\n"
				+ "}";
		
		//convert json to pojo
		ObjectMapper objmapper= new ObjectMapper();
		
		Pojo_user po=objmapper.readValue(jsondata, Pojo_user.class);
		
		System.out.println("Name: "+po.getName());
		System.out.println("Job: "+po.getJob());
		System.out.println("Email: "+po.getEmail());
		System.out.println("Username: "+po.getUsername());
		System.out.println("Skills: "+po.getSkills()[0]);
		System.out.println("Skills: "+po.getSkills()[1]);
	}

}

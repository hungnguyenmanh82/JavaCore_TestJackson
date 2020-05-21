package com.example;

import java.io.File;
import java.io.IOException;

import com.example.model.jackson.GoogleOauth2;
import com.example.model.jackson.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * lúc compile sẽ gộp "main/resources/" và "main/java/" vào 1 folder chung
 App81_https_Server.class.getResource("/") = root = main/resources/ = main/java/
 App81_https_Server.class.getResource("/abc") = main/resource/abc  = main/java/abc  
 //
 App81_https_Server.class.getResource("..") = root/pakage_name       => package_name của class này
 App81_https_Server.class.getResource(".") = root/pakage_name/ 
 App81_https_Server.class.getResource("abc") = root/pakage_name/abc
 App81_https_Server.class.getResource("abc").getPath()
  //===========================
  + Run or Debug mode trên Eclipse lấy ./ = project folder 
  
  + run thực tế:  ./ = folder run "java -jar *.jar"
 //========= 
 File("loginTest.json"):   file ở ./ folder    (tùy run thực tế hay trên eclipse)
 File("./abc/test.json"):   
 File("/abc"): root folder on linux (not window)
 */

//  http://www.jsonschema2pojo.org/
public class App1_Jackson {

	public static void main(String[] args) throws Exception {
		
//		exampleAll();
//		java2Json();
		
		jsonFiletoJava();
		
	}
	
	public static void exampleAll() throws Exception{
		//tạo JackSon object
		ObjectMapper mapper = new ObjectMapper();

		
		User obj = new User("hung","123",233,345,"abc","def","GPS",true);
		
		// ========================== Object to Json file
		//kiểm tra thư mục root của Project sẽ thấy file loginTest.json 
		mapper.writeValue(new File(App1_Jackson.class.getResource("/loginTest.json").getPath()), obj);

		// ========================== Object to Json string
		String jsonInString = mapper.writeValueAsString(obj);
		System.out.println(jsonInString);
		
		
		//============================= Json file to Object  ==========================
		User user = mapper.readValue(new File("loginTest.json"), User.class);
		System.out.println(user);
		

		
		//============================= Json String to Object
		User obj2 = mapper.readValue(jsonInString, User.class);
		System.out.println(obj2);
//		Login obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Login.class);
		
		
	}
	
	public static void jsonFiletoJava(){
		
		ObjectMapper mapper = new ObjectMapper();
		GoogleOauth2 googleAuth2;
		
		try {
			File file = new File(App1_Jackson.class.getResource("/googleAuth2.json").getPath());
			googleAuth2 = mapper.readValue(file, GoogleOauth2.class);
			
			System.out.println(googleAuth2.getWeb().getClientId());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void java2Json() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		User obj = new User("hung","123",233,345,"abc","def","GPS",true);

		mapper.writeValue(new File("loginTest.json"), obj);

		String jsonInString = mapper.writeValueAsString(obj);
		System.out.println(jsonInString);

	}



}

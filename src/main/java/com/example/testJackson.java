package com.example;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class testJackson {

	public static void main(String[] args) throws Exception {
		
		//tạo JackSon object
		ObjectMapper mapper = new ObjectMapper();

		
		Login obj = new Login("hung","123",233,345,"abc","def","GPS",true);
		
		// ========================== Object to Json file
		//khiểm tra thư mục root của Project sẽ thấy file loginTest.json
		mapper.writeValue(new File("loginTest.json"), obj);

		// ========================== Object to Json string
		String jsonInString = mapper.writeValueAsString(obj);
		System.out.println(jsonInString);
		
		
		//============================= Json file to Object
		Login obj1 = mapper.readValue(new File("loginTest.json"), Login.class);
		System.out.println(obj1);
		
		//============================= Json String to Object
		Login obj2 = mapper.readValue(jsonInString, Login.class);
		System.out.println(obj2);
//		Login obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Login.class);
		
		
		
		
	}

	private void testObject2Json() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		Login obj = new Login("hung","123",233,345,"abc","def","GPS",true);

		mapper.writeValue(new File("loginTest.json"), obj);

		String jsonInString = mapper.writeValueAsString(obj);
		System.out.println(jsonInString);

	}



}

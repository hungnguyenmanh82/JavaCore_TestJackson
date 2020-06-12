package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.example.model.gson.GoogleOauth3;
import com.example.model.jackson.GoogleOauth2;
import com.example.model.jackson.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;

/**
 * lúc compile sẽ gộp "main/resources/" và "main/java/" vào 1 folder chung
 App81_https_Server.class.getResource("/") = root = main/resources/ = main/java/
 App81_https_Server.class.getResource("/abc") = main/resource/abc  = main/java/abc  
 //
 App81_https_Server.class.getResource(".") = root/pakage_name/ 
 App81_https_Server.class.getResource("abc") = root/pakage_name/abc
 App81_https_Server.class.getResource("abc").getPath()
 //
   App81_https_Server.class.getResource("..") = parent folder of root/pakage_name/
   App81_https_Server.class.getResource("../..") = parent of parent of root/pakage_name/  
  //===========================
  + Run or Debug mode trên Eclipse lấy ./ = project folder 
  
  + run thực tế:  ./ = folder run "java -jar *.jar"
 //========= 
 File("loginTest.json"):   file ở ./ folder    (tùy run thực tế hay trên eclipse)
 File("./abc/test.json"):   
 File("/abc"): root folder on linux (not window)
 */

//  http://www.jsonschema2pojo.org/
public class App2_Gson {

	public static void main(String[] args) throws Exception {

		//		exampleAll();


		//jsonFiletoJava();
		
		jsonFiletoJava();

	}

	public static void exampleAll() throws Exception{

		Gson gson = new Gson(); // Or use new GsonBuilder().create();


		//========================== Java to Json string ================= 
		User user = new User("hung","123",233,345,"abc","def","GPS",true);	
		String jsonString = gson.toJson(user);
		System.out.println(jsonString);

		// ========================== json to java ======================
		User user1 = gson.fromJson(jsonString, User.class);

		System.out.println(user1.getAppVersion());


	}

	/**
	 * Nên dùng Gson vì cú pháp đơn giản.
	 */
	public static void jsonFiletoJava(){
		Gson gson = new Gson(); // Or use new GsonBuilder().create();

		try {
			FileReader file = new FileReader(App2_Gson.class.getResource("/googleAuth2.json").getPath() );
			JsonReader jsonReader = new JsonReader(file);

			GoogleOauth3 googleOAuth = gson.fromJson(jsonReader, GoogleOauth3.class);
			System.out.println(googleOAuth.getWeb().getTokenUri());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Nên dùng Gson vì cú pháp đơn giản.
	 */
	public static void jsonFiletoJava2(){
		Gson gson = new Gson(); // Or use new GsonBuilder().create();

		Vertx vertx = Vertx.vertx();
		// blocking = synchronous read file
		Buffer buffer = vertx.fileSystem().readFileBlocking(App31_vertx.class.getResource("/googleAuth2.json").getPath());

		GoogleOauth3 googleOAuth = gson.fromJson(buffer.toString(), GoogleOauth3.class);
		System.out.println(googleOAuth.getWeb().getTokenUri());


	}

}

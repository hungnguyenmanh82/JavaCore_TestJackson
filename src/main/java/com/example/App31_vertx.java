package com.example;

import java.util.HashMap;
import java.util.Map;

import com.example.model.jackson.GoogleOauth2;
import com.example.model.jackson.User;


import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/*
 vertx JsonObject lib rất cơ động, hay hơn Gson và Jackson nhiều
 Có thể dùng JsonObject để convert JDBC Resultset về java Object dễ dàng

 https://vertx.io/docs/vertx-core/java/#_json

 Vertx dùng Jackson lib => Java theo Jackson format
 */
public class App31_vertx {

	public static void main(String[] args) throws Exception {

		//		exampleAll();

		JsonToJava();

	}

	public static void exampleAll(){
		//===========================================convert String => JsonObject ===================
		String jsonString = "{\"foo\":\"bar\"}";
		JsonObject jsonObject = new JsonObject(jsonString);
		System.out.println(jsonObject.toString());
		System.out.println(jsonObject.getString("foo"));

		//===================================convert Map => JsonObject ===================
		Map<String, Object> map = new HashMap<>();
		map.put("foo", "bar");
		map.put("xyz", 3);
		JsonObject jsonObject1 = new JsonObject(map);
		System.out.println(jsonObject1.toString());

		//==================================== create JsonObject ===============================
		JsonObject jsonObject2 = new JsonObject();
		jsonObject2.put("foo", "bar")
		.put("num", 123)
		.put("mybool", true);
		System.out.println(jsonObject2.toString());

		//=================================== convert JsonObject => Java Object ================
		JsonObject jsonUser = new JsonObject();
		jsonUser.put("name", "Happy")
		.put("yearOld", 18);

		User user = jsonUser.mapTo(User.class);
		System.out.println("************* {" + user.getAppVersion() + "," + user.getIpAdress() + "}" );

		//================================ convert java Object => JsonObject ================
		JsonObject  jsonObjectFromUser = JsonObject.mapFrom(user);
		System.out.println(jsonObjectFromUser.toString());

		//====================== Json Array
		String jsonString1 = "[\"foo\",\"bar\"]";
		JsonArray jsonArray = new JsonArray(jsonString1);
		System.out.println(jsonArray.toString());

	}

	public static void JsonToJava(){

		Vertx vertx = Vertx.vertx();
		Buffer buffer = vertx.fileSystem().readFileBlocking(App31_vertx.class.getResource("/googleAuth2.json").getPath());

		//===========================================convert String => JsonObject ===================
		JsonObject jsonObject = new JsonObject(buffer);
		System.out.println(jsonObject.toString());

		//=================================== convert JsonObject => Java Object ================
		GoogleOauth2 auth = jsonObject.mapTo(GoogleOauth2.class);

		System.out.println(auth.getWeb().getRedirectUris());
	}


}

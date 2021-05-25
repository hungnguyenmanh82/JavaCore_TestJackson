package com.yaml;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import com.json.model.jackson.User;
import com.yaml.model.Order;

import io.vertx.core.json.JsonObject;

/**
 * Vertx có hỗ trợ đọc YAML file và chuyển về JsonObject: https://vertx.io/docs/vertx-config/java/ 
 * 
 * YAML cuối cùng sẽ chuyển về cấu trúc tree Node kiểu Json
 */
public class App1_yaml {
	public static void main(String[] args) throws Exception {
//		yaml_to_Java();
		java_to_yaml();
	}
	
	public static void yaml_to_Java() throws Exception{
		/**
		 * ObjectMapper: là thư viện của Json => dùng lại nó để Map YAML với Java Object
		 */
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		
		// convert YAML to JavaClass
		Order order = mapper.readValue(new File(App1_yaml.class.getResource("/order.yaml").getPath()), Order.class);
		
		
		
		System.out.println(JsonObject.mapFrom(order).toString());
	}
	
	public static void java_to_yaml() throws Exception{
		/**
		 * ObjectMapper: là thư viện của Json => dùng lại nó để Map YAML với Java Object
		 * start marker ("---"): đánh dấu bắt đầu 1 document trên YAML file
		 * 
		 * 1 YAML file có thể có nhiều document phân cách nhau bởi "---"
		 */
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));
		
		User user = new User("hung","123",233,345,"abc","def","GPS",true);
		
		/**
		 * Eclipse F11 Debug run at Project folder => tìm file userOut.yaml ở project folder
		 */
		mapper.writeValue(new File("userOut.yaml"), user);
	}

}

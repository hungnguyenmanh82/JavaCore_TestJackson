package com.yaml;

import java.io.File;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.json.model.jackson.User;
import com.yaml.model.Order;

import io.vertx.core.json.JsonObject;

/**
 * Vertx có hỗ trợ đọc YAML file và chuyển về JsonObject: https://vertx.io/docs/vertx-config/java/ 
 * Vertx Json sử dụng thư viện Jackson
 * 
 * YAML cuối cùng sẽ chuyển về cấu trúc tree Node kiểu Json
 * 
 * + Dùng VSCode plugin để đọc *.yaml có collapse dễ dàng
 * + có nhiều web online hỗ trợ convert qua lại giữa Json và YAML  => từ Json converts sang Java Class dễ dàng
 */
public class App1_yaml {
	public static void main(String[] args) throws Exception {
//		yaml_to_Java();
//		java_to_yaml();
		yaml_to_Jsonnode();
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
	
	/**
	 * chuyển YAML to JsonNode để duyệt node trong trường hợp dynamic content
	 */
	public static void yaml_to_Jsonnode() throws Exception{
		/**
		 * ObjectMapper: là thư viện của Json => dùng lại nó để Map YAML với Java Object
		 */
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		
		// convert YAML to Json
		JsonNode jsonNodeTree = mapper.readTree(new File(App1_yaml.class.getResource("/order.yaml").getPath()));
		System.out.println(jsonNodeTree.toString());

		// get Node by key name		
		JsonNode jsonNodeChild = jsonNodeTree.get("orderNo");  // key = orderNo 
		System.out.println(jsonNodeChild.toString());
		
		// check type of Load
		if(jsonNodeChild.getNodeType() == JsonNodeType.STRING) {
			System.out.println(jsonNodeChild.getNodeType().name());
		}else {
			System.out.println(jsonNodeChild.getNodeType().name());
		}
		
		// convert JsonNode to type String, bool, double, int
		System.out.println(jsonNodeChild.asText());
		
		// JsonNode là kiểu Iterator có thể liệt kê các con của nó
		Iterator<JsonNode> it = jsonNodeTree.iterator();
		
		while(it.hasNext()) {
			JsonNode node = it.next();
			//
			if(node.getNodeType() == JsonNodeType.STRING) {
				System.out.println(node.getNodeType().name());
			}else {
				System.out.println(node.getNodeType().name());
			}
		}
		
		//=======================================================================
		//Json to YAML
		String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
		System.out.println("=============================================");
		System.out.println(jsonAsYaml);
		
	}

}

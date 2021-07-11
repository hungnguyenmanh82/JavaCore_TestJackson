package com.json;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.model.jackson.GoogleOauth2;
import com.json.model.jackson.User;

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
public class App1_Jackson {

	public static void main(String[] args) throws Exception {
		
//		exampleAll();
//		java2Json();
		
//		jsonFiletoJava();
		string2JsonNode();
		
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
	
	public static void string2JsonNode() {
		ObjectMapper mapper = new ObjectMapper();

		
		try {
			File file = new File(App1_Jackson.class.getResource("/googleAuth2.json").getPath());
			
			// ObjectNode extends jsonNode
			JsonNode jsonNode = mapper.readTree(file);
			
			// ====================================== 
			// chỉ tìm trên child Node dưới Node này 1 cấp
			JsonNode nodeClientId = jsonNode.get("client_id");
			
			if(nodeClientId == null) {
				System.out.println("1 node = null");  // Ko tìm thấy => vì Node dưới 1 cấp nữa
			}else {
				System.out.println("1 client_id = " + nodeClientId.asText());	// dòng này ko đc print
			}
			
			// ========================================
			// tìm trên
			nodeClientId = jsonNode.findValue("client_id");
			
			if(nodeClientId == null) {
				System.out.println("2 node = null");  
			}else {
				System.out.println("2 client_id = " + nodeClientId.asText());	// dòng này đc print
			}
			
			// ==============================================
			// duyệt child nodes dưới Node 1 cấp
			// vì JsonNode ko chứa key, mà chỉ chứa value nên ta ko dùng cách này
			Iterator<JsonNode>  it = jsonNode.iterator(); // ko dùng
			
			Iterator<Map.Entry<String, JsonNode>> it2 = jsonNode.fields(); // dùng cái này
			
			while(it2.hasNext()) {
				Map.Entry<String, JsonNode> entry = it2.next();
				
				System.out.println("NodeType = " +  entry.getValue().getNodeType().name());
				System.out.println("NodeName = " + entry.getKey());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}; 
	}

	public static void java2Json() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		User obj = new User("hung","123",233,345,"abc","def","GPS",true);
		
		/**
		 * Eclipse F11 Debug run at Project folder => tìm file loginTest.json ở project folder
		 */
		mapper.writeValue(new File("loginTest.json"), obj);

		String jsonInString = mapper.writeValueAsString(obj);
		System.out.println(jsonInString);

	}



}

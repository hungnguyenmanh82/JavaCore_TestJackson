package com.csv;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.yaml.App1_yaml;

public class App1_apache_csv {
	public static void main(String[] args) throws Exception {
//		write_csv();
		read_csv();
	}
	
	static void read_csv() throws Exception{
	    Reader in = new FileReader(App1_yaml.class.getResource("/test.csv").getPath());
	    
	    CSVParser parser = CSVFormat.DEFAULT
	    		.withFirstRecordAsHeader()	// sẽ loại bỏ first line ra khỏi record			
	    		.parse(in);
	    
	    // header
	    List<String> headers = parser.getHeaderNames();
	    System.out.println(String.join(",", headers));
	    
	    System.out.println("================================");
	    /**
	     * chú ý thiết lập lúc tạo CSVFormat là bỏ first line
	     */
	    Iterable<CSVRecord> records = parser;
	    for (CSVRecord record : records) {
	    	for(String column: record) {
	    		System.out.printf("{%s},", column);
	    	}
	    	System.out.println(); // xuống dòng
	    }
	}
	
	static void write_csv() {
		/**
		 * có trách nhiệm convert các ký tự đặc biệt của CSV
		 */
		CSVFormat format = CSVFormat.DEFAULT;

		// sẽ add các field vào đây để build 1 text-line
		final StringBuilder buffer = new StringBuilder();
		/**
		 * thứ tự các field trong CSV line
		 */
		try {
			// sẽ loại bỏ ký tự đặc biệt của CSV tr, sau đó ghi vào buffer
			format.print("column1", buffer, true);    // = true:  ko thêm delimiter "," trc value
			format.print("column2", buffer, false); // = false:  thêm delimiter "," vào trc value
			format.print("column3 abc", buffer, false); // = false:  thêm delimiter "," vào trc value
			format.print("column4 \" ", buffer, false); // = false:  thêm delimiter "," vào trc value
			format.print("column5 , ab", buffer, false); // = false:  thêm delimiter "," vào trc value
			format.println(buffer); // thêm ký tự xuống ròng \n
			
			// lưu ý ký tự xuống dòng trong double quote thì ko cần phải thay đổi gì
			//=======================================================================
			System.out.println(buffer.toString());
		} catch (final IOException e) {
			e.printStackTrace();  
		}
	}
}

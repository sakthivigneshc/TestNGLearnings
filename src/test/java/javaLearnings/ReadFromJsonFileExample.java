package javaLearnings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFromJsonFileExample {
	public static void main(String[] args) throws IOException, ParseException {
		
			FileReader fileReader = new FileReader("jsonFileUsingSimpleJSON.json");
			JSONParser jsonparser = new JSONParser();
			Object parsedObject  =  jsonparser.parse(fileReader);
			JSONObject jsonObject = (JSONObject) parsedObject;
			String   name = (String) jsonObject.get("name");
			System.out.println("Name is: " + name);
			Long age = (Long) jsonObject.get("age");
			System.out.println("Age is: "+ age);
		
			// get the json array values 
			
			JSONArray jsonarray = (JSONArray) jsonObject.get("Unique identity");
			Iterator iterator = jsonarray.iterator();
			while (iterator.hasNext()) {
				System.out.println("Unique identity : "+iterator.next());
				
			}
			
			

	}
}
// 23/11/2025
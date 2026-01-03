package javaLearnings;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJson {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "ram");
		jsonObject.put("age", 1);
		JSONArray jsonarray = new JSONArray();
		jsonarray.add("blue eyes");
		jsonarray.add("Brown hair");
		jsonObject.put("Unique identity", jsonarray);
		
		//write it into a file
		try {
			FileWriter filewriter = new FileWriter("jsonFileUsingSimpleJSON.json");
			filewriter.write(jsonObject.toString());
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


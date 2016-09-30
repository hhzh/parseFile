package com.parseJson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ParseJson {
	public static void main(String[] args) {
		writeJson();
	}
	
	public static void readJson(JSONTokener str){
		try {
			JSONObject jsonObject=new JSONObject(str);
			System.out.println(jsonObject.get("a"));
			System.out.println(jsonObject.get("b"));
			System.out.println(jsonObject.get("c"));
			System.out.println(jsonObject.get("d"));
			System.out.println(jsonObject.get("e"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject writeJson(){
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("a", 1);
			jsonObject.put("b", 1.1);
			jsonObject.put("c", 1L);
			jsonObject.put("d", "test");
			jsonObject.put("e", true);
			System.out.println(jsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
}

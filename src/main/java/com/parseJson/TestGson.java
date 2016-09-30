package com.parseJson;

import com.google.gson.Gson;

public class TestGson {
	public static void main(String[] args) {
		Gson gson=new Gson();
		String str=new TraJsonToBeanUtil().spliceJSON("E:/json.txt");
		Person person=gson.fromJson(str, Person.class);
		
		System.out.println(person.toString());
//		List<Person> ps=gson.fromJson(json, classOfT);
	}
}

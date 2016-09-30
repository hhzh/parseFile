package com.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<Integer,String> map=new HashMap<Integer, String>();
		map.put(1, "name1");
		map.put(2, "name2");
		map.put(1, "name3");
		map.put(4, "name2");
		System.out.println(map.toString());
	}
}

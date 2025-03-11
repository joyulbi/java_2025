package com.company.java016_ex;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapEx004 {
	public static void main(String[] args) {
		String[] data = { "A", "D", "B", "D", "B", "D", "B", "C", "E", "C", "B" };
		HashMap<String, Integer> map = new HashMap<>();

		for (String str : data) {
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}else {map.put(str, 1);}
		}
		System.out.println(map);
		int cnt=0; String str2="";
		for (Entry<String, Integer> e : map.entrySet()) {
			cnt++;
			System.out.println(e.getKey() + "#".repeat(e.getValue()) + e.getValue());
			if(e.getValue()>cnt) { str2=e.getKey();}
		}
		//collections.max
		System.out.println("보험왕"+"["+str2+"]");
	}
}

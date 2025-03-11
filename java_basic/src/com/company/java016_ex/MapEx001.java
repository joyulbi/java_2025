package com.company.java016_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
public class MapEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String,String> map = new HashMap<>();
		map.put("피구왕","통키");
		map.put("제빵왕","김탁구");
		map.put("요리왕","비룡");
		
		/////////////////////ver1
		Iterator <Entry <String, String>> iter =map.entrySet().iterator();
		while(iter.hasNext()) {
			Entry <String, String> temp = iter.next();
			System.out.println(temp.getKey()+ " "+ temp.getValue());
		}
		System.out.println();System.out.println();
		
		///////////////////ver2
		for(Entry <String, String> e:map.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue()+"\n-------------");
		}
		
		System.out.println("KING의 정보를 제공중입니다");
		System.out.print("이름을 입력하세요> ");
		String str = scanner.next();
		System.out.println();
		if(map.containsKey(str)) {System.out.println(str+" : "+map.get(str));}
		else {System.out.println("왕이름 확인");}
	}
}

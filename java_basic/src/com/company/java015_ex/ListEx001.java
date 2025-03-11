package com.company.java015_ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx001 {
	 public static void main(String[] args) {
		List colors = new ArrayList();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		System.out.println(colors);
		
		// 1.  ArrayList이용해서 colors 만들기
		ArrayList<String> colors2 = new ArrayList<>();
		
		// 2. red, green, blue 데이터 추가
		colors2.add("red");
		colors2.add("green");
		colors2.add("blue");
       
		// 3. 출력  for + size
		System.out.println(colors2);
		System.out.println(colors2.get(0));
		System.out.println(colors2.get(1));
		System.out.println(colors2.get(2));
		
		System.out.println();
		System.out.println();
		
		for(int i=0; i<colors2.size(); i++){System.out.println(colors2.get(i));}
	}
}
/*
연습문제1)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : ListEx001
다음과 같이 코드를 작성하시오.
 1.  ArrayList이용해서 colors 만들기
 2. red, green, blue 데이터 추가
 3. 출력
*/
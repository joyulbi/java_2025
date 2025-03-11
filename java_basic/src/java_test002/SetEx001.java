package java_test002;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx001 {
	public static void main(String[] args) {
		Set<String> colors = new HashSet<>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		colors.add("green");
		System.out.println(colors);
		System.out.println(colors.size());
		System.out.println("=============");
		//향상된 for
		for(String e:colors) {System.out.println(e);}
		System.out.println("=============");
		//iterator
		Iterator<String> iter =colors.iterator();
		while(iter.hasNext()) {System.out.println(iter.next());}
	}
}
/*
연습문제1)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : SetEx001
다음과 같이 코드를 작성하시오.
 1.  HashSet이용해서 colors 만들기
 2.  red, green, blue ,green 데이터 추가
 3.  출력
 4.  갯수출력  

*/
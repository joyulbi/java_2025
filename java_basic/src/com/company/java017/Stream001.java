package com.company.java017;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Stream001 {
	public static void main(String[] args) {
		//- 데이터 종류에 상관없이( Stream ) 같은 방식으로 처리( Lambda )
		
		Integer[]arr = {1,2,3,4,5}; // 배열
		List<Integer> list = Arrays.asList(arr); // 리스트

//		Arrays.stream(arr).forEach( (t)->{System.out.print(t);});
//		Arrays.stream(arr).forEach( t->System.out.print(t) );
		Arrays.stream(arr).forEach( System.out::print );
		//Consumer <? super Integer> action
		//Consumer <? super Integer> action; //1.<? super Integer> Integer 포함 부모
		//Consumer <Integer> action;
		//Consumer <Number> action;
		//풀이2. void java.util.function.Consumer.accept ( T t )
		//파라미터 (O) / 리턴 값 (X)
		System.out.println();
		System.out.println();
		list.stream().forEach( System.out::print );
		
	}
}

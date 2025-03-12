package com.company.java017;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream002 {

	public static void main(String[] args) {
		//데이터 종류 상관없이 같은 방식으로처리
		Integer[] arr= {1,2,5,8,9,1,2,5,7};
		List<Integer> list = Arrays.asList(arr);
		
		//#1.stream
		Stream <Integer> stream_arr = Arrays.stream(arr);
		Stream <Integer> stream_list =list.stream();
		
		//#2.중간연산
		//Predicate : boolean java.util.function.Predicate.test ( T t )
		//Consumer : void java.util.stream.Stream.forEach ( Consumer <? super Integer> action )
//		stream_arr.filter((t)->{return t%2!=0;}); // 홀수 : 필터링
		stream_arr.filter(t->t%2!=0) // 홀수 : 필터링
				  .distinct()// 중복제거 
		 		  .sorted()
				  .skip(1)
				  .forEach(t->{System.out.print(t);});
		System.out.println();
		stream_list.filter(t->t%2!=0) // 홀수 : 필터링
		  		   .distinct()// 중복제거 
		  		   .sorted()
		  	       .skip(1)
		  	       .forEach(System.out::print);
		System.out.println();
		//#3.최종연산
		System.out.println(Arrays.stream(arr).collect(Collectors.toList()));
		System.out.println(list.stream().collect(Collectors.toList()));
	}
}
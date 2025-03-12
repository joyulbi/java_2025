package com.company.java017;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda004_api {
	public static void main(String[] args) {
		//#1 Consumer<T> 받는용도 - accpet
		//	 void java.util.function.Consumer.accept ( T t )
		//	 ()->{} 파라미터 O / 리턴 값 X
		
//		Consumer<String> consumer = (t)->{System.out.println("Hello "+t);};
//		Consumer<String> consumer =  t -> System.out.println("Hello "+t);
		Consumer<String> consumer = 	  System.out::println;
		consumer.accept("sally");
		consumer.accept("alpha");
		
		//#2
		//T java.util.function.Supplier.get ()
		//	()->{} 파라미터 X / 리턴 값 O
//		Supplier<String> supplier = ()->{return "Hello";};
		Supplier<String> supplier = ()-> "Hello";
		System.out.println(supplier.get());
		
		//#3
		//boolean java.util.function.Predicate.test ( T t )
		//	(t)->{return} 파라미터 O / 리턴 값 O
//		Predicate<Integer> predicate= (t)->{return t<0;}; //음수인지 양수인지 판단
		Predicate<Integer> predicate=t-> t<0;
		System.out.println(predicate.test(-1));
		System.out.println(predicate.test(1));
		
		//#4
		//R java.util.function.Function.apply ( T t )
		//		(t)->{return} 파라미터 O / 리턴 값 O
//		Function<String,Integer> function = (t)->{return Integer.parseInt(t);};
		Function<String,Integer> function = Integer::parseInt;
		System.out.println(function.apply("10")+3);
		
		//#5
		//int java.util.function.IntBinaryOperator.applyAsInt ( int left,  int right )
		//( int left,  int right )->{return} 파라미터 O / 리턴 값 O
//		IntBinaryOperator operator=(left,right)->{return left>=right?left:right;};
		IntBinaryOperator operator=(left,right)-> left>=right?left:right;
		System.out.println(operator.applyAsInt(10, 3));
		
	}
}
/*
 * 자바 api의 함수형 인터페이스
 1) Consumer - 받는 용도  - accept
 2) Supplier - 제공 용도  - get
 3) Consumer - 판단 용도  - test
 4) Function - 처리 용도  - apply
 5) Operator - 연산 용도  - apply
*/
 
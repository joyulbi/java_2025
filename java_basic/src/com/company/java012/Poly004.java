package com.company.java012;

/* 1. 클래스는 부품객체
 * 2. 상태와 행위
 * 3.상속 - 재사용  	
 	Object				
 	  ↑					  
 	TestA4 	int a / toString
 	  ↑
 	TestB4	int b / toString
 */
class TestA4 extends Object{
	int a=10;
	@Override public String toString() {return "TestA4 [a=" + a + "]";}
}
class TestB4 extends TestA4{
	int b=20;
	@Override public String toString() {return "TestB4 [b=" + b + "]";}	
}
public class Poly004 {
	public static void main(String[] args) {
		TestA4 ta 			   = new TestA4();
		//1.{int a  /toString} = {int a / toString}
		TestB4 tb 							 = new TestB4();
		//2.{int b  /toString}-{int a /----} = {int b  /toString}-{int a /----}
		ta = new TestB4(); //5.추가! 부모는 자식을 담을 적이 있어야 한다.
		tb=(TestB4) ta; //4. 자식 = 부모 / 다운캐스팅 / 타입캐스팅 O
		//3.{int b  /toString}-{int a /----} = {int a  /toString}
		//ta의 메모리는 {int a  /toString} 만족! int b는 생성자 호출해서 초기화한 적이 없음
		System.out.println(tb);
	}
}

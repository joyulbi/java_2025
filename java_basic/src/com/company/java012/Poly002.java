package com.company.java012;

/* 1. 클래스는 부품객체
 * 2. 상태와 행위
 * 3.상속 - 재사용 
 	 	 	
 	Object				
 	  ↑					  
 	TestA2 	int a / toString
 	  ↑
 	TestB2	int b / toString
 */
class TestA2 extends Object{
	int a=10;
	@Override public String toString() {return "TestA2 [a=" + a + "]";}
}
class TestB2 extends TestA2{
	int b=20;
	@Override public String toString() {return "TestB2 [b=" + b + "]";}	
}

public class Poly002 {
	public static void main(String[] args) {
		TestA2 ta = new TestB2();//4. 부모 = 자식 / 업캐스팅 / 타입캐스팅 X
		//1. TestA2 ta {int a / toString}
		//2. 		1번지TestB2() 			→ TestA2() 			→ Object()
		//             {int b / toString} - {int a / toString}
		//3. ta[1번지]= {int b / toString} - {int a / toString}
		System.out.println(ta);//TestBw[b=20]
		System.out.println(ta.a);//10
		System.out.println(((TestB2)ta).b);
	}
}

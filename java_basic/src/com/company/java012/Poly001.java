package com.company.java012;

/*
 	Object				Object
 	  ↑					  ↑
 	TestA (int a)		TestA (int b)
 */
class TestA extends Object{int a;}
class TestB extends Object{int b;}

public class Poly001 {
	public static void main(String[] args) {
		TestA v110 = new TestA();
		//TestB v220 = v110; 
		//오류나는 이유
		//Type mismatch: cannot convert from TestA to TestB
		//클래스도 자료형( 틀 - Object )
	}
}

package com.company.java011;

class A{
//멤버변수
	int a=10; // *인스턴스 변수 - heap -new O - this 각각
	{a=100;}
	static String company="(주)동물농장"; //명시적 초기화
	static {company = "(주)동물농장-joy";} //초기화 블록
	//static은 클래스변수 - method 영역에 new랑 관련없음 즉 생성자랑 관련X, 공유되는 영역임
//멤버함수
	void method() {int a=3000; System.out.println(a);} //지역변수 -stack-초기화 
	void show() {System.out.println(this.a);} // 인스턴스변수
	@Override
	public String toString() {return "A [a=" + a + "]";}
	A(){}
	A(int a){this.a=a;}
}

public class Class006_var {
	public static void main(String[] args) {
		//클래스 변수
		System.out.println(A.company);
		//인스턴스 변수
		A a1 = new A(3); System.out.println(a1);
		A a2 = new A(3); System.out.println(a2); a2.method();
	}
}
/***********  (1) runtime
-----------------------------------------------------------------------
[method:정보,공유] A.class/class006.class/company[], main #step1)
-----------------------------------------------------------------------
[heap:동적]			| [stack:임시]0109101
					  a2.method(){int a=3000; System.out.println(a);}
2번지{a=7}			← a2 2번지
1번지{a=3}			← a1 1번지
					| [main] #step2)
-----------------------------------------------------------------------

************  (2) 초기화
*					기본 값		명시적초기화		초기화블록			생성자
 클래스 변수 company	1.null		2.(주)동물농장		3.(주)동물농장-joy	  X
 인스턴스 변수 a		4.0			5.10			6.a=100;		7. 3
 */



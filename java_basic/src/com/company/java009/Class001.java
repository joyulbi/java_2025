package com.company.java009;

//1. 클래스는 부품객체
//2. 클래스는 속성(멤버 변수)과 행위(멤버 함수)
class A1{}
public class Class001 {
	public static void main(String[] args) {//jvm - main 구동 시점
		//int i; 자료형 변수명;  클래스도 자료형
		//A1 a;
		A1 a = new A1();//3-1. 1번지 new(heap 공간빌리기)	3-2. A1() 초기화
						//3-3. a는 주소
		
		//com.company.java009.A1@c39f790
		System.out.println(a);
		A1 a2 = new A1();
		A1 a3 = new A1();
	}
}
/*	10번째줄 : A1 a = new A1();
----------------------------------------- [runtime data area]
[method : (정보, static, final - 공용 정보)] A1.class, public Class001.class
------------------------------------------------------------------------
[heap : 동적]		|[stack : 잠깐 빌리기]
 1번지 : A1{ }	    ← a (1번지) 
					| main
------------------------------------------------------------------------
*/
 
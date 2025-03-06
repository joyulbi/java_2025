package com.company.java013;
//Q6 컴파일에러
//1. 클래스 부품객체(상태-멤버변수와 행위 -멤버함수)
// 클래스 변수/ 인스턴스변수/ 지역변수/ 클래스메서드/ 인스턴스메서드

// 변수 초기화 단계
// 					기본 값 > 명시적 초기화 > 초기화 블록 > 생성자
// classValue		1) 0	2) 20		3) 20		4)X
// instanceValue	5) 0	6) 10		7) 10		8)10
class MemberCall001{
	int instanceValue=10; //인스턴스변수 - heap area - new O - this각각
	static int classValue=20; //클래스변수 method area - new X - 공유영역
	
	int instanceValue2=classValue;//인스턴스변수(5) = 클래스변수(1)
	
//	static int classValue2=instanceValue;
	//##1)static은 instance 사용 불가
	//static은 jvm 로딩시 메모리 할당받음(바로사용),instance는 new를 사용해 메모리 할당받고 객체생성 후 사용
	
	static void staticMethod1() {// 클래스메서드
		System.out.println(classValue);
//		System.out.println(instanceValue);
		//2)static은 instance 사용 불가
		//static은 jvm 로딩시 메모리 할당받음(바로사용),instance는 new를 사용해 메모리 할당받고 객체생성 후 사용
		
	}
	void instanceMethod1() {
		System.out.println(classValue);
		System.out.println(instanceValue);
		//3)오류없음
	}
	static void staticMethod2() {
		System.out.println(classValue);
//		instanceMethod1();
		//4)static은 static끼리
	}
	void instanceMethod2() { //인스턴스 메서드 heap area -new O -this 각각
		staticMethod1();
		//5)오류없음
	}
}
public class Repeat002 {
	public static void main(String[] args) {
		
	}
}
/*Q7 접근제어자 사용범위
public(아무데서나) > protected(extends:상속) > package(default:폴터 내부) > private(클래스 내부)
*/

//

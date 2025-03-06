package com.company.java013;
//1. 클래스 부품객체(상태-멤버변수와 행위 -멤버함수)
//Q1.클래스 변수/ 인스턴스변수/ 지역변수/ 클래스메서드/ 인스턴스메서드
class A11{
	int a;
	//(1) 인스턴스 변수 - heap area - new O - this각각
	
	A11(){}
	A11(int a){this.a=a;}
	//(2)지역변수 - stack area
	
	void show() {this.a=11;System.out.println(this.a);}
	//(3)인스턴스메서드 - heap area - new O - this각각
	
//	static void classMethod() {this.a=12;}
	//(4)클래스메서드 method area - new X - 공유영역
	//static이 jvm 로딩시 제일먼저 메모리상에 올라감 this는 new룰 이용해 사용해야함 순서가 안 맞음
	//staitc은 instance 사용불가
	
//	int show2() {int a; return a;}
	//(5)인스턴스메서드-heap area - new O - this각각
	//int show(){int a; return a;} show2 메서드 안에 있는 int a는 지역변수
	//int a는 stack - 임시공간 - 변수 초기화가 안됨. 주의
}

public class Repeat001 {
	public static void main(String[] args) {
		A11 a1=new A11(); 
		//a1은 지역변수 stack영역
		/*Q3.메모리를 빌려오고 객체 생성하는 역할 -> new
		     초기화 하는 역할 -> A11(); 
		     new A11()한 주소를 갖고 있는 것 -> a1*/
	}
}
//Q4 기본생성자를 반드시 선언해야 하는 경우 : 생성자 오버로딩, 상속
/*Q5 오버로딩이 성립하기 위한 조건이 아닌것 :c,d
 * a 메서드의 이름이 같아야한다
 * b 매개변수의 개수나 타입이 달라야 한다
 * c 리턴타입이 달라야 한다
 * d 매개변수의 이름이 달라야 한다
 * --비슷한 기능의 메서드들의 이름을 같게 만들고 알규먼트의 자료형과 개수로 구분
 */





/*	1.	클래스 변수 (static 변수)---->method area
		클래스가 로딩될 때 한 번만 메모리에 저장됨.
		모든 객체가 공유해서 사용.
		클래스 이름을 통해 직접 접근 가능.
	2.	인스턴스 변수----->heap area
		객체(인스턴스)를 생성해야 사용할 수 있음.
		각 객체마다 개별 저장됨 (공유되지 않음).
	3.	지역 변수--->stack area
		메서드 내부에서 선언되며, 메서드 실행 중에만 사용 가능.
		초기화하지 않으면 사용할 수 없음.
	4.	클래스 메서드 (static 메서드)---->method area
		객체 생성 없이 호출 가능.
		클래스 변수만 사용할 수 있고, 인스턴스 변수는 사용 불가.
	5.	인스턴스 메서드-------->heap area
		객체를 생성해야 호출 가능.
		클래스 변수, 인스턴스 변수 모두 사용할 수 있음
 * 
 * */

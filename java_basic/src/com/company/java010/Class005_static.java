package com.company.java010;

//1. 클래스는 부품객체
//2. 특성 - 상태와 행위
class Farm{
	//상태-멤버 변수
	String name; //인스턴스 변수 - heap area - new O - this.name
	int age; //인스턴스 변수 - heap area - new O - this.age
	static String FarmName="(주)동물농장"; //클래스변수 - method area - new X
	static int num = 10; // 클래스 변수 - method area - new X
	//행위-멤버 함수
	static void num_plus() {num++; /*this.age++;*/} // non-static-field age
	void show() {
		System.out.println("\n\n:::::::::::::::::::::");
		System.out.println("::회사명 : "+Farm.FarmName);
		System.out.println("::식구수 : "+Farm.num);
		System.out.println("::이름: "+this.name);
		System.out.println("::나이 : "+this.age);
	}
}

public class Class005_static {
	public static void main(String[] args) {
		System.out.println("Step1. 클래스변수 - static");
		System.out.println("회사명 > "+Farm.FarmName); Farm.num_plus();
		System.out.println("식구수 > "+Farm.num);
		//System.out.println("인스터스이름 > "+Farm.name);
		
		System.out.println("\n\nStep2. 인스턴스 변수 - this - 각각");
		Farm cat = new Farm(); cat.name="jaryong"; cat.age=2; cat.show();
		//cat.FarmName=""; cat.num=11;//should be accessed in a static way
		Farm dog = new Farm(); dog.name =""; dog.age=3; dog.show();
	}
}
/*
------------------------------- runtime 
[method : 각종정보,static,final/공유]	
#1.		Farm.class/ Class005.class/ FarmName[(주)동물농장], Farm.num[10], Farm.num_plus()
---------------------------------------------
[heap]              			 	| [stack]
32번째줄:2번지 {name=alpha,age=3} 		← dog:2번지
30번째줄:1번지 {name=jaryong,age=2} 	← cat:1번지
									| #2 main
---------------------------------------------
*/
package com.company.java010;

//1. 클래스는 부품객체
//2. 클래스 속성(멤버변수)과 행위(멤버함수)

class Car31{}  // 생성자 Car31() - 컴파일러가 기본생성자를 자동생성
class Car32 extends Object{ 
	String color; 
	//  alt + shift + s  ★ 밑에서 3번째 (2,3,4, getters/setters)
	//  ★ 오버로딩시 - [수동]으로 생성자를 만들면 컴파일러가 기본생성자를 자동생성취소
	public Car32(String color) { this.color = color; }
	public Car32() { super();  color = "black"; }  //기본생성자는 오버로딩, 상속
}
//class Car33 extends Car32{ public Car33(String color) { super(color); } }
public class Class003_Constructor {
	public static void main(String[] args) {
       Car31  car1 = new Car31(); //3-1. new(메모리빌리고, 객체생성) 3-2. Car31() 초기화 3-3. car1 번지
       System.out.println(car1); //com.company.java010.Car31@2f92e0f4
       
       //Car32  car2 = new Car32();
       //System.out.println(car2 + "\t" + car2.color);  //Car32@5305068a   null
       
       Car32  car3 = new Car32("red");
       System.out.println(car3 + "\t" + car3.color); 
       
       //Car33  son = new Car33();
	}
}  // 
/*
------------------------------ run time
[method:정보, static, final] Car31.class / Car32.class/ Class003.class  ##1
---------------------------------------
[heap:동적]				  |[stack:지역]
11번째줄: 1번지{       } 	  ← car1 : 1번지
						  | main ##2 10번째줄
---------------------------------------
*/
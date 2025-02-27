package com.company.java009_ex;
import java.util.Scanner;


//1. 클래스는 부품객체 - 특징
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
class MyPrice001{
	String name;  int price;
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품이름 입력 : "); name=scanner.next();
		System.out.print("가격 입력 : "); price=scanner.nextInt();
	}
	void show() {
		System.out.println("=====상품정보입니다=====\n"+"상품이름 : "+this.name+" / "+"상품가격 : "+this.price);
	}
}
public class ClassEx002 {
	public static void main(String[] args) {
		MyPrice001 p1 = new MyPrice001();
		//3-1. new 공간 빌리기,객체생성 3-2) MyPrice001() 초기화 3-3) p1 주소
		p1.input(); p1.show();
	}
}
/*	클래스(설계도) - 인스턴스화(실제객체) - 객체(인스탄스들....)/인스턴스 p1.name
----------------------------------------- [runtime data area]
[method : 정보, static, final : 공용 정보]  MyPrice001.class / ClassEx002.class
-----------------------------------------
[heap : 동적]	  				      |[stack : 잠깐 빌리기]
23번째줄 :                               p1.show(); 1번지.show(); { }
22번째줄 :     {name=apple, price=1000}  p1.input(); 1번지.input(); { }
20번째줄 : 1번지 {name=null, price=0}   ← p1 : 1번지
								      | main
-----------------------------------------
*/
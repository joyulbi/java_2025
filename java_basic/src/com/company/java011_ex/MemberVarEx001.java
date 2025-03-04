package com.company.java011_ex;

//클래스는 부품객체
//상태와 행위
class Sawon3 {
//상태(멤버변수) - 클래스 변수/ 인스턴스 변수 / 지역 변수
	int pay = 10000; // 인스턴스 변수 - heap - new O - this,생성자 
	static int su =10; // 클래스변수 - method - new X - 공유 목적
//	static int basicpay = pay; //X 클래스변수 = 인스턴스변수 (클래스변수, 클래스 메서드 - this 또는 인스턴스 사용불가)
	static int basicpay2;
	
//행위(멤버함수)	- 클래스 함수/ 인스턴스 함수
	public static void showSu() {System.out.println(su);  }     //클래스 함수 - method - new X - 공유       
//  public static void showPay() {System.out.println(this.pay); }  //X 인스턴스 사용불가
   
	public void showAll001() {  // 인스턴스 변수 - heap - new O - this,생성자
        System.out.println(su);  
        System.out.println(this.pay);  
     } 
/*  public static void showAll002() {   //X 클래스 함수 - method - new X - 공유 목적
        showAll001(); // 인스턴스 사용불가 - heap - new O - this, 셍성자
        System.out.println(this.pay);
     } */
 } 


public class MemberVarEx001 {
	public static void main(String[] args) { // args - 지역변수
		Sawon3   sola = new Sawon3();  // sola - 지역변수
		sola.showAll001();	
	}
}

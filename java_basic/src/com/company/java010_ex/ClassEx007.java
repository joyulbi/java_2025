package com.company.java010_ex;
import java.util.Scanner;
class Calc{
	static String name = "**계산기**";
	int num1, num2;  char op;  double result;
	public Calc() {}
	public Calc(int num1, int num2, char op) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
	}
	void input(){
		Scanner scanner =new Scanner(System.in);
		System.out.print("숫자1> "); this.num1=scanner.nextInt();
		System.out.print("숫자2> "); this.num2=scanner.nextInt();
		System.out.print("연산자> "); this.op=scanner.next().charAt(0);
	}
	double opcalc() {
		 result=((op=='+')?num1+num2:(op=='-')?num1-num2:(op=='*')?num1*num2:(op=='/')?(double)num1/num2:0);
		 return result;
		}
	void show() {
		System.out.println(num1+" "+op+" "+num2+" = "+((op=='/')?String.format("%.2f",opcalc()):(int)opcalc()));}}
		


public class ClassEx007 {
	public static void main(String[] args) {
		System.out.println(Calc.name);// 클래스명.static변수 - new를 이용해서 사용x
		
		Calc c1= new Calc(10,3,'+');  
		c1.show();	System.out.println(c1.name);
		Calc c2= new Calc();  
		c2.input();   
		c2.show(); 
	}

}
/* 소스파일												-- 컴파일(번역) -- 바이트코드
   ClassEx007.java [class Calc{} / public ClassEx007{}]					Calc.class / ClassEx007.class
## Class Loader
-----------------------------------------------------------------[## runtime] 
[method : 정보,static,final/공유]		
	#1. Calc.class / ClassEx007.class / Calc.name[**계산기**]
-----------------------------------------------------------------------------
[heap:동적]              		 		| [stack:임시]
32번째줄 1번지{num1:0,num2:0,op:0,result} 	←	c1 : 2번지
33번째줄										c1.show();
32번째줄 1번지{num1:10,num2:3,op:+,result} ←	c1 : 1번지
30번째줄 										println(Calc.name); // **계산기**
						 		 		| #2. main
------------------------------------------------------------------------------
*/




package com.company.java002;

public class Var001 {
	public static void main(String [] args) {
		//1. 자료형 변수명
		int     a = 0;    // a    [0]
		System.out.println("1:"+a);
		
		a = 10000;
		System.out.println("2:"+a); //변하는 숫자
		
		a= 100000 -11000;   //a [89000]
		System.out.println("3:"+a); //변하는 숫자
		
		a = a - 3000;
		System.out.println("4:"+a); //변하는 숫자
		
		//2. 변수의 범위
		{ int b=20; System.out.println(b);}
		//b=1000;  //b cannot be resolved to a variable
		
		//3. 변수명 $_소문자7
		int $1 = 1; int _2=2; int main=3;
		//int 3abc=3; int static; int package; int class; int void; (X)
		System.out.println($1+"\t"+_2+"\t"+main);
		
	}
}

package com.company.java012;

//1. 상속도 그리기
/*
			 Object 
	  	  	   ↑
			  Calc  
	  ↑	   ↑	  ↑	      ↑
	Plus Minus Multiply Divide  
*/

class Clac extends Object{void exec(double d1,double d2){System.out.println();}}
class Plus extends Clac{void exec(double d1,double d2){System.out.println(d1+d2);}}
class Minus extends Clac{void exec(double d1,double d2){System.out.println(d1-d2);}}
class Multiply extends Clac{void exec(double d1,double d2){System.out.println(d1*d2);}}
class Divide extends Clac{void exec(double d1,double d2){System.out.println(d1/d2);}}

public class Poly005_arr {
	public static void main(String[] args) {
		//부모 =  자식 / 업캐스팅/ 타입캐스팅 필요X
		Clac [] my = {new Plus(), new Minus(), new Multiply(), new Divide()};
		my[0].exec(10,3);
		my[1].exec(10,3);
		my[2].exec(10,3);
		my[3].exec(10,3);
	}
}

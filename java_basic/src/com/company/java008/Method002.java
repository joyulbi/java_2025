package com.company.java008;

public class Method002 {
	//#1. 함수 정의
	//public static 리턴값 메서드명(파라미터){ }
	/////////////////////////////////////
	public static void main(String[] args) {
		myint(1); //1출력 
		myint(2);
		//public static void myint(int a){해당 값 출력}		
		
		myadd(1,2);
		myadd(10,3);
		//public static void myadd(int a,int b){해당 값 더해서 출력}
	}
	public static void myint(int a){System.out.println(a);}
	public static void myadd(int a,int b){System.out.println(a+b);}
}



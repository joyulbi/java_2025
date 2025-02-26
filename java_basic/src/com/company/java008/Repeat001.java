package com.company.java008;

public class Repeat001 {
	public static void main(String[] args) {
		//Q1 int보다 작은 자료형 - byte, short/char 연산시 int 기본형으로 변환
		byte b1=1; byte b2 =2; 
		byte result1 =(byte)(b1+b2);
		int result2 =b1+b2;
		System.out.println(result1+"\t"+result2);
		
		
		
	}

}

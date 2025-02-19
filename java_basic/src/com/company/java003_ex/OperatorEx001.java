package com.company.java003_ex;

public class OperatorEx001 {
	public static void main(String[]argd) {
		
		//비교 조건 대입
		
		
		int a=3 ,b=10;
		System.out.println(a&b);
		//0011  0110
		System.out.println(b+=10 - a--);
		//1)a--
		//2)10-a
		//b+=
		System.out.println(a+=5);
		//1) a+=5 2+=5   7
		System.out.println(a>=10 || a<0 && a>3);
		//( )값 비교 (>.<) 조건(&&)대입 &&가 우선순위
	
		 
		  
	}

}

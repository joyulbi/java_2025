package com.company.java003;

import java.util.Scanner;

public class Casting002 {
	public static void main(String[]args){
		//#1. 문자 초기화
		char ch1 = ' ';
		char ch2 = '\u0000';
		
		System.out.println( "step1: "+ ch1+ "\t" +ch2);
		System.out.println( "step2: "+ (int)ch1+ "\t" +(int)ch2);
		
		//#2. 문자의 연산
		char c ='A';
		
		System.out.println("step3: "+ c + "\t" +(int)c);
		System.out.println("step4: "+(char)(c+1));
		// 1) + 더하기 연산
		// 2) 숫자 + 숫자 더하기
		// 3) 'A' + 1 = 'A'(char|2byte) + 1(int|4byte)
		// byte - short(2byte)/ char(2byte) - int
		
		byte ex1 = 1;
		int result = ex1 + 10;
		
		System.out.println("Q1.대문자A를 소문자a로 변환: "+'A'+" ===> "+(char)('A'+32));
		
		char q1 = 'A';
		System.out.println(q1+=32); //+더하기를 하고 =대입 q1의 자료형은 char이라 자동형변환됨
		
		//#3. 문자열
		//자료형의 분류는 기본형과 참조형
		String str1="abc"; //객체 사용시 str1 주소
		Scanner scanner = new Scanner(System.in); //scanner 주소
		
		System.out.println(str1);
		System.out.println(scanner);
		
		System.out.println(str1.charAt(0));
		System.out.println(str1.charAt(1));
		System.out.println(str1.charAt(2));
		
		String str = scanner.next("A");
		System.out.println("입력한 문자열 : "+str);
		
		char ch = scanner.next().charAt(0);
				// scanner.next() 
		System.out.println("입력한 문자 : "+ch);
	}
}

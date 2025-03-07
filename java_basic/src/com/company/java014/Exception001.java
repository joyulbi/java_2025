package com.company.java014;

import java.util.InputMismatchException;
import java.util.Scanner;
//1. try{에러날거같아} catch(에러내용){} finally{맨 마지막 무조건 처리, 생략 가능} InputMismatchException
public class Exception001 {
	public static void main(String[] args) {
		int a = -1;
		Scanner scanner= new Scanner(System.in);

		/*try {for(;a!=1;) {System.out.print("입력>"); a=scanner.nextInt();}}
		catch(Exception e){System.out.println("관리자문의");}
		finally{System.out.println("무조건 실행!");}
		System.out.println("결과물"+a);*/
		//1.nextInt() 숫자 입력 받기를 기다림
		//2.'a'
		
		
		while(true) {
			try {
				System.out.print("숫자1 입력>");
				a=scanner.nextInt();
				if(a==1) {break;}
			}catch(InputMismatchException e) {
				scanner.next();
			System.out.println("숫자 입력!");
			}
		}
		System.out.println("결과물"+a);
	}
		
		
}


package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자를 입력하세요 >");
		char ch = scanner.next().charAt(0);
		if(ch>='A'&& ch<='Z') {System.out.println("대문자");}
		else if(ch>='a'&& ch<='z') {System.out.print("소문자");}
		else {System.out.print("영어만 입력하세요.");}
	}
}

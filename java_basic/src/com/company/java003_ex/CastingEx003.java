package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx003 {
	public static void main(String[]args) {
		char ch = ' ';
		Scanner scanner = new Scanner(System.in);
		System.out.print("대문자를 입력하세요 >");
		ch = scanner.next().charAt(0);
		//ch=+32;
		//ch=(char)(ch+32);
		System.out.println("소문자로 변경하면 >"+(char)(ch+32));
	}
}

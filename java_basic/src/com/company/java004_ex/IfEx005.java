package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("대문자를 입력하세요 >");
		char ch = scanner.next().charAt(0);
		if(ch>='A'&& ch<='Z') {
			ch += 32;
			System.out.println(ch);}
	}

}

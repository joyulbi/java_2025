package com.company.java004_ex;

import java.util.Scanner;

public class Repeat002 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 >");
		int a = scanner.nextInt();
		switch(a) {
		case 1 : System.out.println("1이다");break;
		case 2 : System.out.println("2이다");break;
		case 3 : System.out.println("3이다");break;
		}
	}

}

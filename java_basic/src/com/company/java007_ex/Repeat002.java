package com.company.java007_ex;
import java.util.Scanner;
public class Repeat002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자를 입력하세요>");
		char ch = scanner.next().charAt(0);
		switch(ch) {
		case 97:System.out.println("apple"); break;
		case 98:System.out.println("banana"); break;
		case 99:System.out.println("coconut"); break;
		}
	}

}

package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 >");
		int num = scanner.nextInt();
		if(num%2==0) {System.out.print("여자");}
		else if(num%2!=0) {System.out.print("남자");}
	}
}

package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[]args) {
		int num1 , num2; double result;
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		num1=scanner.nextInt();
		System.out.print("숫자를 입력하세요 : ");
		num2=scanner.nextInt();
		result = (double)num1/num2;
		System.out.println(num1 + "/" + num2 + "=" +String.format("%.2f", result));
	}
}

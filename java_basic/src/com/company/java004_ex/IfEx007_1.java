package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007_1 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("1.정수를 입력하세요 >");
		int num1 = scanner.nextInt();
		System.out.print("2.정수를 입력하세요 >");
		int num2 = scanner.nextInt();
		System.out.print("3.연산자를 입력하세요(+,-,*,/) >");
		char ch = scanner.next().charAt(0);
		//double result = 0;
		//if(ch=='+' ||ch=='-'||ch=='*'||ch=='/') {
			System.out.println((ch=='+')?num1+num2:(ch=='-')?num1-num2:(ch=='*')?num1*num2:(ch=='/')?String.format("%.2f",(double)num1/num2):"");
		//}
	}
}

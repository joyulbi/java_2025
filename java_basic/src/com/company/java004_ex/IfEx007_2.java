package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007_2 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("1.정수를 입력하세요 >");
		int num1 = scanner.nextInt();
		System.out.print("2.정수를 입력하세요 >");
		int num2 = scanner.nextInt();
		System.out.print("3.연산자를 입력하세요(+,-,*,/) >");
		char ch = scanner.next().charAt(0);
		String result = "";
		String output = "";
		if(ch=='+' ||ch=='-'||ch=='*') {
			if(ch=='+'){result=""+(num1+num2);}
			else if(ch=='-'){result=""+(num1-num2);}
			else if(ch=='*'){result=""+(num1*num2);}
			//output = String.valueOf((int)result);
		}else if(ch=='/') {result=String.format("%.2f",(num1/(float)num2));
		//output =String.format("%.2f", result);
		}
		System.out.println(num1+""+ch+""+num2+"="+result);
	}
}
//String과 int를 더하면 string
//String char차이점 
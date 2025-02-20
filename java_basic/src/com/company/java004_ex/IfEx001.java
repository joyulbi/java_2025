package com.company.java004_ex;

import java.util.Scanner;

public class IfEx001 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("평균점수를 입력하세요 >");
		int total = scanner.nextInt();
		
		if(total>=60){System.out.println("합격");}
		else {System.out.println("불합격");}
		
		String result = "불합격";
		if(total>=60) {result = "합격";}
		System.out.println(result);
	}
}

package com.company.java004_ex;

import java.util.Scanner;

public class IfEx003 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 >");
		int num = scanner.nextInt();
		if(num==1) {System.out.println("one");}
		else if(num==2) {System.out.println("two");}
		else if(num==3) {System.out.println("three");}
		else {System.out.println("1,2,3이 아니다");}
	}

}

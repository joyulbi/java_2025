package com.company.java005_ex;
import java.util.Scanner;
public class ForEx006 {
	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		int a=0;
		for(; a!=9;) {
			System.out.println("메뉴판만들기");
			System.out.print("숫자9 입력하시오......");
			a = scanner.nextInt();
		}
	}

}

package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx001 {
	public static void main(String[]args) {
		Scanner scanner= new Scanner(System.in);
		System.out.print("달을 입력하시오>");
		int season = scanner.nextInt();
		switch(season){
			case 3:
				System.out.println("봄"); break;
			case 6:
				System.out.println("여름"); break;
			case 9:
				System.out.println("가을"); break;
			case 12:
				System.out.println("겨울"); break;
		}
	}

}

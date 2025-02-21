package com.company.java005_ex;
import  java.util.Scanner;
public class ForEx002 {
	public static void main(String [] args) {
		//Q1=======================================
		Scanner scanner=new Scanner(System.in); 
		System.out.print("숫자를 입력하세요>");
		int gu = scanner.nextInt();
		for(int i =gu;i<=gu;i++) {
			System.out.println("===="+gu+"단"+"====");
			for(int i1 =1; i1<=9; i1++) {
				int sum = i1*i;
				System.out.println(i+" * "+i1+" = "+sum);
			}
		}
	}
}
package com.company.java005_ex;

public class ForEX004 {
	public static void main(String [] args) {
		System.out.println();
		int count = 0;
		System.out.print("3의배수 : ");
		for(int i =1; i<=10;i++) {
			if(i%3==0) {
				count ++;
				System.out.print((i==3?"":",")+i);
			}
		}
		System.out.println("\n"+"3의 배수 개수 : "+count);
	}
}

package com.company.java005_ex;
import java.util.Scanner;
public class Repeat004 {
	public static void main(String []args) {
		Scanner scanner= new Scanner(System.in);
		int num = 0;
		for(;num!=1;) {
			System.out.print("값을 입력하세요 >");
			 num = scanner.nextInt();		
		}
	}

}

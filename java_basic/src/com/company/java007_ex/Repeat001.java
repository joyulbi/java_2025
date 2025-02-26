package com.company.java007_ex;
import java.util.Scanner;
public class Repeat001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자를 입력하세요>");
		char ch = scanner.next().charAt(0);
		if(ch=='a') {System.out.println("apple");}
		else if(ch=='b') {System.out.println("banana");}
		else if(ch=='c') {System.out.println("coconut");}
	}

}

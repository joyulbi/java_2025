package com.company.java005;
import java.util.Scanner;
public class Repeat001_For {
	public static void main(String [] args) {
		//step1 
		System.out.println("step 1)");
		System.out.print(1+"\t");	//{}     시작1
		System.out.print(2+"\t"); //{변수}  변화1
		System.out.print(3+"\t"); //       종료3
		
		
		//step2
		System.out.println("\n\nstep 2)");
		//{반복}  {변수}    for(시작;종료;변화)
		for(int i=1; i<=3; i++)
		{System.out.print(i+"\t");} System.out.println();
		
		//step3
		for(int i=11; i<=20; i++)
		{System.out.print(i+"\t");} System.out.println();
		
		for(int i=3; i<=8; i++)
		{System.out.print(i+"\t");} System.out.println();
		
		for(int i=1; i<=5; i+=2)
		{System.out.print(i+"\t");} System.out.println();
		
		for(int i=1; i<=10; i++){
			if(i%4==0) {
		System.out.print(i+"\t");} 
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자입력>");
		int start = scanner.nextInt();
		for(int i = start; i<=10; i++) {System.out.print(i+"\t");}
	}
}

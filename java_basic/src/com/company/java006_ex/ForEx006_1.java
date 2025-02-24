package com.company.java006_ex;
import java.util.Scanner;
public class ForEx006_1 {
	public static void main(String []args) { 
		Scanner scanner = new Scanner(System.in);
		
		// 변수
		int num1, num2;
		double result=0;
		char ch=' ';
		
		//입력
		for(;;) {
			System.out.print("정수1를 입력하세요>");
			num1=scanner.nextInt();
			if(num1>=0 && num1<=100){break;}
			else {System.out.println("정수1 다시입력");}}
		for(;;) {
			System.out.print("정수2를 입력하세요>");
			num2=scanner.nextInt();
			if(num2>=0 && num2<=100) {break;}
			else {System.out.println("정수2 다시입력");}}
		for(;;) {
			System.out.print("연산자를 입력하세요>");
			ch=scanner.next().charAt(0);
			if(ch=='+' || ch=='-'||ch=='*'||ch=='/') {break;}
			else {System.out.println("연산자 다시입력");}}
			
		//처리
			if(ch=='+') {result=num1+num2;}
			else if(ch=='-') {result=num1-num2;}
			else if(ch=='*') {result=num1*num2;}
			else if(ch=='/') {result=(double)num1/num2;}
		//출력
		System.out.println(num1+""+ch+""+num2+"="+(ch=='/'?String.format("%.2f",result):(int)result));
		
	}
}
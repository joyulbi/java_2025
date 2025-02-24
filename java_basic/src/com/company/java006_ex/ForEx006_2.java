package com.company.java006_ex;
import java.util.Scanner;
public class ForEx006_2 {
	public static void main(String []args) { 
		Scanner scanner = new Scanner(System.in);
		
		// 변수
		int num1=-1, num2=-1;
		double result=' ';
		char ch=' ';
		
		//입력
		for(;;) {
			if(!(0<=num1&&num1<=100)) { //잘쓴 범위가 아니라면 입력시도/ 잘쓴범위면 입력X
				System.out.print("숫자1입력>"); num1=scanner.nextInt(); continue;
				//continue;잘못입력받았으면 아래거 진행하면 됨
			}
			if(0>num2||num2>100) {//-1 || 101
				System.out.print("숫자2입력>"); num2=scanner.nextInt(); continue;
			}
			if(!(ch=='+'||ch=='-'||ch=='*'||ch=='/')) {
				System.out.print("연산자 입력>");ch=scanner.next().charAt(0); continue;
			}
			break;
		}
		//처리
		if(ch=='+') {result=num1+num2;}
		else if(ch=='-') {result=num1-num2;}
		else if(ch=='*') {result=num1*num2;}
		else if(ch=='/') {result=(double)num1/num2;}
	//출력
		System.out.println(num1+""+ch+""+num2+"="+(ch=='/'?String.format("%.2f",result):(int)result));
	}
}
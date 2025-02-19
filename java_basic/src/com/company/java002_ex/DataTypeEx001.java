package com.company.java002_ex;

import java.util.Scanner;

public class DataTypeEx001 {
	public static void main(String [] args) {
		// GIGO
		// 변수 - 입력 - 처리 - 출력
		//1. 변수
		int age = 0; 
		Scanner sc = new Scanner(System.in);  // ctrl + shift + o
		
		//2. 입력
		// 당신의 나이를 입력하시오 > _입력받기
		System.out.print("당신의 나이를 입력하시오 >"); 
		age=sc.nextInt();
		
		//3. 처리  X
		//4. 출력 
		// 내 나이는 ** 입니다.
		System.out.println( "내 나이는 "+age + " 입니다."); 
		System.out.printf(  "내 나이는 %d 입니다."  , age);  
		
	}// end main
} // end class

/*
연습문제1)    ※ DataType002  참고
패키지명 : com.company.java002_ex
클래스명 : DataTypeEx001
출력내용 : 
   1-1.  나이를 입력받을 자료형 선택후  변수명  age로 하시오.  예) 10,20
   1-2.  Scanner이용해서 나이 입력받고 출력하시오.
  
    당신의 나이를 입력하시오 > _입력받기
    내 나이는 ** 입니다.
*/
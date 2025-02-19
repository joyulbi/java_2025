package com.company.java002_ex;

import java.util.Scanner;

public class DataTypeEx003 {
	public static void main(String[] args) {
		//변수-입력-처리-출력
		//변수  (7자리 float / 15자리 double )
		float   pi=0.0f;
		Scanner scanner = new Scanner(System.in);
		
		//입력  파이값을 입력하시오 > _입력받기
		System.out.print("파이값을 입력하시오 >");  pi = scanner.nextFloat();
		
		//처리  X
		
		//출력  파이값은 **입니다.
		System.out.println("파이값은 "+pi+"입니다.");
		System.out.printf("파이값은 %f입니다.\n" , pi);
		System.out.printf("파이값은 %.2f입니다\n." , pi);
		System.out.printf("파이값은 %.3f입니다\n." , pi);
	}
}

/*
연습문제3)
패키지명 : com.company.java002_ex
클래스명 : DataTypeEx003
출력내용 :  Scanner이용해서 파이값을 입력받고 출력하시오. 
     파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
     파이값은 **입니다.
*/
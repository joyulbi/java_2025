package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {
	public static void main(String[]args) {
	int ko, eng, ma,le; //국어
	double result;
	Scanner scanner = new Scanner(System.in);
	System.out.print("국어점수를 입력하세요 : ");
	ko=scanner.nextInt();
	System.out.print("영어점수를 입력하세요 : ");
	eng=scanner.nextInt();
	System.out.print("수학점수를 입력하세요 : ");
	ma=scanner.nextInt();
	result = (double)(ko+eng+ma)/3;	
	System.out.printf("국어%d 영어 %d 수학 %d 총점 %d 평균 %.1f 레벨 %d", ko,eng,ma,ko+eng+ma,result,(int)result/10);
	// 출력 줄바꿈 /r/n
	}
}

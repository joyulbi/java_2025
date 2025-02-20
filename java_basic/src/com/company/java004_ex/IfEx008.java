package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("학번 입력 >");
		int StudentNum = scanner.nextInt();
		System.out.print("국어점수 입력 >");
		int ko = scanner.nextInt();
		System.out.print("수학점수 입력 >");
		int math = scanner.nextInt();
		System.out.print("영어점수 입력 >");
		int eng = scanner.nextInt();
		int total = ko+math+eng;
		double avg = (double)total/3;
		avg= Math.round(avg*100)/100.0;
		String acceptance = "",level = "",good= "";
		int bad=0;
		//if(avg<=100 && avg>=0){
			if (avg>=60 && ko>=40 && math>=40 && eng>=40) {
				acceptance = "합격";
				if(avg>=95) {good ="장학생";}
				if(avg>=90) {level ="수";}
				else if(avg>=80) {level ="우";}
				else if(avg>=70) {level ="미";}
				else if (avg>=60){level ="양";}
			}else {acceptance = "불합격"; level ="가";}
			System.out.println("학번"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균"+"\t"+"합격여부"+"\t"+"레벨"+"\t"+"장학생");
			System.out.println(StudentNum+"\t"+ko+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+acceptance+"\t"+level+"\t"+good);
		//}else {System.out.println("올바른 값을 입력하세요.");}
	}
}


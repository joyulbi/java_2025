package com.company.java008_ex;
import java.util.Scanner;
public class MethodEx004 { 
	public static void main(String[] args) {
		String name="";
		int kor,eng,math,total;
		float avg=0.0f;
		String pass="";
		String jang="";
		String star="";
		String level_kor=""; String level_eng=""; String level_math="";
		String re="";
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("이름을 입력하세요>");
		name = scanner.next();
		System.out.print("국어점수를 입력하세요>");
		kor = scanner.nextInt();
		System.out.print("영어점수를 입력하세요>");
		eng = scanner.nextInt();
		System.out.print("수학점수를 입력하세요>");
		math = scanner.nextInt();
		
		total=process_total(kor,eng,math);
		avg=process_avg(total);
		jang=process_scholar(avg);
		star=process_star(avg);
		pass=process_pass(avg,kor,eng,math);
		process_show(name,kor,eng,math,total,avg,pass,jang,star);
	}
	
	
	public static int process_total(int a,int b,int c) {return a+b+c;}
	public static float process_avg(float a) {return (float)a/3;}
	public static String process_scholar(float a) {
		String b="";
		return a>=95?b="장학생":"---";}
	public static String process_star(float a) {
		String b="";
		for(int i=1;i<=a/10;i++) {b+="★";} 
		return b;}
		//return (((int)a==100)?b="**********":((int)a>=90)?b="*********":((int)a>=80)?b="********":((int)a>=70)?b="*******":"");}
	public static String process_pass(float avg,int kor, int eng, int math ) {
		return avg<60?"불합격":kor<40||eng<40||math<40?"재시험":"합격";
	}
	public static void process_show(String name, int kor, int eng, int math, int total, float avg, String pass, String jang, String star) {
		 System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\r\n"
		    		+ "이름\t국어\t영어\t수학\t총점\t평균\t합격\t장학생\t별	\r\n"
		    		+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",name,kor,eng,math,total,avg,pass,jang,star);}
	
	
}



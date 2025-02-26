package com.company.java008_ex;

public class MethodEx003 { 
	public static int return_num() {return 1;}
	public static float return_float() {return 10/(float)3;}
	public static String mycolor() {return "PURPLE";}
	public static String jansu() {return "★★★★★";}
	public static int myadd(int a,int b) {return a+b;}
	public static String myban(char a) {
		String ban="";
		return "나는 "+ ((a=='A')?ban="노랑조":(a=='B')?ban="주황조":"");}
	public static String stdId(int a) {return "G"+a;}
	public static char stdAvg(int a) {
		char grade=' ';
		return ((a>=90)?grade ='A':(a>=80)?grade ='B':(a>=70)?grade ='C':'D');}
	
	public static void main(String[] args) {
		System.out.println("1. 내가 좋아하는 숫자 : "+return_num());
		System.out.println("2. 10/3.0을 실수로 표현 : "+return_float());
		System.out.println("3. BEST COLOR : "+mycolor());
		System.out.println("4. 장수돌침대 별이 : "+jansu());
		System.out.println("5. 10 + 20 = "+myadd(10,20));
		System.out.println("6. 반(노랑조/주황조) : "+myban('B'));
		System.out.println("7. 당신의 학번은? "+stdId(1111));
		System.out.println("8. 당신의 평균은? "+stdAvg(88));
	}
}



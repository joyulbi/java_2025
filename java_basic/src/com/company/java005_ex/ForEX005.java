package com.company.java005_ex;

public class ForEX005 {
	public static void main(String [] args) {
		int count=0;
		int count1 = 0;
		
		for(int i =1; i<=10;i++) {
			if(i%3==0) {count ++;}}
		
		for(int i ='a';i<='z';i++) {
			if(i=='a'||i=='e'||i=='i'||i=='o'||i=='u') {count1++;}}
		System.out.println("3의 배수 개수 : "+count+"\n"+"모음개수 : "+count1);
	}
}

package com.company.java006_ex;

public class RepeatEx008 {
	public static void main(String[]args) {
		int sum=0;
		//for
		for(int i=1;i<=20;i++) {
			if(i%3==0) {System.out.print(i==3?i:"+"+i);sum +=i;}}
		System.out.print("="+sum);
		System.out.println();
		
		//while
		sum=0;
		int i=1;
		while(i<=10) {if(i%3==0) {System.out.print(i==3?i:"+"+i);sum +=i;}i++;}
		System.out.print("="+sum);
		System.out.println();
		
		//do while
		i=1;
		sum=0;
		do{if(i%3==0) {System.out.print(i==3?i:"+"+i);sum +=i;}i++;}while(i<=10);
		System.out.print("="+sum);
	}
}

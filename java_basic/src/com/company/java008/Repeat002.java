package com.company.java008;

public class Repeat002 {
	public static void main(String[] args) {
		//for
		for(int i =100; i<=300;i+=100) {System.out.print(i+" ");}
		System.out.println();
		//while
		int i =100;
		while(i<=300) {System.out.print(i+" ");i+=100;}
		System.out.println();
		//do while
		i =100;
		do{System.out.print(i+" ");i+=100;}while(i<=300);
	}

}

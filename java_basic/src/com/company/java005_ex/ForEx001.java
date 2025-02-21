package com.company.java005_ex;

public class ForEx001 {
	public static void main(String [] args) {
		//q1
		for(int i=1; i<=5; i++)
		{System.out.printf("%d ",i);} System.out.println();
		//q2
		for(int i=5; i>=1; i--)
		{System.out.printf("%d ",i);} System.out.println();
		//q3
		for(int i=1; i<=3; i++)
		{System.out.print("JAVA"+i+"\t");} System.out.println();
		//q4
		for(int i=3; i>=1; i--)
		{System.out.print("HAPPY"+i+"\t");} System.out.println();
		//q5
		for(int i=0; i<=2; i++)
		{System.out.print((i==0?"":",")+i);} System.out.println();
		//q6
		for(int i=0; i<=99; i++)
		{System.out.print((i==0?"":",")+i);} System.out.println();
		//q7
		for(int i=10; i>=1; i--)
		{System.out.print((i==10?"":",")+i);} System.out.println();
		//q8
		for(int i=0; i<=8; i++)
		{if(i%2==0) {System.out.print((i==0?"":",")+i);}} System.out.println();
		//q9
		for(int i=0; i<=18; i++)
		{if(i%2==0) {System.out.printf((i==0?"":",")+i);}} System.out.println();
	}
}

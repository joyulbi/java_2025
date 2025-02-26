package com.company.java008;

public class Repeat003 {
	public static void main(String[] args) {
		int[]arr= new int[3];
		int data = 10;
		for(int i=0; i<arr.length; i++) {arr[i]=data; data+=10;}
		for(int i=0; i<arr.length; i++) {System.out.print(arr[i]+"\t");}
	}
}

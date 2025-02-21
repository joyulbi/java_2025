package com.company.java005_ex;

public class ForEX003 {
	public static void main(String [] args) {
		System.out.println();
		int sum = 0 ;
		for(int i=1;i<=10;i++) {
			sum += i;
			System.out.print(i!=1?" + "+i:i);}
			System.out.println(" = "+sum);
	}

}

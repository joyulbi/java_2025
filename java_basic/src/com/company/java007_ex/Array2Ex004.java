package com.company.java007_ex;

public class Array2Ex004 {
	public static void main(String[] args) {
		int[][]arr=new int[2][3];
		char data='A';
		for(int ch=0;ch<arr.length;ch++) {
			for(int kan=0;kan<arr[ch].length;kan++ ) {
				arr[ch][kan]=data;
				data++;
				System.out.print((char)arr[ch][kan]+"\t");
			}
			data='B';
			System.out.println();}
	}
}

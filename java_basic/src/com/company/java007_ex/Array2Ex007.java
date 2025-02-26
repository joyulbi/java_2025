package com.company.java007_ex;

public class Array2Ex007 {
	public static void main(String[] args) {
		int [][]arr=new int[5][5];
		int data=1;
		//대입
		for(int ch=0;ch<arr.length;ch++){
			for(int i=0;i<arr[ch].length;i++){
				arr[ch][i]=data++;
				System.out.print(arr[ch][i]+" ");}//end for 층 끝나면 할 일
			System.out.println();}//end for
	}
}

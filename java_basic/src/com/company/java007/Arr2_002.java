package com.company.java007;
import java.util.Arrays;
public class Arr2_002 {
	public static void main(String[] args) {
		int arr[][]=new int[2][3];
		
		int data=1;
		for(int ch=0;ch<2;ch++) {
			for(int kan=0;kan<3;kan++) {arr[ch][kan]=data; data++; System.out.print(arr[ch][kan]+"\t");}
			System.out.println();}
		
	}
}

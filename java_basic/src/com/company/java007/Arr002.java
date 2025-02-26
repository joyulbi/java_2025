package com.company.java007;
import java.util.Arrays;
public class Arr002 {
	public static void main(String[] args) {
		int[]arr= {1,2,3};
		int[]arr2=new int[3];
		System.out.println(arr);
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		
		int data=10;
		for(int i=0; i<arr2.length;i++) {arr2[i]=data;data+=10;}
		System.out.println(Arrays.toString(arr2));
	}
}

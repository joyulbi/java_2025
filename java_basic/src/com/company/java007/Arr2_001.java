package com.company.java007;
import java.util.Arrays;
public class Arr2_001 {
	public static void main(String[] args) {
		int[][]arr= {{1,2,3},{4,5,6}};
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr));
	
		System.out.print(arr[0][0]+"\t");
		System.out.print(arr[0][1]+"\t");
		System.out.print(arr[0][2]+"\t");
		System.out.println();
		
		for(int ch=0;ch<2;ch++) {
			for(int kan=0; kan<3;kan++) {System.out.print(arr[ch][kan]+"\t");}
			System.out.println();
		}
	}
}

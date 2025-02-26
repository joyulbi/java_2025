package com.company.java008;

public class Repeat004 {
	public static void main(String[] args) {
		int[][]arr2=new int[2][3];
		//ver1
//		arr2[0][0]=10;
//		arr2[0][1]=20;
//		arr2[0][2]=30;
//		arr2[1][0]=50;
//		arr2[1][1]=60;
//		arr2[1][2]=70;
		
		//ver2
//		int data=10;
//		arr2[0][0]=data; data+=10;
//		arr2[0][1]=data; data+=10;
//		arr2[0][2]=data; data+=10;
//		
//		data = 50;
//		arr2[1][0]=data; data+=10;
//		arr2[1][1]=data; data+=10;
//		arr2[1][2]=data; data+=10;
		
		//ver3
//		int data=10;
//		for(int kan=0;kan<arr2.length;kan++){arr2[0][kan]=data; data+=10;}
//		data=50;
//		for(int kan=0;kan<arr2.length;kan++){arr2[1][kan]=data; data+=10;}
		
		int data=10;
		for(int ch=0;ch<arr2.length; ch++) { //0,1 2보다 작다
			for(int kan=0;kan<arr2[ch].length;kan++)
			{arr2[ch][kan]=data; data+=10; System.out.print(arr2[ch][kan]+"\t");}}
		System.out.println();
		
		data=50;
		for(int kan=0;kan<arr2[1].length;kan++){arr2[1][kan]=data; data+=10;System.out.print(arr2[1][kan]+"\t");}
		
	}
}

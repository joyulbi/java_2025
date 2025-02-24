package com.company.java006_ex;

public class ArrayEx004 {
	public static void main(String[] args) {
		int cnt=0;
		char[]arr = {'B','a','n','a','n','a'};
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='a') {
				cnt+=1;
			}
		}
		System.out.print("a의 개수는 : "+cnt);
		
	}
}

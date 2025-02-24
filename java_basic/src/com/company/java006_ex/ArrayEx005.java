package com.company.java006_ex;

public class ArrayEx005 {
	public static void main(String[] args) {
		int cnt=0;
		int cnt1=0;
		char[]ch = {'B','a','n','a','n','a'};
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>='A'&&ch[i]<='Z') {
				cnt+=1;
				System.out.print((char)(ch[i]+32)+" ");
			}else if(ch[i]>='a'&&ch[i]<='z') {
				cnt1+=1;
				System.out.print((char)(ch[i]-32)+" ");
			}
		}
		System.out.println();
		System.out.println("대문자의 개수는 : "+cnt);
		System.out.print("소문자의 개수는 : "+cnt1);
	}
}

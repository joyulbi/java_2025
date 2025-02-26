package com.company.java007_ex;

public class Array1Ex007 {
	public static void main(String[] args) {
		//변수
		char[]arr=new char[5];
		char ch ='A';
		for(int i=0;i<arr.length;i++){arr[i]=ch++;}
		//출력
		for(int i=0;i<arr.length;i++) {System.out.print(arr[i]+"\t");}
	}
}
/*
연습문제7)  array
패키지명 : com.company.java007_ex
클래스명 :  ArrayEx007
    new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 : A	B	C	D	E    for+length 이용해보기
    3. for + length 로 출력
*/
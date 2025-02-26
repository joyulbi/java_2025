package com.company.java007;

public class Repeat {
	public static void main(String[] args) {
//		4) 클래스명 : Repeat004
//		1. 배열명 : arr
//		2. 값     : 1,2,3
//		3. for + length 를 이용하여  배열안의 1,2,3을 출력하시오.
	   int []     arr =	{1,2,3};
	   //[1번지]{1,2,3} ← arr:1번지  3갯수: 0~2 인덱스번호
	   System.out.print(arr[0] +"\t");  
	   System.out.print(arr[1] +"\t");
	   System.out.print(arr[2] +"\t");  System.out.println();
	   
	   // {}  {변수}  for(시작;종료;변화)
	   for(int i=0; i<arr.length; i++){ System.out.print(arr[i] +"\t");  }
	}
}

/*
0)  이론
1.   자바의 자료형은 (  기본형 - 값 )   /  ( 참조형 - 주소  )  로 분류된다.
2.   자바의 기본형은 (  boolean : 1byte  ,  
  					byte :1byte ,short/char : 2byte ,int:4byte , long:8byte  ,
  					float: 4byte   , double :8byte     ) 가 있다.
  	 > 정수는 실수보다 크다				
3.   자바의 형변환은 ( boolean  ) 빼고 기본형에서 가능하다. 
4.   ch  가 대문자일경우 조건식작성  'A'  <= ch   &&  ch <='Z'
5.   ch  가 소문자일경우 조건식작성  'a'  <= ch   &&  ch <='z'
6.   a   가 0~100사이일 경우 조건식 작성   0  <= a   &&  a <=100
*/

package com.company.java003;

public class Casting001 {
	public static void main(String[]args) {
		//#1. 형 변환 - 자동 타입 변환
		//byte < short < int < long < float < double
		byte by = 1;
		short sh = 2;
		int in = 4;
		long l = 8L;
		float f = 3.14f;
		double d =3.14;
		
		sh = by; // 정수 - 정수
		in = by; 
		l = by;
		
		// boolean 1byte
		// boolean bl = true;
		// in = bl; boolean은 형변환안됨
		//l = f; // l(8byte) f(4fbyte) 정수 < 실수
		f = l;
		
		//#2. 형 변환 - 강제 타입 변환
		by = (byte)in;
		
		int in2 =(int)1.2;
		float f12 =3.14f;
		//실수(4byte)         - 실수(double : 8byte)
		//float : 소수점 7자리 - 소수점자리 15자리
		
		System.out.println(in2);
		System.out.println(f12);
		
		System.out.println((int)1.5+(int)2.7);
		
	}
}

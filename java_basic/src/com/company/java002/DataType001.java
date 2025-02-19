package com.company.java002;

public class DataType001 {
	public static void main(String [] args) {
		//1. 자바의 자료형 분류( 기본형 / 참조형 )
		//2. 기본형 : 값 저장
		//   논리,정수, 실수
		boolean bl = true; // true/false
		System.out.println("1.논리:"+bl);
		
		//정수 (1,2,4,8 : byte-short-int★ -long:L)
		byte by = 1;
		//1.bit(0,1) = 8bit = 1byte
		//2. 1bit(0,1)    2bit(0,1)(0,1) - (00,01,10,11)
		//3. 20^ = 1
		//4. -128~0~127
		short sh =2; int in=4; long l =8L;
		System.out.println("2.정수 byte-short-int★ -long:"+l);	
		//1. 연산 시 + 2. int(기본 자료형보다 작은애: byte,short) 연산시 주의
		
		int result = by+sh;  //1(int) + 2(int)
		System.out.println(result);
		
		// 실수 (float / double★)  소수점붙은애들!
		float fl=3.14f;    double d=3.14;
		System.out.println("3. 실수 float - double★ : " + fl + "\t" + d);
		
		System.out.println("4. 실수 > 정수 ");
		fl = l;        // fl( 실수 : 4byte ) - long( 정수 : 8byte) 
		System.out.println(fl);  //8.0
		
		System.out.println("5. 정밀도");  // float 몇자리  +  double 몇자리?
		float  fper1 = 1.0000001f;    //0 6개   + 1 = 7개 #
		float  fper2 = 1.11111111f;   //0 7개   + 1 = 8개 
		double dper1 = 1.000000000000001;   //0 14개 + 1 = 15개 #
		double dper2 = 1.1111111111111111;  //0 15개 + 1 = 16개 - 넘어가면 반올림이 버림

		System.out.println(fper1 + "\n" + fper2);
		System.out.println(dper1 + "\n" + dper2);
		
		int a = 2>>32;   // int - 4byte - 8*4byte - 32    
		int b = 2>>33;   // 1
		System.out.println(a + "\t" + b);
		
		System.out.println("6. 문자 저장시 숫자로 - 출력시 문자로");
		char ch = 'A';  // 문자 ' '
		System.out.println(      ch ); // 출력
		System.out.println( (int)ch ); // (int) 정수표현시  65   ##
		            
	}

}

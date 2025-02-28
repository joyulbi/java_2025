package com.company.java010_ex;

class Area1{
	static double  pi = 3.14;
	static double rect(int i, int j) {return i*j;}
	static double triangle(int i, int j) {return i*j/2;}
}
public class StaticEx001 {
	public static void main(String[] args) {
		System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
		System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
		System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
	}
}

package com.company.java014;

interface Inter1{void method();} // public abstract
class Inter1Impl implements Inter1{
	@Override public void method() {System.out.println("....done!");}	
}//1-1 클래스 구현

public class NoNameClass001 {
	public static void main(String[] args) {
		//1. 인터페이스 상속 구현 객체
		//1-2. 실체화객체 테스트
		// 부모	  =	 자식			  @Override 자식메서드
		Inter1 i1 = new Inter1Impl(); i1.method(); // ....done!
		
		//2. 익명이너클래스
//		Inter1 i2 = new Inter(); //void method(); {}없어서 불가능!
		Inter1 i2 = new Inter1() {
			@Override public void method() {System.out.println(".... test");}	
		};// 테스트목적, 잘 안 쓰는..
		i2.method();
	}
}

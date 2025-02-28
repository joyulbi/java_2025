package com.company.java010_ex;

//1.클래스는 부품객체
//2.상태(멤버변수)와 행위(멤버함수)

class Card{
	int cardNum; boolean isMembership;
	//Card(){} 생략돼있음 컴파일러가 자동생성 개발자가 손대는 순간 자동생성 취소
	@Override
	public String toString() {
		return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]";
	}
	// 1. Card() : 생성자 오버로딩시 컴파일러가 기본생성자 자동생성 취소	
	// 1. Card() : 기본생성자 기본 셋팅 - cardNum=1; 멤버쉽=true;
	public Card(int cardNum, boolean isMembership) {super();this.cardNum = cardNum;this.isMembership = isMembership;}
	public Card() {this.cardNum =1;this.isMembership = true;} 
}

public class ClassEx005 {
	public static void main(String[] args) {
		Card c1= new Card(); 
		System.out.println(c1);  
		Card c2=new Card(3,false);
		System.out.println(c2);
	}
}

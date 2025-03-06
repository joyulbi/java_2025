package com.company.java013;
/*
1. 클래스 부품객체 (멤버변수 + 멤버함수)
		Object			Object(){#3				} #4
		  ↑
		Parent   i,j	Parent(int i,int j){#2	i=10,j=20} #5
		  ↑
		Child    k		Child(10,20,30){#1	k=30} #6
*/
//Q.15 누구 호출한건지 적기
class Parent{
	int i,j; //인스턴스변수
	public Parent() {super();} // Object() 인스턴스 메서드
	public Parent(int i, int j) { //인스턴스메서드
		super(); // Object()
		this.i = i; this.j = j; }
}

class Child extends Parent{
	int k; //인스턴스변수
	public Child() { super(); }//Parent()
	public Child(int i, int j,int k) { super(i, j); this.k=k; }//Parent(int i,int j) 지역변수
	
}
public class Repeat005 {
	public static void main(String[] args) {
		Child child = new Child(10,20,30);
		System.out.println(child.i); //10
		System.out.println(child.j); //20
		System.out.println(child.k); //30
	}

}

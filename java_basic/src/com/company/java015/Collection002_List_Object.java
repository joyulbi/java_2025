package com.company.java015;

import java.util.ArrayList;
import java.util.List;

// 1. Dto (데이터전달 : 생성자, toString, getters/setters)
class Milk{
	private int    mno;
	private String name;
	private int    mprice;
	
	public Milk() { super(); }
	public Milk(int mno, String name, int mprice) { super(); this.mno = mno; this.name = name; this.mprice = mprice; }
	@Override public String toString() { return "Milk [mno=" + mno + ", name=" + name + ", mprice=" + mprice + "]"; }
	
	public int getMno() { return mno; } 
	public void setMno(int mno) { this.mno = mno; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getMprice() { return mprice; }
	public void setMprice(int mprice) { this.mprice = mprice; }
	// alt + shift + s
}

public class Collection002_List_Object {
	public static void main(String[] args) {
		//2. Milk 자료형으로 ArrayList 동적배열만들기 milks
		List<Milk> milks = new ArrayList<>();
		
		//3. data넣기
		milks.add(  new Milk(1, "white", 1200));
		milks.add(  new Milk(2, "choco", 1400));
		milks.add(  new Milk(3, "banana", 1500));
		
		//4. 출력
		// for + size
		for(int i=0; i<milks.size(); i++) {
			Milk temp = milks.get(i);  //milks.get(0); milks.get(1); milks.get(2);
			System.out.println(temp.getMno() + "/" + temp.getName() + "/" + temp.getMprice());
		}
		System.out.println();
		System.out.println();
		// 향상된 for
		for(Milk temp :   milks ) { // for( 꺼내올자료형 a   : 배열 or list )
			System.out.println(temp.getMno() + "/" + temp.getName() + "/" + temp.getMprice());
		}
		
	}
}














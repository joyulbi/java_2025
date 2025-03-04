package com.company.java011; //1. java011 폴더
import com.company.java011_ex.Cat;

class Cat2 extends Cat{ //Cat2 : java011 /cat : java011_ex
	
	public void show() {
		public_=10;
		protected_=20; //extends 사용가능
//		package_=30; //같은 폴더에서 사용가능 - 폴더가 다름
//		private_=40; //Cat 클래스에서만 사용 - getter/setter
		System.out.println(public_+"/"+protected_);
	}
}  //2. extends Cat의 기능 사용[상속]

public class Modifier2_protected {
	public static void main(String[] args) {
		Cat2 cat2 = new Cat2();
		cat2.show();
		cat2.public_=100; // 아무데서나 접근가능
		cat2.show();
//		cat2.protected_=200; // extends 키워드를 받은 적 X 
	}
}
/*
-------------------------------------
[method:정보]   User002.class   , FinalEx.class , final{nation, jumin}  //##1
-------------------------------------
[heap]                       	| [stack]
1번지 : {nation, jumin,name }
                         		|  main  //##2
-------------------------------------
 */
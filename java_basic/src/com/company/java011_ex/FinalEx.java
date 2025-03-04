package com.company.java011_ex;

/* 초기화 순서 :  기본 값 -> 명시적 초기화 - > 초기화 블록 -> 생성자
fianl nation 	null 	 Korea			Korea		Korea
fianl jumin  	null	 null			null		00000
	name  		null	 null			null		.연산자이용, 수정가능
 * */

class User002 {
	final String nation = "Korea";   //수정 x
	final String jumin;   // 수정 x
	String name;

	public User002() { jumin="00000"; }
	public User002(String jumin, String name) {
		this.jumin = jumin;
		this.name = name;
		
	}
	@Override
	public String toString() {
		return "User002 [nation=" + nation + ", jumin=" + jumin + ", name=" + name + "]";
	}
}
public class FinalEx {
	public static void main(String[] args) {
	User002 user1 = new User002("123456-1234567", "아이유");
	System.out.println(user1);   
	      
//	user1.nation = "USA";      
//	user1.jumin  = "123123-1234321"; 
	user1.name = "IU"; 
	System.out.println(user1);   
	}
}

/*
-----------------------------------------------------------
[method]	User002.class , FinalEx.class, final{nation, jumin} //#1
-----------------------------------------------------------
[heap]													| [stack]
1번지 : {nation=korea, jumin=123456-1234567, name=아이유} ← user1
														| [main] //#2
-----------------------------------------------------------
 * */




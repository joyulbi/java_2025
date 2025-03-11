package com.company.java015_ex;

import java.util.HashSet;
import java.util.Set;

public class SetEx003 {
	public static void main(String[] args) {
		Set<Integer>  lotto = new HashSet<>();  //1~45사이
		
		System.out.println("1. 랜덤: 0    ~ 0.99999     > "+ Math.random());  
		System.out.println("2. *45: 0*45 ~ 0.99999*45  >" + Math.random()*45);   //0~44.9999
		System.out.println("3. 소수점떼버리기              >" + (int)(Math.random()*45)); //0~44
		System.out.println("4. +1                      >" + ((int)(Math.random()*45)+1)); //1~45
		
		
		while( lotto.size()< 6) {  // 6개보다 작다라면 계속 로또 추가
			lotto.add(   (int)(Math.random()*45)+1  );
			// (int)(Math.random() * 원하는 갯수)+1
		}
		System.out.println(lotto);
	}
	
}
/*
연습문제3)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : SetEx003
- 중복되는 숫자없이  랜덤으로 숫자6개를 받는 로또(1~45)를 만들려고 한다.
1. 알맞은 콜렉션프레임워크는?    Set
  > 동적배열 - 객체만 저장
  > List   - 기차  : index(O), 중복허용(O)  , add/get/size/remove/contains
  > Set    - 주머지 :index(X), 중복허용(X)  , add/get(X) 향for,Iterator/size/remove/contains
  > Map
2. 프로그램을 작성하시오.
 
*/
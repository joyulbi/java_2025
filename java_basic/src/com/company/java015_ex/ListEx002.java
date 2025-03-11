package com.company.java015_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx002 {
	public static void main(String[] args) {
		//1.  numbers ArrayList 만들기
		List<String>  numbers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		//2.  one, two, three 데이터 추가
		numbers.add("one");  numbers.add("two");  numbers.add("three");
		
		//3.  사용자에게 1,2,3 입력받기
		System.out.print("1,2,3중에 입력해주세요 >");
		int  num = scanner.nextInt();

		//ver-1
		//4.     if( 1을 입력받으면){ one 출력}    numbers.get(0)
		//  else if( 2를입력받으면 ){ two 출력}    numbers.get(1)
		//  else if( 3을입력받으면 ){ three 출력}  numbers.get(2)
		/*
		      if( num==1){ System.out.println(numbers.get(0));}     1-1
		 else if( num==2){ System.out.println(numbers.get(1));}     2-1
		 else if( num==3){ System.out.println(numbers.get(2));}     3-1
		 */     
		//ver-2		      
		/*
		for(int i=1; i<=numbers.size(); i++)  //1~3 : 1
		{  if( num==i){ System.out.println(numbers.get(i-1));  break;  }   }
		*/
		//ver-3
		System.out.println(numbers.get(num-1)); 
		
	}// end main 
} // end class
/*
연습문제2)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : ListEx002
1.  numbers ArrayList 만들기
2.  one, two, three 데이터 추가
3.  사용자에게 1,2,3 입력받기
4.  1을 입력받으면 one 출력
    2를입력받으면 two 출력
    3을입력받으면 three 출력
*/
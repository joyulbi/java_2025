package com.company.java003;

import java.util.Scanner;

public class Operator001 {
	public static void main(String[]args) {
		//먼저() 값(+,-,*,/,%,++,--) 비교(>,<..) 조건 처리 후(&&,||,?:) 대입
		//1.값
		int a=10,b=3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		System.out.println(0%2+" "+1%2+" "+2%2);
		
		//2.비교
		System.out.println(10<3);
		
		//3.조건 처리
		//( & &&-->(조건1,조건2 모든조건 만족시) | || -->(조건1,조건2 여러조건 중 하나))
		System.out.println("&"+(false & true));//& 처음도 false 뒤에 조건까지읽음
		System.out.println("&&"+(false && true));//Dead code
		System.out.println("|"+(false | true));
		System.out.println("||"+(false || true));
		System.out.println(10>3 && 10>3);
		System.out.println(10<3 || 10>3);
		System.out.println(a%2==0 && b%3==0);
		
		
		
		//3.조건처리 (조건)? 참:거짓
		System.out.println((a>b)?"1":"2");
		System.out.println((3%2==0)?"짝수":"홀수");
		System.out.println((a%2==0 && a%5==0)? "true":"false");
		System.out.println((a%2==0 || a%3==0)? "true":"false");
		//숫자입력 받아서 양수면 양수 음수면 음수 0이면 0
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요>");
	    int c = scanner.nextInt();
	    System.out.println((c>0)?"양수":(c<0)?"음수":"0");

		//4.대입
	    a=10;
	    System.out.println(a+=b); //1)a+b 2)a=1번한 결과
	    System.out.println(a-=b);
	    System.out.println(a*=b);
	    System.out.println(a/=b);
	    System.out.println(a%=b);
	    
	    //5.++,--
	    int a1=1,b1=1 ,c1=1, d1=1;
	    System.out.println("++a1:"+(++a1)); // 1씩 더하기
	    System.out.println(a1);
	    System.out.println("b1++:"+(b1++));
	    System.out.println(b1);
	    System.out.println("--c1:"+(--c1));
	    System.out.println(c1);
	    System.out.println("d1--:"+(d1--));
	    System.out.println(d1);
	    
	} 
}







package com.company.java010_ex;
import java.util.Scanner;
//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
//3. 생성자 호출 초기화
class TV{
	String channel; int volume;
	TV(String channel, int volume){this.channel = channel;this.volume = volume;}
	TV() {this.channel = channel;this.volume = volume;}
	//기본 생성자:컴파일러 TV() 기본 자동생성, but 생성자를 개발자가 손대는 순간 자동생성취소
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("채널을 입력하세요> ");this.channel=scanner.next();
		System.out.print("볼륨을 입력하세요> ");this.volume=scanner.nextInt();
	}
	void show() {
		System.out.println("===========TV===========\n"+"채널 : "+this.channel+"\t"+"볼륨 : "+this.volume);
	}
}
public class ClassEx004 {
	public static void main(String[] args) {
		TV t1 = new TV("MBC",6);
		t1.show();
		TV t2 = new TV(); //1.new 객체생성 2.생성자 불러서 초기화 3.t2=2번지
		t2.input();
		t2.show();
	}
}
/*
---------------------------------------------- runtime 
[method:정보,static,final]	TV.class, ClassEx004.class #step1
-------------------------------------------------------
[heap]               					| [stack]
26번째줄 : 								  t2.show() {2번지의 channel출력, 2번지의 volume 출력}
25번째줄 : 2번지{channle=SBS, volume=10}	← t2.input() {1번지의 channel입력, 1번지의 volume 입력}
24번째줄 : 2번지{channle=null, volume=0}	← t2 : 2번지
23번째줄 : 								  t1.show() {1번지의 channel출력, 1번지의 volume 출력}
22번째줄 : 1번지{channle=MBC, volume=8}	← t1 : 1번지
					 					| [main] #step2
-------------------------------------------------------
*/
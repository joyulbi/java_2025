package com.company.java019;

import java.awt.Toolkit;

//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 - 자원(데이터,메모리) + Thread

public class Thread001_why {
	public static void main(String[] args) {
		System.out.println("001. Thread");
		//1. 코어(일꾼수)
		int core = Runtime.getRuntime().availableProcessors();
		System.out.println("1. core(일꾼수) "+core);
		
		//2. 현재스레드(실행 프로그램) 확인 - Thread 작업 수행 클래스
		Thread current = Thread.currentThread();
		System.out.println("2. 현재스레드(실행 프로그램) 이름: "+current.getName());
		System.out.println("3. 활성화 스레드(실행프로그램) 수 : "+Thread.activeCount());
		
		//#1.
		for(int i =0;i<5;i++) {
			System.out.print("˙Ꙫ˙  ");
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		}//작업 수행 클래스 1000이 1초
		
		//#2 비프음
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			toolkit.beep();
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }	
		}
		//˙Ꙫ˙  ˙Ꙫ˙  ˙Ꙫ˙  ˙Ꙫ˙  ˙Ꙫ˙   꿀꿀꿀꿀꿀
	
	}
}

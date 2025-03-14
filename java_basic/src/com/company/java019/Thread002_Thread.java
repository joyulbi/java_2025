package com.company.java019;

import java.awt.Toolkit;

//1. 프로세스 - 실행중 프로그램
//2. 자원 + Thread( 작업 수행 )
//3. 작업 수행 클래스 1)상속, Runnable 2) run()해야할 일 3) start() 실행

class PigSound extends Thread{//#1. 상속 Thread(작업 수행 클래스)
	
	@Override public void run() { //#1. run 해야할일 
		try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			toolkit.beep();
			System.out.print(" 꿀 ");
			try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
		}
	}
	
}

class PigCount extends Thread {
	@Override public void run() {
		for(int i=1;i<6;i++) {
			System.out.print(i+"마리");
			try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
		}
	}
}



public class Thread002_Thread {
	public static void main(String[] args) { //1개의 스레드
		// 여러가지 일을 동시에
		// 작업 스레드 ##3단계
		Thread sound = new PigSound(); sound.start();
		Thread count = new PigCount(); count.start();
		
		// ˙Ꙫ˙ 5번
		for(int i=0;i<5;i++) {
			System.out.print("˙Ꙫ˙ ");
			try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace();}
		}
		
	}
}

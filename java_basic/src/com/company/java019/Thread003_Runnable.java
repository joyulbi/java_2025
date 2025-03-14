package com.company.java019;

//1. 프로세스 - 실행 중 프로그램
//2. 자원 + Thread( 작업수행 )
// 작업 수행 클래스 1) Thread 상속, Runnable # 2) run 해야할일 3) start 실행

class Animal{}
// class CatSound extends Animal ,Thread{} (X)

class CatSound extends Animal implements Runnable{
	@Override public void run() { 
		try { Thread.sleep(10); } catch (InterruptedException e) {  e.printStackTrace(); }
		for(int i=0;i<5;i++) {
			System.out.print(" 냥 ");
			try { Thread.sleep(100); } catch (InterruptedException e) {  e.printStackTrace(); }
		}
	}	
}


public class Thread003_Runnable {
	public static void main(String[] args) {
		Thread sound = new Thread(new CatSound()); sound.start();
		
		Thread count = new Thread(new Runnable() {
			@Override public void run() { 
				for(int i=0;i<5;i++) {
					System.out.print(i+" 마리 ");
					try { Thread.sleep(100); } catch (InterruptedException e) {  e.printStackTrace(); }
				}
			}
			
		}); count.start();
		
		
		
		for(int i=0;i<5;i++ ) {
			System.out.print("（ΦωΦ）");
			try { Thread.sleep(100); } catch (InterruptedException e) {  e.printStackTrace(); }
		}
	}
}

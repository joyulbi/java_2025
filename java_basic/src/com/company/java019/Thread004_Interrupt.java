package com.company.java019;

import java.util.Scanner;

class Count extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println((i));
			try { Thread.sleep(1000); } catch (InterruptedException e) { break;}
		}
	}
}

public class Thread004_Interrupt {
	public static void main(String[] args) {
		Thread count = new Count(); count.start();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("count stop? y/n");
		if(scanner.next().equals("y")) {
			System.out.println("카운트를 멈춥니다.");
			count.interrupt();
		}
		System.out.println("> main end");
	}
}

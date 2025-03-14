package com.company.java019_ex;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

class QuestionCount extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println((i));
			try { Thread.sleep(1000); } catch (InterruptedException e) { break;}
		}
	}
}

class Count extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println((i+1)+"초");
			try { Thread.sleep(1000); } catch (InterruptedException e) {  break;}
		}
	}
}

public class ThreadEx001 {
	public static void main(String[] args) {
		Thread count = new QuestionCount(); count.start();
		Thread count1 = new Count(); count1.start();
		String answer = JOptionPane.showInputDialog("사과 알파벳을 입력하세요.");
	
		if(answer.equals("사과")) {
			System.out.println("정답입니다.");
			count.interrupt();
			count1.interrupt();
		}else {System.out.println("정답이 아닙니다");}
		System.out.println("main-end");

	}
}


/*
1.  QuestionCount  - 10부터 1까지 
      카운트 1초에 10 ,
                2초에 9, 
                3초에  8.....

2. 사과알파벳을 입력하세요.
   사과를 입력을받으면 정답입니다 / 정답이 아닙니다.
*/

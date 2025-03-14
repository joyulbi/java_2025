package com.company.java019_ex;

//1. 프로세스 - 실행중인 프로그램
//2. 프로세스 - 자원 + Thread(실제작업)
//synchronized

//#1 공유자원
class Rank{
	int num=0;
	public synchronized void plusnum() {
		int rank=num;
		try { Thread.sleep(3000); } catch (InterruptedException e) {  e.printStackTrace(); }
		num=rank+1; // 등수올리기
	}
}

//#2. 실행클래스
class User extends Thread{
	Rank rank; // 각 유저마다 몇등이야
	public User(Rank rank) {this.rank=rank;}
	@Override public void run() {
		rank.plusnum();//등수올리기
		System.out.println(rank.num+" 번 >> " + super.getName()); // Thread
	}	
}

public class Thread05_synchronized {
	public static void main(String[] args) {
		Rank rank = new Rank(); //공유자원 num=1, num=2, 등수
		
		Thread user1=new User(rank); user1.setName("first"); user1.start(); //몇번째
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
		
		Thread user2=new User(rank); user2.setName("second"); user2.start(); //몇번째
		
	}
}
/*   synchronized  before)         
	user1   #1 →  [Rank : num (1)   ]  ← #2  user2
	first                    				 second
			#3출력						 #출력
1번 >> first 
1번 >> second
  
/*   synchronized  after)         
	user1 #1(1)  →  [Rank : num (1)]  ←  user2
	first #2(1)                    		 second
	
	user1 #1(1)  →  [Rank : num (2)]  ← #3(2)  user2
	first #2(1)                    		#4(2) second
	
	
public synchronized void plusnum() {  //등수올리기
	int rank=num;
	try { Thread.sleep(3000); } catch (InterruptedException e) {  e.printStackTrace(); }
	num=rank+1; // 등수올리기
}
*/





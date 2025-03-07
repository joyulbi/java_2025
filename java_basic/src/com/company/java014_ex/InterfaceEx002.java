package com.company.java014_ex;

interface Board{public void exec();}
class BoardInsert implements Board{
	@Override public void exec() {System.out.println("게시판 삽입기능입니다."); }	
}
class BoarSelect implements Board{
	@Override public void exec() {System.out.println("게시판 선택기능입니다.");   }	
}
class BoarUpdate implements Board{
	@Override public void exec() {System.out.println("게시판 수정기능입니다."); }	
}
class BoarDelete implements Board{
	@Override public void exec() {System.out.println("게시판 삭제기능입니다.");   }	
}

public class InterfaceEx002 {
	public static void main(String[] args) {
		Board board = null;
		board = new BoardInsert();board.exec();
		board = new BoarDelete();board.exec();
		board = new BoarSelect();board.exec();
		board = new BoarUpdate();board.exec();
		
	}

}

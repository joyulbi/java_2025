package com.thejoa.boot003.board;

import java.util.List;

public interface BoardService { 
	public List<Board> findAll(); //## 전체리스트 뽑고
	public Board find(Long id); //## 조회수올리고 / 상세보기기능
	
	public void insert(Board board, Long member_id); //## 글 쓰기 기능
	public Board update_view(Long id); //## 수정하기 폼
	public void update(Board board); //## 글 수정 기능
	
	public void delete(Board board);//## 글 수정 기능
}

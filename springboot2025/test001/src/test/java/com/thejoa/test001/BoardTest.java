package com.thejoa.test001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.test001.board.Board;
import com.thejoa.test001.board.BoardRepository;

@SpringBootTest
public class BoardTest {

	@Autowired
	private BoardRepository boardRepository;
	
	@Disabled  //@Test
	public void insert() {
		Board board = new Board();
		board.setBcontent("aaa");
		board.setBhit(0L);
		board.setBip("120.0.0.0");
		board.setBpass("aaa");
		board.setBtitle("제목1");
		boardRepository.save(board);
	}
	
	
	
	@Disabled  //@Test
	public void testFindAllOrderByIdDesc() {
		List<Board> boardList = boardRepository.findAllOrderByIdDesc();
		for(Board b:boardList) {
			System.out.println(b.getId()+"/"+b.getBtitle());
		}
	}
	
	@Disabled//@Test
	public void testDeleteByIdAndBpass() {
		Optional<Board> findBoard = boardRepository.findById(4L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			boardRepository.delete(board);
		}
	}
	
	@Test
	public void update() {
		Optional<Board> findBoard = boardRepository.findById(2L);	
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			board.setBtitle("title-new");
			board.setBcontent("content-new");
			boardRepository.save(board);
		}
	}
}

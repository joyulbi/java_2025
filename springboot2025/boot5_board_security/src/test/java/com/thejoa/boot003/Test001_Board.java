package com.thejoa.boot003;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot005.board.Board;
import com.thejoa.boot005.board.BoardRepository;
import com.thejoa.boot005.member.Member;
import com.thejoa.boot005.member.MemberRepository;

@SpringBootTest
public class Test001_Board {
	@Autowired BoardRepository boardRepository;
	@Autowired MemberRepository memberRepository;
	
	@Disabled//@Test
	public void insert_member() {
		Member member =new Member();
		member.setUsername("second");
		member.setEmail("111@naver");
		memberRepository.save(member);
	}
	@Disabled//@Test
	public void insert() {
		Board board = new Board();
		Member member = new Member();
		member.setId(1L);
		board.setBcontent("third");
		board.setBfile("dd");
		board.setBip("a");
		board.setBpass("b");
		board.setBtitle("c");
		try {
			board.setBip(InetAddress.getLocalHost().getHostAddress());
		}catch(UnknownHostException e) {e.printStackTrace();}
		board.setMember(member);
		boardRepository.save(board);
	}
	@Test
	public void selectAll() {
		List<Board> list = boardRepository.findAll();
		System.out.println(list.get(0).getBtitle());
	}
	@Disabled//@Test
	public void findById() {
		Optional<Board> findBoard = boardRepository.findById(4L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			System.out.println(board.getBtitle());
		}
	}
	@Disabled//@Test
	public void update() {
		Optional<Board> findBoard = boardRepository.findById(4L);	
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			board.setBtitle("title-new");
			board.setBcontent("content-new");
			boardRepository.save(board);
		}
	}
	@Disabled//@Test
	public void delete() {
		Optional<Board> findBoard = boardRepository.findById(4L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			boardRepository.delete(board);
		}
	}
}

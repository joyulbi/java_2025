package com.thejoa.boot005.board;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thejoa.boot005.member.MemberRepository;

@Service
public class BoardService{
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	MemberRepository memberRepository;
	
	
	/*	PAGING	*/
	/*	PAGING	*/
	// 1 : 최신글 10 order by bno desc limit 0,10 0번째부터 10개
	// 2 : 그다음최신글 10 order by bno desc limmit 10,10 10번째부터 10개 
	public Page<Board> getPaging(int page){ // 어디서부터
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));//id를 기준으로 내림차순
		
		Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
		return boardRepository.findAll(pageable);
	}
	
	/*	BOARD	*/
	/*	BOARD	*/
	
	
	public List<Board> findAll() { //##전체 리스트 뽑고
		//return boardRepository.findAll();
		return boardRepository.findAllByOrderByDesc();
	}
	
	@Transactional //commit (반영) / rollback (되돌리기)
	public Board find(Long id) { //##조회 수 올리고 / 상세보기가능
		Board board = boardRepository.findById(id).get();
		
		board.setBhit(board.getBhit()+1);//기존 조회수 + 1
		boardRepository.save(board);
		return board;
	}
	
	public void insert(Board board) {
		board.setMember(
				memberRepository.findByUsername(board.getMember().getUsername()).get()
				);
		
		try { board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) { e.printStackTrace(); }
		boardRepository.save(board);
	}
	
	public Board update_view(Long id) {
		return boardRepository.findById(id).get();
	}

	public int update(Board board) {
		return boardRepository.updateByIdAndBpass(
		        board.getId(),
		        board.getBpass(),
		        board.getBtitle(),
		        board.getBcontent()
		);
	}
	
	public int delete(Board board) {
		//boardRepository.delete(board); 기본 : delete from board where id=?
		return boardRepository.deleteByIdAndBpass(board.getId(), board.getBpass());
	}
}

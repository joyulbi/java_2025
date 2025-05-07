package com.thejoa.test001.board;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	 @Autowired
	    private BoardRepository boardRepository;

	    // 전체 리스트 
	    public List<Board> findAll() {
	        return boardRepository.findAllOrderByIdDesc();
	    }

	    // 상세보기 + 조회수 증가
	    @Transactional
	    public Board find(Long id) {
	        Board board = boardRepository.findById(id).get();
	        board.setBhit(board.getBhit() + 1);  // 조회수 증가
	        boardRepository.save(board);
	        return board;  
	    }

	    // 게시글 등록
	    public Board insert(Board board) {
	        try {
	            board.setBip(InetAddress.getLocalHost().getHostAddress());  // 접속 IP 저장
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        }
	        return boardRepository.save(board);
	    }

	    // 수정 폼 데이터 조회
	    public Board updateView(Long id) {
	    	return boardRepository.findById(id).get();
	    }

	    // 제목 + 내용 수정 (비밀번호 일치 시)
	    public int update(Board board) {
	        return boardRepository.updateByIdAndBpass(
	                board.getId(),
	                board.getBpass(),
	                board.getBtitle(),
	                board.getBcontent()
	        );
	    }

	    // 게시글 삭제 (비밀번호 일치 시)
	    public int delete(Board board) {
	        return boardRepository.deleteByIdAndBpass(board.getId(), board.getBpass());
	    }
	}


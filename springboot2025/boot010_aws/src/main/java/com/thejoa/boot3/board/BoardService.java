package com.thejoa.boot3.board;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.thejoa.boot3.member.MemberRepository;
import com.thejoa.boot3.util.UtilUpload;

@Service 
public class BoardService  {
	@Autowired  BoardRepository  boardRepository; //##
	@Autowired MemberRepository memberRepository;
	@Autowired UtilUpload upload;
	
	public Page<Board> getPaging(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));

		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return boardRepository.findAll(pageable);
	}
	
	
	
	public List<Board> findAll() {//##전체리스트뽑고
		//return boardRepository.findAll();
		return   boardRepository.findAllByOrderByDesc();
	}
 
	@Transactional  // commit (반영) / rollback (되돌리기)
	public Board find(Long id) {//##조회수올리고 / 상세보기기능 
		Board board = boardRepository.findById(id).get();
		
		board.setBhit(board.getBhit()+1);   // 기존조회수 + 1
		boardRepository.save(board);
		return board;
	}

	public void insert(MultipartFile file, Board board) {
		//file Upload기능구현
		try { board.setBfile(upload.fileUpload(file));
		} catch (IOException e1) { e1.printStackTrace(); }
		
		board.setMember(
				memberRepository.findByUsername(board.getMember().getUsername()).get()
		);  
		
		try { board.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		boardRepository.save(board);
	}

	public Board update_view(Long id) {
		return boardRepository.findById(id).get();
	}

	public int update(MultipartFile file, Board board) {	
		 if (!file.isEmpty()) { // 새 파일이 업로드된 경우에만 업로드 및 파일명 설정
			 //file Upload기능구현
			 try { board.setBfile(upload.fileUpload(file));
			 } catch (IOException e1) { e1.printStackTrace(); }
		 }	
		return boardRepository.updateByIdAndBpass( 
					board.getId(), board.getBpass(), 
					board.getBtitle(), board.getBcontent(),board.getBfile()
		);
	}

	public int delete(Board board) {
		//boardRepository.delete(board);   기본 : delete from board  where id=?
		return boardRepository.deleteByIdAndBpass(board.getId(), board.getBpass());
	}

}

//
//public void        insert(Board board); //## 글쓰기기능
//
//public Board    update_view(Long id);//## 수정하기 폼
//public void        update(Board board); //## 글수정기능
//
//public void        delete(Board board); //## 글수정기능


package com.company.project001;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.project001.board.BoardMapper;
import com.company.project001.domain.Board;
import com.company.project001.domain.Member;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Project002_board {
   
   @Autowired BoardMapper boardMapper;
   
   @Test
   public void test() {
	   //5.update
	   Board board = boardMapper.findAllByOrderedByDesc().get(0);
	   board.setBtitle("수정된 제목 - new");
	   board.setBcontent("수정된 내용 - new"); //아이디,pass
	   log.info(""+boardMapper.updateByIdAndBpass(board));
	   
	   //4. insert
//	   Member member = new Member();
//	   member.setId(70L);
	   
//	   for(int i=1; i<=100; i++) {
//		   Board board = new Board();
//		   board.setBtitle("테스트 제목"+i);
//		   board.setBcontent("테스트 내용"+i);
//		   board.setBfile("file"+i+".jpg");
//		   board.setBip("127.0.0.1");
//		   board.setBpass("pass"+i);
//		   board.setBhit(0L);
//		   board.setMember(member);
//		   boardMapper.insert(board);
//	   }
      // 3. findById
//      log.info("" + boardMapper.findById(1L));
      // 2. findAllByOrderedByDesc
//      log.info("" + boardMapper.findAllByOrderedByDesc());
      // 1. findAllPaged
//      log.info("" + boardMapper.findAllPaged(10, 0));
   }
}

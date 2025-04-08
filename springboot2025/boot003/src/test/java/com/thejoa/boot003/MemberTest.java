package com.thejoa.boot003;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot003.board.BoardRepository;
import com.thejoa.boot003.member.Member;
import com.thejoa.boot003.member.MemberRepository;

@SpringBootTest
class MemberTest {
	@Autowired MemberRepository memberRepository;
	@Autowired BoardRepository boardRepository;
	@Test  
	public void insert() {
		Member member =new Member();
		member.setName("second");
		member.setAge(22);
		memberRepository.save(member);
	}
}
/*
crud1. insert into team (name) values(?) 
crud2. select * from team / select * from team where id=? 
crud3. update team set name=? where id=? 
crud4. delete from team where id=?
 */
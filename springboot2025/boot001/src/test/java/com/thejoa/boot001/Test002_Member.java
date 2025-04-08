package com.thejoa.boot001;



import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot001.myjpa.Member;
import com.thejoa.boot001.myjpa.MemberRepository;
import com.thejoa.boot001.myjpa.Team;

@SpringBootTest
class Test002_Member {
	@Autowired MemberRepository memberRepository;
	
	@Disabled //@Test  
	public void insert() {
		Team team = new Team();
		team.setId(1L);
		Member member =new Member();
		member.setName("second");
		member.setAge(22);
		member.setTeam(team);
		memberRepository.save(member);
	}
	
	@Disabled //@Test  
	public void selectAll() {
		List<Member> list=memberRepository.findAll();
		for(Member m:list) {System.out.println(m);}
		//System.out.println(list.size());
		System.out.println(list.get(0).getName());
	} 
	
	@Disabled //@Test  
	public void update() {
		//1. 수정 할 팀 찾기
		// Optional<Team>  - null 값 안전보장
		Optional<Member> findMember = memberRepository.findById(2L);
		//System.out.println(findMember.isPresent());
		
		//2. 이름 변경해서 수정
		Member member = findMember.get();
		member.setName("one");
		member.setAge(1);
		memberRepository.save(member); //save:insert,update
	}
	
	
	
	@Disabled//@Test  
	public void delete() {
		//1. 수정 할 팀 찾기
		// Optional<Team>  - null 값 안전보장
		Optional<Member> findMember = memberRepository.findById(2L);
		if(findMember.isPresent()) {
			Member member = findMember.get();
			memberRepository.delete(member);
		}
	}
	

	
}
/*
crud1. insert into team (name) values(?) 
crud2. select * from team / select * from team where id=? 
crud3. update team set name=? where id=? 
crud4. delete from team where id=?
 */
package com.thejoa.boot004;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot004.member.Member;
import com.thejoa.boot004.member.MemberRepository;

@SpringBootTest
class Test1_MemberRepository {
	@Autowired MemberRepository memberRepository;

	
	@Disabled//@Test
	public void insert() {
		Member member = new Member();
		member.setEmail("second");
		member.setPassword("123");
		member.setUsername("two");
		memberRepository.save(member);
	}
	@Disabled//@Test
	public void findAll() {
		List<Member> list=memberRepository.findAll();
		for(Member m:list) {System.out.println(m);}
	}
	
	@Disabled//@Test
	public void findId() {
		System.out.println(memberRepository.findById(1L).get());
	}
	
	@Disabled//@Test
	public void findUsername() {
		System.out.println(memberRepository.findByUsername("first").get());
	}
	
	@Disabled//@Test
	public void update() {
		Member member = memberRepository.findById(1L).get();
		member.setEmail("first-new");
		member.setPassword("111");
		member.setUsername("one-new");
		memberRepository.save(member);
	}
	@Test 
	public void updatePassword() {
		memberRepository.updateByIdAndPassword("1234", "111", 1L); // 바꿀것, 원래것, ID
	}
	
	@Disabled//@Test
	public void delete() {
		Optional<Member> findMember =memberRepository.findById(2L);
		if(findMember.isPresent()) {			
			Member member = findMember.get();
			memberRepository.delete(member);
		}
	}

}

package com.thejoa.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot001.myjpa.Team;
import com.thejoa.boot001.myjpa.TeamRepository;

@SpringBootTest
class Boot001ApplicationTests {
	@Autowired TeamRepository teamRepository;
	
	// teamRepository.save (insert,update) / teamRepository.delete-(delete)
	// teamRepository.findAll() (select) / teamRepository.findById (select)
	
	@Disabled //@Test 
	public void insert() {
		Team team = new Team();
		//team.setName("fruit");
		//team.setName("milk");
		team.setName("animal");
		teamRepository.save(team);
	}
	
	@Disabled //@Test  
	public void selectAll() {
		List<Team> list=teamRepository.findAll();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
	} 
	
	@Disabled //@Test   
	public void update() {
		//1. 수정 할 팀 찾기
		// Optional<Team>  - null 값 안전보장
		Optional<Team> findTeam = teamRepository.findById(1L);
		System.out.println(findTeam.isPresent());
		
		//2. 이름 변경해서 수정
		Team team = findTeam.get();
		team.setName("avenger");
		teamRepository.save(team); //save:insert,update
	}
	
	@Disabled //@Test 
	public void delete() {
		//1. 수정 할 팀 찾기
		// Optional<Team>  - null 값 안전보장
		Optional<Team> findTeam = teamRepository.findById(3L);
		System.out.println(findTeam.isPresent());
		Team team = findTeam.get();
		teamRepository.delete(team);
	}
	
	//////////////////////////////////////////////
	/*@Autowired MemberRepository memberRepository;
	@Test
	public void insert1() {
		Member member = new Member();
		member.setName("animal");
		teamRepository.save(member);	
	}*/
	
}
/*
crud1. insert into team (name) values(?) 
crud2. select * from team / select * from team where id=? 
crud3. update team set name=? where id=? 
crud4. delete from team where id=?
 */
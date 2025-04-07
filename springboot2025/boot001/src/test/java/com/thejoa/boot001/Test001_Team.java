package com.thejoa.boot001;



import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot001.myjpa.Team;
import com.thejoa.boot001.myjpa.TeamRepository;

@SpringBootTest
class Test001_Team {
	@Autowired TeamRepository teamRepository;
	
	@Test
	public void insert() {
		Team team = new Team();
		team.setName("avengers");
		teamRepository.save(team);
	}
	

	

	
}
/*
crud1. insert into team (name) values(?) 
crud2. select * from team / select * from team where id=? 
crud3. update team set name=? where id=? 
crud4. delete from team where id=?
 */
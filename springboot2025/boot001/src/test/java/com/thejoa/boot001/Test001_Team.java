package com.thejoa.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot001.myjpa.Team;
import com.thejoa.boot001.myjpa.TeamRepository;

@SpringBootTest
class Test001_Team {
	@Autowired  TeamRepository  teamRepository;
	
	// teamRepository.save (insert, update) / teamRepository.delete-(delete)
	// teamRepository.findAll  (select)     / teamRepository.findById (select)
	
	@Test 
	//@Disabled  
	public void insert() { 
		Team team = new Team();
		team.setName("avengers");  //milk, fruit , animal
		teamRepository.save(team);
	}
	
	@Disabled  //@Test 
	public void selectAll() {
		List<Team> list = teamRepository.findAll();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
	}
 
	@Disabled  @Test
	public void update() {
		//1. 수정할 팀찾기
		// Optional<Team> - null 값 안전보장
		Optional<Team> findTeam = teamRepository.findById(1L);
		System.out.println(  findTeam.isPresent()  );  // true
		
		//2. 이름변경해서 수정
		Team team = findTeam.get();
		team.setName("avenger");
		teamRepository.save(team);  // save : insert, update
	}
	
	
	@Test
	public void delete() {
		Optional<Team> findTeam = teamRepository.findById(3L);
		System.out.println(  findTeam.isPresent()  );  // true
		
		Team  team = findTeam.get();
		teamRepository.delete(team);
	}

}

//crud1. insert  into team (name) values (?)
//crud2. select * from team  / select * from team where  id=? 
//crud3. update team     set  name=?    where  id=? 
//crud4. delete from     team   where  id=? 
/* 
mysql> desc team;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | YES  |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)
mysql> 
*/
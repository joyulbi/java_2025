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
	@Autowired  MemberRepository  memberRepository;
	
	@Disabled   //@Test
	public void insert() {
		Team   team   = new Team();
		team.setId(1L);
		//team.setId(2L);//##1  error  team의 id가 2L 없어서 오류남.
		
		Member member = new Member();
		member.setName("second");
		member.setAge(22);
		member.setTeam(team); //##2
		memberRepository.save(member);  //## insert, update - save
	}
	// insert into member (name ,age, create_date, team_id) value(?,?,?,?) 
	
	//Q2. findAll  유저들 출력  select - findAll, findById
	@Disabled   //@Test
	public void selectAll() {
		List<Member>  list= memberRepository.findAll();
		for( Member m:  list) { System.out.println(m); }
		System.out.println( list.get(0).getName()); 
	}
	//Q3. update 이용해서 유저번호가 1L인 데이터값 수정
	@Disabled @Test public void update() {
		Optional<Member> member_find  = memberRepository.findById(1L);
		
		if(member_find.isPresent()) {  // 유저가 있다면
			Member member= member_find.get(); // 유저꺼내오기
			member.setName("one");   //first
			member.setAge(1); 
			//member.setTeam(null);   team값 설정안하면 기존에 있었던 값
			memberRepository.save(member);
		}
		
	}
	//Q4. delete 이용해서 1L 유저 삭제
	@Test public void delete() {
		Optional<Member> member_find = memberRepository.findById(1L);
		if(member_find.isPresent()) {  // 유저가 있다면
			Member member=  member_find.get(); // 유저꺼내오기
			memberRepository.delete(member);
		}
	}
	//delete from member where id=?
}
/*
mysql> desc member;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| age         | int          | NO   |     | NULL    |                |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | NO   |     | NULL    |                |
| team_id     | bigint       | YES  | MUL | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)
   
 */
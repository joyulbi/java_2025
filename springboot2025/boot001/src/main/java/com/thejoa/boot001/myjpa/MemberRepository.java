package com.thejoa.boot001.myjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>{
	//JpaRepository<Member,Long> <테이블, pk의 자료형>
}

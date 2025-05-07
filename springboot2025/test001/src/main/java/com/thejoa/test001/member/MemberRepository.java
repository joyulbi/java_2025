package com.thejoa.test001.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
    
    @Modifying
	@Transactional
	@Query("update Member m set m.password=:password where m.password=:old and m.id=:id")
	int updateByIdAndPassword(String password, String old, Long id);
}
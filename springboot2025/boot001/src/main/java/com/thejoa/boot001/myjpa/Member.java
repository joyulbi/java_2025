package com.thejoa.boot001.myjpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id// 기본 값
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long id;
	
	//name="USERNAME" 필드명 수정, NOT NULL 설정
	//@Column(name="USERNAME", nullable=false) //@Transiend 컬럼인식못하게
	//private String name;
	
	@Column(nullable=false)
	private String name;
	
	private int age;
	
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	
	@ManyToOne
	private Team team; 
	// 멤버(iron, hulk, thor,,,)는 하나의 팀을 가진다. 
	// team_id 컬럼 자동으로 생김
}
/*
관계1
 팀(avengers)은 많은 멤버(iron, hulk, thor,,,)를 가진다.
 멤버는 하나의 팀을 가진다.
 
 team -|-----------∈ member
 */

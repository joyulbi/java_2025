package com.thejoa.boot001.myjpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Team {
	@Id //1. 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)//2. 숫자 자동 증가
	private Long id;
	
	private String name;
	
	@Column(updatable = false) // 수정 못 하게
	private LocalDateTime createDate = LocalDateTime.now();
	
	//@Transient //3. 컬럼 인식 못 하게
	//private String email;
	
	// mappedBy 주인, 부모, 부모가 있으면 참조할 수 있게... 자식
	@OneToMany(mappedBy = "team",cascade = CascadeType.REMOVE)
	List<Member> member = new ArrayList<>();
}







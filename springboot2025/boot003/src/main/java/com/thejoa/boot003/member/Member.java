package com.thejoa.boot003.member;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.thejoa.boot003.board.Board;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int age;
	private String name;
	
	@Column(updatable=false)
	private LocalDateTime createDateTime = LocalDateTime.now();
	
	//유저(member:one)은 많은 글(many:board)을 쓸 수 있다.
	@OneToMany(mappedBy = "member")
	List<Board> board = new ArrayList<>();
}


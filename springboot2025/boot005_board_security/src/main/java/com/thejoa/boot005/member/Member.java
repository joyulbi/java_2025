package com.thejoa.boot005.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.thejoa.boot005.board.Board;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true) //유일한 값 설정
	private String username;
	private String password;
	private String email;
	
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	private LocalDateTime udate = LocalDateTime.now();
	
	@OneToMany
	List<Board> board = new ArrayList<>();
}

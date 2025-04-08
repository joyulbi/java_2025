package com.thejoa.boot003.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.ToString;
import com.thejoa.boot003.member.Member;


import lombok.Getter;
import lombok.Setter;

//@Data
@Entity @Getter @Setter @ToString(exclude = "member")
public class Board {
	@Id //1. 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
    private String btitle;
	
	@Column(columnDefinition = "text" )
	private String bcontent;
	
	private String bfile;
	private String bip;
	private String bpass;
	private Long bhit=0L;
	
	@Column(updatable = false) 
	private LocalDateTime createDate = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	
	private Member member;
}







package com.company.project001.domain;

import java.time.LocalDateTime;

import com.company.project001.member.MemberRole;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
	private Long id;
	private String username;
	private String password;
	private String email;
	private String nickname;
	private String image;
	private LocalDateTime udate = LocalDateTime.now();
	private MemberRole role; //ROLE_ADMIN, ROLE_SYSTEM, ROLE_MEMBER
	private String provider; //thejoa, kakao, naver, google
	
	//private List<Board> board; //연관된 게시물 목록 (Mybatis에서 직접매핑)
	
	@Builder
	public Member(String username, String email, String nickname, String image, MemberRole role, String provider) {
		super();
		this.username = username;
		this.email = email;
		this.nickname = nickname;
		this.image = image;
		this.role = role;
		this.provider = provider;
	}	
}

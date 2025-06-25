package com.company.project001.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberLoginForm {
	
	@NotEmpty(message="사용자 ID는 필수 항목입니다.")
	@Size(min=4, max=30)
	private String username;
	
	@NotEmpty(message="비밀번호는 필수 항목입니다.")
	private String password;
}

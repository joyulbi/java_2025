package com.thejoa.test001.member;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> find=memberRepository.findByUsername(username);
		
		if(find.isEmpty()) {  throw new UsernameNotFoundException("사용자를 확인해주세요.");}
		
		Member member = find.get();
		// 권한
		List<GrantedAuthority> authorities = new ArrayList<>();
		if("admin".equals(username)) {
			authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
		}else {
			authorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.getValue()));
		}
		return new User(member.getUsername(), member.getPassword(),authorities);
	}
}
 
package com.company.project001.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.company.project001.domain.Member;

public class MemberUserDetails implements UserDetails, OAuth2User {
	
	private static final long serialVersionUID = 1L;
	private Member member;
	public MemberUserDetails(Member member) { super(); this.member = member; }
   
   ///////////////////////////////////////////
   // 권한작업 role
   @Override public Collection<? extends GrantedAuthority> getAuthorities() {
      Collection<GrantedAuthority> collections = new ArrayList<>();
      collections.add( ()->{ return member.getRole().name(); } );
      return collections;
   }
   // password
   @Override public String getPassword() { return member.getPassword(); }
   // username
   @Override public String getUsername() { return member.getUsername(); }
   // 계정만료 - true 만료X
   @Override public boolean isAccountNonExpired() { return true; }
   // 계정잠금 - true 잠김X
   @Override public boolean isAccountNonLocked() { return true; }
   // 비밀번호 만료 - true 만료X
   @Override public boolean isCredentialsNonExpired() { return true; }
   // 계정 활성화(사용가능)
   @Override public boolean isEnabled() { return true; }
   
   ///////////////////////////////////////////
   
   private Map<String, Object> attributes;
   
   // alt + shift +s 
   public MemberUserDetails(Member member, Map<String, Object> getAttributes) {
	super();
	this.member = member;
	this.attributes = attributes;
   }

   @Override public Map<String, Object> getAttributes() { return null; }
   @Override public String getName() { return member.getUsername(); }
   public String getNickname() { return member.getNickname(); }
   public String getEmail() { return member.getEmail(); }
}

package com.company.project001.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.company.project001.oauth.PrincipalOauth2UserService;
import com.company.project001.util.JwtTokenFilter;
import com.company.project001.util.JwtUtil;

@Configuration 		// 스프링부트 설정파일
@EnableWebSecurity	// url 스프링시큐리티 제어 - SecurityFilterChain
public class SecurityConfig {
	
	@Autowired PrincipalOauth2UserService principalOauth2UserService;
	
	@Autowired JwtUtil jwtUtil; // jwt 토큰발급 1##
	
	//1. url 
	@Bean SecurityFilterChain filterChain(HttpSecurity http, MemberService memberService) throws Exception {
		
		JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(memberService, jwtUtil);  // 2##
		
		http
		.csrf().disable() // [개발용] (보호기능 비활성화) - csrf : 사용자 인증정보를 웹페이지에서 보내기
		.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) //세션 필요할때만
		.and()
		.authorizeRequests()
			.antMatchers("/api/member/login", "/api/member/join").permitAll() // mobile - jwt
			.antMatchers("/member/login", "/member/join", "/resources/**" ).permitAll() // pc - security
			.antMatchers("/board/**", "/member/member").authenticated() //로그인된 사용자만 접근가능
			.anyRequest().permitAll() //지정하지 않은 다른 모든요청은 허용
		.and()
		.formLogin()
			.loginPage("/member/login") // 커스텀로그인폼
			.loginProcessingUrl("/member/login") // 사용자입력한 값 처리 url 
			.defaultSuccessUrl("/member/member", true) // 로그인 성공시 경로 - true : 사용자가 로그인 전 요청이 있더라도 무시하고 이 url로 이동 
			.failureUrl("/member/login?error=true")
		.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) //로그아웃 경로
			.logoutSuccessUrl("/member/login") //로그아웃 겅공 경로
			.invalidateHttpSession(true) // 로그아웃시 세션 무효
		.and()
		.oauth2Login() // ouath2 - kakao, naver, google
			.loginPage("/member/login")
			.defaultSuccessUrl("/member/member")
			.userInfoEndpoint()
			.userService(principalOauth2UserService)
		.and()
		.and()
		.exceptionHandling()
			.authenticationEntryPoint((request,response,authException)->{
				if(!request.getRequestURI().startsWith("/api/")){ //pc
					response.sendRedirect("/member/login?error=true");
				}else { // mobile
					response.setStatus(401); // 인증되지 않음 : 권한 없음
					response.setContentType("application/json");
					response.getWriter().write("{\"error\":\"Unauthorized\"}");
					// {"error":"Unauthorized"}
				}
			})
			.accessDeniedHandler((request,response,authException)->{
				if(!request.getRequestURI().startsWith("/api/")){ //pc
					response.sendRedirect("/member/login?error=true");
				}else { // mobile
					response.setStatus(403); // 인증 됐지만 접근 권한 없음 : 일반이 관리자페이지
					response.setContentType("application/json");
					response.getWriter().write("{\"error\":\"Unauthorized\"}");
					// {"error":"Unauthorized"}
				}
			});
//		.csrf(csrf->csrf.ignoringRequestMatchers( // csrf 검사 생략
//						new AntPathRequestMatcher("/member/join","POST"),
//						new AntPathRequestMatcher("/board/insert","POST"),
//						new AntPathRequestMatcher("/board/update/**","POST"),
//						new AntPathRequestMatcher("/board/delete/**","POST")
//				)
//		);
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		//##
		
		
		return http.build();
	}
	
	//2. AuthenticationManager
	@Bean AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
		return auth.getAuthenticationManager();
	}
	
	//3. PasswordEncoder
//	@Bean PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}

/*			[ UsernamePassword ] token
 
 1. client [login]  ---  AuthenticationManager (관리자)  --	Provider (db체크)
 														  	PasswordEncoder (암호화)
 			[		]session
 															[UserDetail] 유저정보
 
 */

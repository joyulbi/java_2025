package com.company.project001.util;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project001.domain.Member;
import com.company.project001.member.MemberJoinForm;
import com.company.project001.member.MemberLoginForm;
import com.company.project001.member.MemberService;

@CrossOrigin(origins = "http://localhost:3000") // 여기 요청 오는 것 ok
@RestController
@RequestMapping("/api/member")
public class JwtMemberApiController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    //1. 회원가입
    // POST
    // http://localhost:8080/api/member/login
    /* Body > raw > JSON (application/json)
     	{
     		"username"	: "first",
     		"passsword"	: "1111",
     		"password2"	: "1111",
     		"email"		: "first@gmail.com"
     	}
     
    */

    @PostMapping("/join")
    public ResponseEntity<?> join(@Valid @RequestBody MemberJoinForm form) {

 
        if (!form.getPassword().equals(form.getPassword2())) {
            return ResponseEntity.badRequest().body(Map.of("error", "비밀번호가 일치하지 않습니다."));
        }

        try {
            Member member = new Member();
            member.setUsername(form.getUsername());
            member.setPassword(form.getPassword()); 
            member.setNickname(form.getUsername());
            member.setEmail(form.getEmail());

            memberService.insert(member);

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "회원가입 성공"));

        } catch (IllegalArgumentException e) { 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));

        } catch (Exception e) { 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "회원가입 중 오류가 발생했습니다."));
        }
    }
 
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginForm form) {
        Member member = memberService.findByUsername(form.getUsername());

        if (member == null || !passwordEncoder.matches(form.getPassword(), member.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "아이디 또는 비밀번호가 틀렸습니다."));
        }
 
        String token = jwtUtil.createToken(member.getUsername(), 60 * 60 * 1000);

        return ResponseEntity.ok(Map.of(
            "token", token,
            "username", member.getUsername(),
            "nickname", member.getNickname(),
            "role", member.getRole().name()
        ));
    }
     
    @GetMapping("/me")
    public ResponseEntity<?> myPage(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "토큰이 유효하지 않습니다."));
        }

        String token = authHeader.substring(7);

        if (jwtUtil.isExpired(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "토큰이 만료되었습니다."));
        }

        String username = jwtUtil.getLoginId(token);
        Member member = memberService.findByUsername(username);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "사용자 정보를 찾을 수 없습니다."));
        }

        return ResponseEntity.ok(Map.of(
            "username", member.getUsername(),
            "nickname", member.getNickname(),
            "email", member.getEmail(),
            "role", member.getRole().name()
        ));
    }
}

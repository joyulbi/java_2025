package com.thejoa.boot008.util7_iddouble;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyUserIdDoubleController {
	@Autowired MyUserService service;
	
	@GetMapping(value="/iddouble")
	public String iddouble() {return "iddouble";}
	
	@GetMapping(value="/idByUsername/{username}", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> idByUsername(@PathVariable String username){
		Map<String, Object> result = new HashMap<>();
		String msg="사용불가능합니다";
		try {
			service.selectUsername(username); //있으면 해당유저 정보
		}catch(Exception e) {msg="가능합니다";} // 없는 유저
		
		result.put("result",msg);
		return result;
	}
	
	@GetMapping(value="/idByUseremail/{email}", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> idByUseremail(@PathVariable String email){
		Map<String, Object> result = new HashMap<>();
		result.put("result", service.selectUsername(email));
		return result;
	}
}
// http://localhost:8080/idByUsername/first
//http://localhost:8080/idByUseremail/first@gmail.com
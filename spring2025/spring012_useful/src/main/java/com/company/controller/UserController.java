package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.UserDto;
import com.company.service.UserService;

@Controller
public class UserController {
	@Autowired  UserService  service;
	
//	@RequestMapping( value =   "/list.user" , method=RequestMethod.GET  )	
//	@GetMapping("/list.user")
	@RequestMapping(  "/list.user"   )	
	public String list(Model model) { 
		model.addAttribute("list" , service.selectAll());//처리하고 
		return "users/list";  //화면 
	}
	
	// detail.user - Get  방식  해당번호의 사용자정보  users/select.jsp 파일 
	@RequestMapping("/detail.user")
	public String detail(Model model , int no) {  
		//System.out.println(no);
		model.addAttribute("dto" , service.selectOne(no)); 
		return "users/select";   // 1) users 폴더안에  / select.jsp
	} // 2) http://localhost:8081/spring012_useful/detail.user?no=1
	
	// insert.user - Post 방식  글쓰기기능         , list.user
	/*
	@RequestMapping(value = "/insert.user" , method=RequestMethod.POST)
	public String insert( String name, int age ) {
		UserDto dto = new UserDto();  dto.setName(name); dto.setAge(age);
		if(dto != null) { service.insert(dto);  }
		return "redirect:/list.user";
	}*/
	@RequestMapping(value = "/insert.user" , method=RequestMethod.POST)
	public String insert( UserDto dto ) {   // UserDto 안에 속성이  name, age
		if(dto != null) { service.insert(dto);  }
		return "redirect:/list.user";
	}
	
	// update.user - Post 방식  글수정기능         , list.user   ( 도전! ) 
	@RequestMapping(value = "/update.user" , method=RequestMethod.POST)
	public String update(UserDto dto) {
		if(dto != null) { service.update(dto); }
		return "redirect:/list.user";
	}
	
	// delete.user - Get  방식  삭제기능          , list.user   
	@RequestMapping("/delete.user")
	public String delete(int no) {
		service.delete(no);
		return "redirect:/list.user";
	}
	
}







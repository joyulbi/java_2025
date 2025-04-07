package com.thejoa.boot002.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/ex1")
	@ResponseBody
	public String ex1() {return "hello22";}
	// localhost:8282/boot2/ex1
	
	@GetMapping("/ex2")
	//@RequestMapping("/ex2")
	public String ex(Model model) {
		model.addAttribute("test","ex2");
		return "ex2";
	}
	// localhost:8282/boot2/ex2
	
	@RequestMapping("/test")
	public String ex2() {
		return "test";
		// return "hello from test";
	}
	// localhost:8282/boot2/test
}

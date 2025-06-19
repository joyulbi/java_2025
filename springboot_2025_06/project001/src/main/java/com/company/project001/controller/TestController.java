package com.company.project001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project001.service.TestService;

@Controller
public class TestController {
	@Autowired TestService service;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {return "..........test";}
	
	@GetMapping("/service")
	public String service(Model model) {
		model.addAttribute("time",service.test());
		return "service";
	}
	// http://localhost:8080/service
}

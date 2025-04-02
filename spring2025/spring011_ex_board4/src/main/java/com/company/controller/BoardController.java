package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list() {return "board/list";}	
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String create() {return "board/write";}	

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String create_post() {return "board/write";}		
	
	@RequestMapping(value ="/detail", method =RequestMethod.GET )
	public String detail() {return "board/detail";}	
	
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public String edit() {return "board/edit";}	
	
	@RequestMapping(value = "/edit",method = RequestMethod.POST)
	public String edit_post() {return "board/edit";}	
	
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String delete() {return "board/delete";}	
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String delete_post() {return "board/delete";}	
	
}

//http://localhost:8080/spring011_ex_board4/board/list
//http://localhost:8080/spring011_ex_board4/board/create
//http://localhost:8080/spring011_ex_board4/board/detail
//http://localhost:8080/spring011_ex_board4/board/edit
//http://localhost:8080/spring011_ex_board4/board/delete




//ver-1
/*@Controller
public class BoardController_ver2 {
	
	@RequestMapping(value = "/board/list",method = RequestMethod.GET)
	public String list() {return "board/list";}	
	
	@RequestMapping(value = "/board/create",method = RequestMethod.GET)
	public String create() {return "board/write";}	

	@RequestMapping(value = "/board/create",method = RequestMethod.POST)
	public String create_post() {return "board/write";}		
	
	@RequestMapping(value ="/board/detail", method =RequestMethod.GET )
	public String detail() {return "board/detail";}	
	
	@RequestMapping(value = "/board/edit",method = RequestMethod.GET)
	public String edit() {return "board/edit";}	
	
	@RequestMapping(value = "/board/edit",method = RequestMethod.POST)
	public String edit_post() {return "board/edit";}	
	
	@RequestMapping(value = "/board/delete",method = RequestMethod.GET)
	public String delete() {return "board/delete";}	
	
	@RequestMapping(value = "/board/delete",method = RequestMethod.POST)
	public String delete_post() {return "board/delete";}	
	
}*/

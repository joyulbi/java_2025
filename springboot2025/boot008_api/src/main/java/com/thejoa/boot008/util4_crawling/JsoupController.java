package com.thejoa.boot008.util4_crawling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 

@Controller
public class JsoupController {
	@Autowired  Api_Jsoup1 jsoup;
	 
	@GetMapping(value="/jsoup1" , 
			produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> jsoup1() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("result", Boolean.TRUE);
		 result.put("data"  , jsoup.jsoup1());
		return result;
	}
	
	////////////////////////////////////
	@GetMapping(value="/jsoup3" , 
			produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> jsoup3() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("result", Boolean.TRUE);
		 result.put("data"  , jsoup.jsoup3());
		return result;
	}
	
	
}

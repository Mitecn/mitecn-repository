package com.kb.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping("teacher")
	public String teacher() {
		return "teacher";
	}
	@RequestMapping("student")
	public String student() {
		return "student";
	}
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	
}

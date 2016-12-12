package com.pris.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/welcome")
	public String index(){
		return "modelpage/index.html";
	}
}

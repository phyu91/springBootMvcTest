package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	//create mapping for hello
	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("theDate", new java.util.Date());
		return "hello";
	}

}

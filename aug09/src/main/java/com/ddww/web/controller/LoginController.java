package com.ddww.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login.sik")
	public String index() {
		return "login";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
}

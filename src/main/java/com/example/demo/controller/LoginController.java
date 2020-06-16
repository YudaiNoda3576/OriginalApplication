package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/login")
	public String getLogin(Model model) {

		return "register/login";
	}
	
	@PostMapping("/login")
	public String postLogin(Model model) {
		return "redirect:/home";
	}
}

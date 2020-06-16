package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SignupController {

	@GetMapping("/signup")
	public String  getSignUp(Model model) {
		return "register/signup.html";
	}
	
	@PostMapping("/signup")
	public String postSignup(Model model) {
		return "redirect:/login";
	}
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;

@Controller
@RequestMapping("/")
public class SignupController {

	@GetMapping("/signup")
	public String  getSignUp(@ModelAttribute SignupForm signupForm, Model model) {
		return "register/signup.html";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute @Validated(GroupOrder.class) SignupForm signupForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return getSignUp(signupForm, model);
		}
		
		return "redirect:/login";
	}
}

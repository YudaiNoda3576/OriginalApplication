package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/home")
	 public String getHome(Model model) {
		model.addAttribute("contents", "home/home :: home_contents");
		return "home/homeLayout.html";
	}
	
	@GetMapping("/logout")
	 public String getLogout() {
		return "redirect:/login";
	}
	
	@GetMapping("/admin")
	public String getAdmin(Model model) {
		model.addAttribute("contents", "register/admin :: admin_contents");
		return "home/homeLayout";
	}
}

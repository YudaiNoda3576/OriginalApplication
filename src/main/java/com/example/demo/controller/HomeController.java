package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Temple;
import com.example.demo.service.TempleService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	TempleService templeService;

	@GetMapping("/home")
	 public String getHome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		Temple temple = templeService.findByLoginId(userDetails.getUsername());
		model.addAttribute("contents", "home/home :: home_contents");
		model.addAttribute("temple", temple.getName());
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

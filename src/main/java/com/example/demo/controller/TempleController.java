package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Temple;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.TempleForm;
import com.example.demo.service.TempleService;

@Controller
@RequestMapping("/")
public class TempleController {
	
	private final TempleService templeService;
	
	@Autowired
	public TempleController(TempleService templeService) {
		this.templeService = templeService;
	}

	@GetMapping("/signup")
	public String  getSignUp(@ModelAttribute TempleForm templeForm, Model model) {
		return "register/signup.html";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute @Validated(GroupOrder.class) TempleForm templeForm, 
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("failed", "登録に失敗しました");
			return getSignUp(templeForm, model);
		}
		
		Temple temple = new Temple();
		temple.setTempleId(templeForm.getTempleId());
		temple.setPassword(templeForm.getPassword());
		temple.setTempleName(templeForm.getTempleName());
		temple.setDenomination(templeForm.getDenomination());
		temple.setMonkName(templeForm.getMonkName());
		temple.setPosition(templeForm.getPosition());
		temple.setPostalcode(templeForm.getPostalcode());
		temple.setAddress(templeForm.getAddress());
		temple.setEmail(templeForm.getEmail());
		
		templeService.create(temple);
		
		redirectAttributes.addFlashAttribute("success","登録が完了しました");
		return "redirect:/signup";
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Supporter;
import com.example.demo.service.SupporterService;

@Controller
@RequestMapping("/supporter")
public class SupporterController {

	private final SupporterService supporterService;

	@Autowired
	public SupporterController(SupporterService supporterService) {
		this.supporterService = supporterService;
	}

	@GetMapping("/supporterList")
	public String List(Model model) {
		List<Supporter> supporterList = supporterService.findAll();
		model.addAttribute("contents", "supporter/supporterList ::supporterList_contents");
		model.addAttribute("supporterList", supporterList);

		return "home/homeLayout";
	}
}

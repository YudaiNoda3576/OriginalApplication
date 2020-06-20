package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Supporter;
import com.example.demo.entity.SupporterWorship;

import com.example.demo.service.TempleService;
import com.example.demo.service.WorshipService;

@Controller
@RequestMapping("/")
public class WorshipController {
	@Autowired
	WorshipService worshipService;
	@Autowired
	TempleService templeService;

	@GetMapping("/schedule")
	public String getSchedule(Model model) {
		List<SupporterWorship> worshipList = worshipService.findScheduleWithSupporter();
		model.addAttribute("contents", "worship/worshipList :: worshipList_contents");
		model.addAttribute("worshipList", worshipList);

		return "home/homeLayout";
	}
}

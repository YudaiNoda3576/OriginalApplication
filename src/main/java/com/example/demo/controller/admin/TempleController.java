package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Temple;
import com.example.demo.service.TempleService;

@Controller
@RequestMapping("/")
public class TempleController {

	private final TempleService templeService;

	@Autowired
	public TempleController(TempleService templeService) {
		this.templeService = templeService;
	}

	@GetMapping("/templeList")
	public String List(Model model) {
		List<Temple> templeList = templeService.findAll();
//		th:include="<ファイルパス>::<th:fragment属性の値>"
		model.addAttribute("contents", "admin/temples/list :: templeList_contents");
		model.addAttribute("templeList", templeList);
 		
 		return "home/homeLayout";
	}
}

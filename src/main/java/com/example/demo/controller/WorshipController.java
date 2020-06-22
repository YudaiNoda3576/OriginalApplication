package com.example.demo.controller;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;

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


import com.example.demo.entity.SupporterWorship;
import com.example.demo.entity.Worship;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.WorshipForm;
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
	
	@GetMapping("/worship")
	public String getWorship(@ModelAttribute WorshipForm worshipForm, Model model) {
		model.addAttribute("contents", "worship/worshipRegister :: worshipRegister_contents");
		model.addAttribute("worshipTypes", getWorshipType());
		return "home/homeLayout";
	}
	
	
	@PostMapping("/worship")
	public String postSchedule(@ModelAttribute @Validated(GroupOrder.class) WorshipForm worshipForm, 
			BindingResult bindingResult, Model model, 
			RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("failed", "登録に失敗しました");
			return getWorship(worshipForm, model);
		}
		Worship worship = new Worship();
		worship.setWorshipType(worshipForm.getWorshipType());
		worship.setSchedule(worshipForm.getSchedule());
		worship.setRemark(worshipForm.getRemark());
		worship.setSupporterId(worshipForm.getSupporterId());
		worshipService.insert(worship);
		
		redirectAttributes.addFlashAttribute("success","登録が完了しました");
		return "redirect:/worship";	
	}
//	お参りの種類をMapに格納
	private Map<Integer, String> getWorshipType() {
		var map = new LinkedHashMap<Integer, String>();
		map.put(1, "葬式");
		map.put(2, "寺参り");
		map.put(3, "初七日");
		map.put(4, "七日七日");
		map.put(5, "一周忌");
		map.put(6, "三回忌");
		map.put(7, "七回忌");
		return map;
	}
}

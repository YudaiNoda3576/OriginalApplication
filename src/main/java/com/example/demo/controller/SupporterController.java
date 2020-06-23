package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Supporter;
import com.example.demo.entity.Temple;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.SupporterForm;
import com.example.demo.service.SupporterService;
import com.example.demo.service.TempleService;


@Controller
@RequestMapping("/")
public class SupporterController {

	private final SupporterService supporterService;

	@Autowired
	public SupporterController(SupporterService supporterService) {
		this.supporterService = supporterService;
	}
	
	@Autowired 
	private TempleService templeService;

	
	@GetMapping("/supporterList")
	public String List(Model model,@AuthenticationPrincipal UserDetails userDetails) {
		Temple temple = templeService.findByLoginId(userDetails.getUsername());
		List<Supporter> supporterList = supporterService.findByTempleId(temple.getId());
		model.addAttribute("contents", "supporter/supporterList :: supporterList_contents");
		model.addAttribute("supporterList", supporterList);

		return "home/homeLayout";
	}
	
	
	@GetMapping("/supporterInsert")
	public String getInsert(@ModelAttribute SupporterForm supporterForm, Model model) {
		model.addAttribute("contents", "supporter/insertSupporter :: supporter_contents");
		return "home/homeLayout";
	}
	
	@PostMapping("/supporterInsert")
	public String postInsert(@ModelAttribute @Validated(GroupOrder.class) SupporterForm supporterForm, 
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("failed", "登録に失敗しました");
			return getInsert(supporterForm, model);
		}
		Temple temple = templeService.findByLoginId(userDetails.getUsername());
		Supporter supporter = new Supporter();
		supporter.setSupporterId(1);
		supporter.setSupporterName(supporterForm.getSupporterName());
		supporter.setOwnerName(supporterForm.getOwnerName());
		supporter.setPostalcode(supporterForm.getPostalcode());
		supporter.setAddress(supporterForm.getAddress());
		supporter.setPhoneNumber(supporterForm.getPhoneNumber());
		supporter.setEmail(supporterForm.getEmail());
		supporter.setTempleId(temple.getId());
		supporterService.insert(supporter);
		
		redirectAttributes.addFlashAttribute("success", "登録が完了しました");
		return "redirect:/supporterInsert";
	}
}
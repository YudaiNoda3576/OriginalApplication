package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.WorshipOpts;
import com.example.demo.entity.SupporterWorship;
import com.example.demo.entity.Worship;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.WorshipForm;
import com.example.demo.service.IdNotExistException;
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

	@GetMapping("/worship/{supporterId}")
	public String getWorship(@ModelAttribute WorshipForm worshipForm, Model model,
			@PathVariable("supporterId") Integer supporterId) {
//		ガード節:処理の対象外とする条件を、関数やループの先頭に集めて return や continue/break で抜ける方法
		if (supporterId == null) {
			throw new IdNotExistException("檀徒IDが存在しません");
		}
		model.addAttribute("contents", "worship/worshipRegister :: worshipRegister_contents");
		model.addAttribute("worshipTypes", worshipForm);
		return "home/homeLayout";
	}

	@PostMapping("/worship/{supporterId}")
	public String postSchedule(@ModelAttribute @Validated(GroupOrder.class) WorshipForm worshipForm,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
			@PathVariable("supporterId") Integer supporterId) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("failed", "登録に失敗しました");
			return getWorship(worshipForm, model, supporterId);
		}
		Worship worship = new Worship();
		worship.setSupporterId(worshipForm.getSupporterId());
		worship.setWorshipOpts(WorshipOpts.valueOf(worshipForm.getWorshipType()));
		worship.setSchedule(worshipForm.getSchedule());
		worship.setRemark(worshipForm.getRemark());
		worshipService.insert(worship);

		redirectAttributes.addFlashAttribute("success", "登録が完了しました");
		return "redirect:/worship/{supporterId}";
	}
	
	@PostMapping("/complete")
	@ResponseBody
	public boolean complete(@RequestParam Integer worshipId) {
		Worship worship = new Worship();
		worshipService.findByWorshipId(worshipId);
		worshipService.judge(worship, true);
		return true; 
	}
	
	@PostMapping("/incomplete")
	@ResponseBody
	public boolean incomplete(@RequestParam Integer worshipId) {
		Worship worship = new Worship();
		worshipService.findByWorshipId(worshipId);
		worshipService.judge(worship, false);
		return false; 
	}
	
}

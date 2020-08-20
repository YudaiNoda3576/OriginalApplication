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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Supporter;
import com.example.demo.entity.Temple;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.SupporterForm;
import com.example.demo.form.TempleForm;
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

//	寺院IDに紐づく檀徒の情報を取得して一覧表示
//	ログイン情報はUserDetailsクラスに保存されているので、そこから値を取得する必要がある
	@GetMapping("/supporterList")
	public String List(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		Temple temple = templeService.findByLoginId(userDetails.getUsername());
		List<Supporter> supporterList = supporterService.findByTempleId(temple.getId());
		model.addAttribute("contents", "supporter/supporterList :: supporterList_contents");
		model.addAttribute("supporterList", supporterList);

		return "home/homeLayout";
	}
//	檀徒詳細情報の取得
	@GetMapping("/supporterDetail/{supporterId}")
	public String getSupporterDetail(@ModelAttribute SupporterForm supporterForm, Model model,
			@PathVariable("supporterId")Integer supporterId) {
		model.addAttribute("contents", "supporter/supporterDetail :: supporterDetail_contents");
		if(supporterId != null) {
			Supporter supporter = supporterService.findBySupporterId(supporterId);
			supporterForm.setSupporterName(supporter.getSupporterName());
			supporterForm.setOwnerName(supporter.getOwnerName());
			supporterForm.setPostalcode(supporter.getPostalcode());
			supporterForm.setAddress(supporter.getAddress());
			supporterForm.setPhoneNumber(supporter.getPhoneNumber());
			supporterForm.setEmail(supporter.getEmail());
			
			model.addAttribute("supporterForm", supporterForm);
		}
		return "home/homeLayout";
	}
	
//	檀徒詳細情報の更新処理
	@PostMapping(value = "/supporterDetail", params="update")
	public String postSupporterUpdate(@ModelAttribute SupporterForm supporterForm, Model model
			,RedirectAttributes redirectAttribute, @AuthenticationPrincipal UserDetails userDetails
			,@RequestParam("supporterId") Integer supporterId) {
		Supporter supporter = new Supporter(); 
		Temple temple = templeService.findByLoginId(userDetails.getUsername());
		supporter.setSupporterId(supporterId);
		supporter.setSupporterName(supporterForm.getSupporterName());
		supporter.setOwnerName(supporterForm.getOwnerName());
		supporter.setPostalcode(supporterForm.getPostalcode());
		supporter.setAddress(supporterForm.getAddress());
		supporter.setPhoneNumber(supporterForm.getPhoneNumber());
		supporter.setEmail(supporterForm.getEmail());
		supporter.setTempleId(temple.getId());
		supporterService.update(supporter);
		
		redirectAttribute.addFlashAttribute("success", "登録が完了しました");
		return "redirect:/supporterDetail/" + supporterId;
	}
// 檀徒情報の削除
//	@PostMapping(value = "/supporterDetail", params = "delete")
//	public String supperterDelete(@RequestParam("supporterId") Integer supporterId, Model model, Supporter supporter) {
//		supporterService.deleteBySupporterId(supporter);
//		return "redirect:/supporterDetail";
//	}
	
	//	登録済みの檀徒の情報を表示
	@GetMapping("/supporterInsert")
	public String getInsert(@ModelAttribute SupporterForm supporterForm, Model model) {
		model.addAttribute("contents", "supporter/insertSupporter :: supporter_contents");
		return "home/homeLayout";
	}
	
//	檀徒の情報を登録して保存
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
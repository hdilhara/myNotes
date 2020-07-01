package com.hdilhara.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	

	@RequestMapping("/")
	public String homePage() {
		
		return "dashboard";
	}
	@RequestMapping("/dashboard")
	public String homePage(Model model) {
		model.addAttribute("title", "sddsd sd s sgfgf fg f");
		return "dashboard";
	}
	
	
	
	@RequestMapping("/attendence")
	public String attendencePage() {
		
		return "attendence";
	}
	@RequestMapping("/marks")
	public String marksPage() {
		
		return "marks";
	}
	@RequestMapping("/notice-board")
	public String noticeBoardPage() {
		
		return "noticeboard";
	}

}

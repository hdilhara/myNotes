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
	
	@RequestMapping("/users")
	public String userPage() {
		
		return "users";
	}
	@RequestMapping("/users/admins")
	public String adminsPage() {
		
		return "/users/admins";
	}
	@RequestMapping("/users/students")
	public String studentsPage() {
		
		return "users/students";
	}
	@RequestMapping("/users/teachers")
	public String teachersPage() {
		
		return "users/teachers";
	}@RequestMapping("/users/parents")
	public String parentsPage() {
		
		return "users/parents";
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

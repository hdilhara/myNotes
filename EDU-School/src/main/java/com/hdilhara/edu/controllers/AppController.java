package com.hdilhara.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AppController {
	
	
	//add image file
	@RequestMapping("/add")
	public String addImageFile(@RequestParam("file") MultipartFile file) {
		
		
		
		return null;
		
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

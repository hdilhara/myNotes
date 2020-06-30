package com.hdilhara.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
	@RequestMapping("/admins")
	public String adminspage() {
		return "users/admins";
	}
	@RequestMapping("/teachers")
	public String teacherspage() {
		return "users/teachers";
	}
	@RequestMapping("/students")
	public String studentspage() {
		return "users/students";
	}
	@RequestMapping("/parents")
	public String parentspage() {
		return "users/parents";
	}
	
}

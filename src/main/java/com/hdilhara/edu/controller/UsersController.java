package com.hdilhara.edu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdilhara.edu.entity.Student;
import com.hdilhara.edu.model.StudentModel;
import com.hdilhara.edu.repository.StudentRepo;



@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private StudentRepo studentRepo;
	

	@RequestMapping("")
	public String userPage() {
		
		return "users";
	}
	@RequestMapping("/admins")
	public String adminsPage() {	
		return "users/admins";
	}
	@RequestMapping("/students")
	public String studentsPage(Model model) {	
		List<Student> students=(List<Student>) studentRepo.findAll();
		
		List<StudentModel> studentModels=new ArrayList<StudentModel>();
		
		for(Student s:students) {
			studentModels.add(new StudentModel(s.getFirstName(),s.getLastName(),s.getDob(),s.getAddress(),new String(s.getProfilePicture())));
		}
		model.addAttribute("students",studentModels);
		return "users/students";
	}
	@RequestMapping("/teachers")
	public String teachersPage() {
		
		return "users/teachers";
	}@RequestMapping("/parents")
	public String parentsPage() {
		
		return "users/parents";
	}
	
//	add new users
	@RequestMapping("/add/student")
	public String addStudent(Model model) {
		model.addAttribute("student",new StudentModel());
		return "/users/add/student";
	}
	@RequestMapping("/create/new/student")
	public String createNewStudent(@ModelAttribute StudentModel studentModel)	{
		byte[] bytes=null;
		try {
			bytes=Base64.getEncoder().encode(studentModel.getProfilePicture().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Student student = new Student(studentModel.getFirstName(),studentModel.getLastName(),studentModel.getDob(),studentModel.getAddress(),bytes);
		
		studentRepo.save(student);
		
		return "redirect:/users/students";
	}
	
}

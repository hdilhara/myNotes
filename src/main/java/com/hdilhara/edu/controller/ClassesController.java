package com.hdilhara.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hdilhara.edu.entity.Classes;
import com.hdilhara.edu.service.ClassService;
import com.hdilhara.edu.service.StudentService;

@Controller
@RequestMapping("/classes")
public class ClassesController {

	@Autowired 
	ClassService classService;
	
	@RequestMapping("")
	public String classesPage(Model model) {
		model.addAttribute("classes",classService.getAllClasses());	
		return "classes";
	}
	@RequestMapping("/{classId}/enrolled/students")
	public String classEnrolledStudents(@PathVariable int classId,Model model) {
		
		model.addAttribute("class",classService.getClassById(classId));
		model.addAttribute("students",classService.getStudentsByClassId(classId));
		return "users/class/students";
	}
	
	@RequestMapping("/{classId}/add/student")
	public String enrollStudentToClass(@PathVariable int classId,@RequestParam int studentRollNo,Model model ) {
		if(classService.addStudentToClassByStudentID(classId,studentRollNo)==null) {
			model.addAttribute("e","error");
		}
		return "redirect:/classes/"+classId+"/enrolled/students";
	}
	
	@RequestMapping("/{classId}/{studentId}/unenroll/student")
	public String unEnrollStudentFromClass(@PathVariable int classId, @PathVariable int studentId) {
		classService.unenrollStudentById(classId,studentId);
		return "redirect:/classes/"+classId+"/enrolled/students";
	}
}

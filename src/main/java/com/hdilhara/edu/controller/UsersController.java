package com.hdilhara.edu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.hdilhara.edu.entity.Parent;
import com.hdilhara.edu.entity.Student;
import com.hdilhara.edu.entity.Teacher;
import com.hdilhara.edu.model.StudentModel;
import com.hdilhara.edu.model.TeacherModel;
import com.hdilhara.edu.repository.ParentRepo;
import com.hdilhara.edu.repository.StudentRepo;
import com.hdilhara.edu.repository.TeacherRepo;
import com.hdilhara.edu.service.ParentService;
import com.hdilhara.edu.service.StudentService;
import com.hdilhara.edu.service.TeacherService;



@Controller
@RequestMapping("/users")
public class UsersController {
	//service Injection
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	ParentService parentService;
	

	
	
	
	//define mappings
	@RequestMapping("")
	public String userPage() {
		
		return "users";
	}
	@RequestMapping("/admins")
	public String adminsPage() {	
		return "users/admins";
	}
	

	
//	 student
	@RequestMapping("/students")
	public String studentsPage(Model model) {		
		model.addAttribute("students",studentService.studentsModelList());
		return "users/students";
	}
	@RequestMapping("/add/student")
	public String addStudent(Model model) {
		model.addAttribute("student",new StudentModel());
		return "/users/add/student";
	}
	@RequestMapping("/create/new/student")
	public String createNewStudent(@ModelAttribute StudentModel studentModel,Model model)	{
		model.addAttribute("student",studentService.createNewStudent(studentModel));
		return "users/add/student-created-success";
	}
	@RequestMapping("/student/{userId}/profile")
	public String updateStudentPage(@PathVariable int userId, Model model) {	
		model.addAttribute("student",studentService.getStudentModelById(userId));
		model.addAttribute("parent",studentService.getStudentParentByStudentId(userId));
		return "users/update/student";
	}
	@RequestMapping("/updated/student")
	public String updateStudent(@ModelAttribute StudentModel studentDto) {		
		studentService.updateStudent(studentDto);
		return "redirect:/users/students";
	}

	@RequestMapping("/deleted/student")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentService.deleteStudent(id);
		return "redirect:/users/students";
	}
//	teacher
	@RequestMapping("/teachers")
	public String teachersPage(Model model) {
		model.addAttribute("teachers",teacherService.getTeachersAsTeacherDto());
		return "users/teachers";
	}
	@RequestMapping("/add/teacher")
	public String addTeacher(Model model) {
		model.addAttribute("teacher",new TeacherModel());
		return "/users/add/teacher";
	}
	@RequestMapping("/create/new/teacher")
	public String createNewTeacher(@ModelAttribute TeacherModel teacherModel) {
		teacherService.createNewTeacherByTeacherModel(teacherModel);
		return "redirect:/users/teachers";
	}
	@RequestMapping("/teacher/{userId}/profile")
	public String updateTeacherPage(@PathVariable int userId, Model model) {
		model.addAttribute("teacher",teacherService.updateTeacherByTeachetId(userId));
		return "users/update/teacher";
	}
	@RequestMapping("/updated/teacher")
	public String updateTeacher(@ModelAttribute TeacherModel teacherDto) {
		teacherService.updateTeacherByTeacherDto(teacherDto);
		return "redirect:/users/teachers";
	}
	@RequestMapping("/deleted/teacher")
	public String deleteTeacher(@RequestParam("teacherId") int id) {
		
		teacherService.deleteTeacherById(id);
		return "redirect:/users/teachers";
	}
//parent
	@RequestMapping("/parents")
	public String parentsPage(Model model) {
		model.addAttribute("parents",parentService.getAllParents());
		return "users/parents";
	}
	@RequestMapping("/create/{studentId}/parent")
	public String addParent(@ModelAttribute Parent parent,@PathVariable int studentId) {
		studentService.addParentByStudentReference(studentId,parent);
		return "redirect:/users/students";
	}
	@RequestMapping("/update/{studentId}/parent")
	public String updateParent(@ModelAttribute Parent parent,@PathVariable int studentId) {
		studentService.updateParentByStudentId(studentId,parent);
		return "redirect:/users/students";
	}
	@RequestMapping("/parent/{parentId}/profile")
	public String parentProfilePage(@PathVariable int parentId, Model model) {
		model.addAttribute("parent",parentService.getParentById(parentId));
		model.addAttribute("student",parentService.getStudentByParentId(parentId));
		return "users/update/parent";
	}
	

}

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
	
	
	
	//add repository injection
	@Autowired
	private StudentRepo studentRepo;
	@Autowired 
	private TeacherRepo teacherRepo;
	@Autowired
	private ParentRepo parentRepo;
	
	
	
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
		byte[] bytes=null;
		try {
			bytes=Base64.getEncoder().encode(studentModel.getProfilePicture().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Student student = new Student(studentModel.getFirstName(),studentModel.getLastName(),studentModel.getDob(),studentModel.getAddress(),bytes);
		
		studentRepo.save(student);
		
		model.addAttribute("student",student);
		
		return "users/add/student-created-success";
	}
	@RequestMapping("/student/{userId}/profile")
	public String updateStudentPage(@PathVariable int userId, Model model) {
		
		Optional<Student> student = studentRepo.findById(userId);
		if(!student.isPresent()) {
			return "redirect:/teachers";
		}
		Student student1=student.get();
		String profilePicture = "";
		if(student1.getProfilePicture()!=null)
			profilePicture=new String(student1.getProfilePicture());
		
		
		StudentModel studentDto = new StudentModel(student1.getFirstName(),student1.getLastName(),student1.getDob()
				,student1.getAddress(),profilePicture,student1.getStudentId());
		
		model.addAttribute("student",studentDto);
		Parent parent = student.get().getParent();
		System.out.println("xxxx"+parent);
		model.addAttribute("parent",parent);
		return "users/update/student";
	}
	@RequestMapping("/updated/student")
	public String updateStudent(@ModelAttribute StudentModel studentDto) {
		
		Student student=new Student(studentDto.getStudentId(),studentDto.getFirstName(),studentDto.getLastName()
				,studentDto.getDob(),studentDto.getAddress());

		
		
		if(studentDto.getProfilePicture().getSize()!=0) {
			try {
				byte[] bytes=Base64.getEncoder().encode(studentDto.getProfilePicture().getBytes());
				student.setProfilePicture(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Optional<Student> optStudent=studentRepo.findById(studentDto.getStudentId());
			student.setProfilePicture(optStudent.get().getProfilePicture());
		}
		studentRepo.save(student);
		return "redirect:/users/students";
	}

	@RequestMapping("/deleted/student")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentRepo.deleteById(id);
		return "redirect:/users/students";
	}
//	teacher
	@RequestMapping("/teachers")
	public String teachersPage(Model model) {
		List<Teacher> teachers=(List<Teacher>) teacherRepo.findAll();
		
		List<TeacherModel> teacherModels=new ArrayList<TeacherModel>();
		
		for(Teacher t:teachers) {
			if(t.getProfilePicture()==null) {
				File f = new File("src/logo.png");
				byte[] bytes=null;
				try {
					bytes=Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/logo.png")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.setProfilePicture(bytes);
			}
			
			teacherModels.add(new TeacherModel(t.getFirstName(),t.getLastName(),t.getDob(),t.getContactNumber(),t.getAddress(),new String(t.getProfilePicture()),t.getTeacherId()));
			
		}
		model.addAttribute("teachers",teacherModels);
		return "users/teachers";
	}
	@RequestMapping("/add/teacher")
	public String addTeacher(Model model) {
		model.addAttribute("teacher",new TeacherModel());
		return "/users/add/teacher";
	}
	@RequestMapping("/create/new/teacher")
	public String createNewTeacher(@ModelAttribute TeacherModel teacherModel) {
		byte[] bytes=null;
		try {
			bytes=Base64.getEncoder().encode(teacherModel.getProfilePicture().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Teacher teacher = new Teacher(teacherModel.getFirstName(),teacherModel.getLastName(),teacherModel.getDob(),teacherModel.getContactNumber(),teacherModel.getAddress(),bytes);
		
		teacherRepo.save(teacher);
		return "redirect:/users/teachers";
	}
	@RequestMapping("/teacher/{userId}/profile")
	public String updateTeacherPage(@PathVariable int userId, Model model) {
		
		Optional<Teacher> teacher=teacherRepo.findById(userId);
		if(!teacher.isPresent()) {
			return "redirect:/teachers";
		}
		Teacher teacher1=teacher.get();
		String profilePicture = "";
		if(teacher1.getProfilePicture()!=null)
			profilePicture=new String(teacher1.getProfilePicture());
		
		
		TeacherModel teacherDto=new TeacherModel(teacher1.getFirstName(),teacher1.getLastName(),teacher1.getDob(),teacher1.getContactNumber()
				,teacher1.getAddress(),profilePicture,teacher1.getTeacherId());
		
		model.addAttribute("teacher",teacherDto);
		return "users/update/teacher";
	}
	@RequestMapping("/updated/teacher")
	public String updateTeacher(@ModelAttribute TeacherModel teacherDto) {
		
		Teacher teacher=new Teacher(teacherDto.getTeacherId(),teacherDto.getFirstName(),teacherDto.getLastName()
				,teacherDto.getDob(),teacherDto.getContactNumber(),teacherDto.getAddress());

		
		
		if(teacherDto.getProfilePicture().getSize()!=0) {
			try {
				byte[] bytes=Base64.getEncoder().encode(teacherDto.getProfilePicture().getBytes());
				teacher.setProfilePicture(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Optional<Teacher> optTeacher=teacherRepo.findById(teacherDto.getTeacherId());
			teacher.setProfilePicture(optTeacher.get().getProfilePicture());
		}
		teacherRepo.save(teacher);
		return "redirect:/users/teachers";
	}
	@RequestMapping("/deleted/teacher")
	public String deleteTeacher(@RequestParam("teacherId") int id) {
		teacherRepo.deleteById(id);
		return "redirect:/users/teachers";
	}
//parent
	@RequestMapping("/parents")
	public String parentsPage(Model model) {
		List<Parent> parents=(List<Parent>) parentRepo.findAll();
		model.addAttribute("parents",parents);
		return "users/parents";
	}
	@RequestMapping("/create/{studentId}/parent")
	public String addParent(@ModelAttribute Parent parent,@PathVariable int studentId) {
		Optional<Student> student=studentRepo.findById(studentId);
		student.get().setParent(parent);
		studentRepo.save(student.get());
		System.out.println(parent);
		return "redirect:/users/students";
	}
	@RequestMapping("/update/{studentId}/parent")
	public String updateParent(@ModelAttribute Parent parent,@PathVariable int studentId) {
		Optional<Student> student=studentRepo.findById(studentId);
		Parent parent1=student.get().getParent();
		parent.setParentId(parent1.getParentId());
		parentRepo.save(parent);
		System.out.println(parent1);
		return "redirect:/users/students";
	}
	
	

}

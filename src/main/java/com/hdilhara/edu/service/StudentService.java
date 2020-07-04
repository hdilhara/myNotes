package com.hdilhara.edu.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdilhara.edu.entity.Parent;
import com.hdilhara.edu.entity.Student;
import com.hdilhara.edu.model.StudentModel;
import com.hdilhara.edu.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired 
	StudentRepo studentRepo;
	@Autowired 
	ParentService parentService;

	public List<StudentModel> studentsModelList() {
		List<Student> students=(List<Student>) studentRepo.findAll();	
		List<StudentModel> studentModels=new ArrayList<StudentModel>();	
		for(Student s:students) {
			if(s.getProfilePicture()==null) {
				File f = new File("src/logo.png");
				byte[] bytes=null;
				try {
					bytes=Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/logo.png")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.setProfilePicture(bytes);
			}
			studentModels.add(new StudentModel(s.getFirstName(),s.getLastName(),s.getDob(),s.getAddress(),new String(s.getProfilePicture()),s.getStudentId()));
		}
		return studentModels;
	}

	public Student createNewStudent(StudentModel studentModel) {
		byte[] bytes=null;
		try {
			bytes=Base64.getEncoder().encode(studentModel.getProfilePicture().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Student student = new Student(studentModel.getFirstName(),studentModel.getLastName(),studentModel.getDob(),studentModel.getAddress(),bytes);
		studentRepo.save(student);
		return student;
	}

	public void updateStudent(StudentModel studentDto) {
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
	}

	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
	}

	public StudentModel getStudentModelById(int userId) {
		Optional<Student> student = studentRepo.findById(userId);
		Student student1=student.get();
		String profilePicture = "";
		if(student1.getProfilePicture()!=null)
			profilePicture=new String(student1.getProfilePicture());
		
		
		StudentModel studentDto = new StudentModel(student1.getFirstName(),student1.getLastName(),student1.getDob()
				,student1.getAddress(),profilePicture,student1.getStudentId());
		return studentDto;
	}

	public Parent getStudentParentByStudentId(int userId) {
		Parent parent = studentRepo.findById(userId).get().getParent();
		return parent;
	}

	public void addParentByStudentReference(int studentId, Parent parent) {
		Optional<Student> student=studentRepo.findById(studentId);
		student.get().setParent(parent);
		studentRepo.save(student.get());
	}

	public void updateParentByStudentId(int studentId, Parent parent) {
		Optional<Student> student=studentRepo.findById(studentId);
		Parent parent1=student.get().getParent();
		parent.setParentId(parent1.getParentId());
		parentService.parentRepo.save(parent);
	}


	
}

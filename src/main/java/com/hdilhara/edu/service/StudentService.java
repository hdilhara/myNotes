package com.hdilhara.edu.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdilhara.edu.entity.Student;
import com.hdilhara.edu.model.StudentModel;
import com.hdilhara.edu.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired 
	StudentRepo studentRepo;

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
	
	
}

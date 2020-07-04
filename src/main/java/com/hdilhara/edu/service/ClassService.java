package com.hdilhara.edu.service;

import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdilhara.edu.entity.Classes;
import com.hdilhara.edu.repository.ClassRepo;
import com.hdilhara.edu.repository.StudentRepo;

@Service
public class ClassService {
	
	@Autowired
	ClassRepo classRepo;
	
	@Autowired 
	StudentRepo studentRepo;

	public List<Classes> getAllClasses() {
		return (List<Classes>) classRepo.findAll();
	}

	public Classes getClassById(int classId) {
		return classRepo.findById(classId).get();
	}

	public Object getStudentsByClassId(int classId) {
		return classRepo.findById(classId).get().getStudents();
	}

	public String addStudentToClassByStudentID(int classId, int studentRollNo) {
		if(!studentRepo.findById(studentRollNo).isPresent()) {
			return null;
		}
		Classes classes = classRepo.findById(classId).get();
		classes.addStudent(studentRepo.findById(studentRollNo).get());		
		classRepo.save(classes);
		return "success";
	}

	public void unenrollStudentById(int classId, int studentId) {
		Classes classes = classRepo.findById(classId).get();
		classes.getStudents().removeIf(x -> x.getStudentId()==studentId);		
		classRepo.save(classes);
	}

}

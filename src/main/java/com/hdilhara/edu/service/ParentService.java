package com.hdilhara.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdilhara.edu.entity.Parent;
import com.hdilhara.edu.entity.Student;
import com.hdilhara.edu.model.StudentModel;
import com.hdilhara.edu.repository.ParentRepo;

@Service
public class ParentService {

	@Autowired
	ParentRepo parentRepo;

	public List<Parent> getAllParents() {
		List<Parent> parents=(List<Parent>) parentRepo.findAll();
		return parents;
	}

	public Parent getParentById(int parentId) {
		return parentRepo.findById(parentId).get();
	}

	public Student getStudentByParentId(int parentId) {
		Student student = parentRepo.findById(parentId).get().getStudent();
		return student;
	}
	
	
	
	
}

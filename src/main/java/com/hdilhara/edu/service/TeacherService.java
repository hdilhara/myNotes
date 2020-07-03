package com.hdilhara.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdilhara.edu.repository.TeacherRepo;

@Service
public class TeacherService {
	
	@Autowired 
	TeacherRepo teacherRepo;
}

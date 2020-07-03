package com.hdilhara.edu.repository;

import org.springframework.data.repository.CrudRepository;

import com.hdilhara.edu.entity.Teacher;

public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
	
}

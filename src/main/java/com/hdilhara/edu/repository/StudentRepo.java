package com.hdilhara.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hdilhara.edu.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

}

package com.hdilhara.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdilhara.edu.entity.Parent;
import com.hdilhara.edu.repository.ParentRepo;

@Service
public class ParentService {

	@Autowired
	ParentRepo parentRepo;

	public List<Parent> getAllParents() {
		List<Parent> parents=(List<Parent>) parentRepo.findAll();
		return parents;
	}
	
	
	
	
}

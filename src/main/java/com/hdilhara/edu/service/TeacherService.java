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

import com.hdilhara.edu.entity.Teacher;
import com.hdilhara.edu.model.TeacherModel;
import com.hdilhara.edu.repository.TeacherRepo;

@Service
public class TeacherService {
	
	@Autowired 
	TeacherRepo teacherRepo;

	public Object getTeachersAsTeacherDto() {
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
		return teacherModels;
	}

	public void createNewTeacherByTeacherModel(TeacherModel teacherModel) {
		byte[] bytes=null;
		try {
			bytes=Base64.getEncoder().encode(teacherModel.getProfilePicture().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Teacher teacher = new Teacher(teacherModel.getFirstName(),teacherModel.getLastName(),teacherModel.getDob(),teacherModel.getContactNumber(),teacherModel.getAddress(),bytes);
		
		teacherRepo.save(teacher);
	}

	public TeacherModel updateTeacherByTeachetId(int userId) {
		Optional<Teacher> teacher=teacherRepo.findById(userId);
		Teacher teacher1=teacher.get();
		String profilePicture = "";
		if(teacher1.getProfilePicture()!=null)
			profilePicture=new String(teacher1.getProfilePicture());
		TeacherModel teacherDto=new TeacherModel(teacher1.getFirstName(),teacher1.getLastName(),teacher1.getDob(),teacher1.getContactNumber()
				,teacher1.getAddress(),profilePicture,teacher1.getTeacherId());
		return teacherDto;
	}

	public void updateTeacherByTeacherDto(TeacherModel teacherDto) {
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
	}

	public void deleteTeacherById(int id) {
		teacherRepo.deleteById(id);
	}
}

package com.hdilhara.edu.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	
	private int grade;
	private char section;
	private int year;
	
	//student class mapping
	@ManyToMany
	@JoinTable(
			name="student_class",
			joinColumns = @JoinColumn(name="classId"),
			inverseJoinColumns = @JoinColumn(name="studentId")
			)
	private List<Student> students;
	
	
	//custom methods
	public void addStudent(Student student) {
		students.add(student);
	}
	
	
	//Constructores and getters and setters
	public Classes() {
		super();
	}
	
	
	public Classes(int classId, int grade, char section, int year, List<Student> students) {
		super();
		this.classId = classId;
		this.grade = grade;
		this.section = section;
		this.year = year;
		this.students = students;
	}


	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", grade=" + grade + ", section=" + section + ", year=" + year
				+ ", students=" + students + "]";
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}

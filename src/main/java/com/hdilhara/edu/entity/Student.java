package com.hdilhara.edu.entity;



import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int studentId;
	
	
	private String firstName;
	private String lastName;
	
	private Date dob;
	private String address;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] profilePicture;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parentId")
	private Parent parent;
	
	//student class mapping
	@ManyToMany
	@JoinTable(
			name = "student_class",
			joinColumns = @JoinColumn(name="studentId"),
			inverseJoinColumns = @JoinColumn(name="classId")
			)
	private List<Classes> classes;
	
	
	//constructors
	public Student() {
		super();
	}
	
	public Student( String firstName, String lastName, Date dob,String address, byte[] profilePicture) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.profilePicture = profilePicture;
	}

	
	

	public Student(int studentId, String firstName, String lastName, Date dob, String address, byte[] profilePicture) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.profilePicture = profilePicture;
	}
	
	

	public Student(int studentId, String firstName, String lastName, Date dob, String address) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	
	
}

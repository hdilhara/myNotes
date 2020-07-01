package com.hdilhara.edu.model;



import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class StudentModel {

	private String firstName;
	private String lastName;
	
	private Date dob;
	private String address;
	private MultipartFile profilePicture;
	private String stringProfilePicture;

	
	
	public StudentModel() {
		super();
	}
	
	public StudentModel(String firstName, String lastName, Date dob,String address, String stringProfilePicture) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address=address;
		this.stringProfilePicture = stringProfilePicture;
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
	public MultipartFile getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getStringProfilePicture() {
		return stringProfilePicture;
	}
	public void setStringProfilePicture(String stringProfilePicture) {
		this.stringProfilePicture = stringProfilePicture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}

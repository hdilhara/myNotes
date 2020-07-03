package com.hdilhara.edu.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

public class TeacherModel {

	private String firstName;
	private String lastName;
	private Date dob;
	private int contactNumber;
	private String address;
	private MultipartFile profilePicture;
	private String stringProfilePicture;
	private int teacherId;
	
	
	public TeacherModel() {
		super();
	}
	public TeacherModel(String firstName, String lastName, Date dob, int contactNumber, String address,
			String stringProfilePicture) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.address = address;
		this.stringProfilePicture = stringProfilePicture;
	}
	public TeacherModel(String firstName, String lastName, Date dob, int contactNumber, String address, String stringProfilePicture, int teacherId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.address = address;
		this.profilePicture = profilePicture;
		this.stringProfilePicture = stringProfilePicture;
		this.teacherId = teacherId;
	}
	public String getStringProfilePicture() {
		return stringProfilePicture;
	}
	public void setStringProfilePicture(String stringProfilePicture) {
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
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MultipartFile getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherID(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
}

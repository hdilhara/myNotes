package com.hdilhara.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parentId;
	
	private String firstName;
	private String lastName;
	private String occupation;
	private String relationship;
	private int contactNumber ;
	
	@OneToOne(mappedBy = "parent")
	private Student student;
	
	
	public Parent() {
		super();
	}
	
	public Parent(int parentId, String firstName, String lastName, String occupation, String relationship,
			int contactNumber) {
		super();
		this.parentId = parentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.relationship = relationship;
		this.contactNumber = contactNumber;
	}

	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
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
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Parent [parentId=" + parentId + ", firstName=" + firstName + ", lastName=" + lastName + ", occupation="
				+ occupation + ", relationship=" + relationship + ", contactNumber=" + contactNumber + "]";
	}
	
	
}

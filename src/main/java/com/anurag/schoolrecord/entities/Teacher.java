package com.anurag.schoolrecord.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@NotBlank(message= "Teacher id is compulsary")
	@Column(name = "teacher_id")
	private int teacherId;
	@NotBlank(message="First name is compulsary")
	@Column(name = "first_name")
	private String firstName;
	@NotBlank(message="Last name is compulsary")
	@Column(name = "last_name")
	private String lastName;
	@NotBlank(message="subject is compulsary")
	@Column(name = "subject_id")
	private String subjectId;
	
	
	
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subjectId=" + subjectId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((subjectId == null) ? 0 : subjectId.hashCode());
		result = prime * result + teacherId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}
	
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	
}

package com.anurag.schoolrecord.database_entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "roll_no")
	private int rollNo;
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	@NotBlank
	@Column(name = "course_id")
	private String courseId;
	
	
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", courseId="
				+ courseId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + rollNo;
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
		Student other = (Student) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
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
		if (rollNo != other.rollNo)
			return false;
		return true;
	}
	
	

}
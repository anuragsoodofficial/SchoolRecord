package com.anurag.schoolrecord.studentregister;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.database_entities.Student;

@Service
public class StudentRegisterServices {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	//Add Student details
	public void addStudent(Student student) {
		//first_name and last_name validations
				if(student.getFirstName().contains(" ") && student.getLastName().contains(" ")) {
					student.setFirstName(student.getFirstName().substring(0,student.getFirstName().indexOf(' ')));
					student.setLastName(student.getLastName().substring(0,student.getLastName().indexOf(' ')));
				}else if(student.getFirstName().contains(" ")) {
					student.setFirstName(student.getFirstName().substring(0,student.getFirstName().indexOf(' ')));
				}else if(student.getLastName().contains(" ")) {
					student.setLastName(student.getLastName().substring(0,student.getLastName().indexOf(' ')));
				}
				
		
		studentRepository.save(student);
	}

	
	//Get a student by its rollNo
	public Optional<Student> findStudentByRollNo(int rollNo){
		return studentRepository.findById(rollNo);
	}
	
	//Get all student details
	public ArrayList<Student> getAllStudent(){
		ArrayList<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	//Delete a student details
		public void removeStudent(int rollNo) {
			studentRepository.deleteById(rollNo);
		}
	
}

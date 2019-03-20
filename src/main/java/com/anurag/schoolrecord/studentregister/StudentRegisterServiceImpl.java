package com.anurag.schoolrecord.studentregister;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.entities.Student;

@Service
public class StudentRegisterServiceImpl implements StudentRegisterService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	//Add Student details
	@Override
	public String addStudent(Student student) {
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
		return "Added";
	}

	
	//Get a student by its rollNo
	@Override
	public Optional<Student> findStudentByRollNo(int rollNo){
		return studentRepository.findById(rollNo);
	}
	
	//Get all student details
	@Override
	public ArrayList<Student> getAllStudent(){
		ArrayList<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	//Delete a student details
	@Override
		public String removeStudent(int rollNo) {
			studentRepository.deleteById(rollNo);
			return "Removed";
		}
	
		//Update Student details
	@Override
	public String updateStudent(Student student) {
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
		return "Updated";
		}
}

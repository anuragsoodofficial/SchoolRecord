package com.anurag.schoolrecord.studentregister;

import java.util.ArrayList;
import java.util.List;
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
		studentRepository.save(student);
	}
	
	//Get a student by its rollNo
	public List<Student> findStudentByRollNo(Iterable<Integer> rollNo){
		return studentRepository.findAllById(rollNo);
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

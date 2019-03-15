package com.anurag.schoolrecord.studentregister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.Student;

@RestController
public class StudentRegisterController {
	
	@Autowired
	private StudentRegisterServices studentRegisterServices;
	
	//add a student
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public void addStudent(Student student) {
		studentRegisterServices.addStudent(student);
	}
	//get a student by its rollNo
	@RequestMapping("/student?roll_no=")
	public List<Student> getStudentByRollNo(Iterable<Integer> rollNo){
		return studentRegisterServices.findStudentByRollNo(rollNo);
	}
	
	//get all students details
	@RequestMapping("/student")
	public ArrayList<Student> getAllStudents() {
		return studentRegisterServices.getAllStudent();
	}
}

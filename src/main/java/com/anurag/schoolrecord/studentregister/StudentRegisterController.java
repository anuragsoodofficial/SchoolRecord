package com.anurag.schoolrecord.studentregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.Student;

@RestController
public class StudentRegisterController {
	
	@Autowired
	private StudentRegisterServices studentRegisterServices;
	
	//add a student
	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public void addStudent(@RequestBody Student student) {
		studentRegisterServices.addStudent(student);
	}
	//get a student by its rollNo
	@RequestMapping("/student/get")
	public Optional<Student> getStudentByRollNo(@RequestParam(name = "rollNo",defaultValue="Unknown") int rollNo){
		return studentRegisterServices.findStudentByRollNo(rollNo);
	}
	
	//get all students details
	@RequestMapping("/student")
	public ArrayList<Student> getAllStudents() {
		return studentRegisterServices.getAllStudent();
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/student")
	public void removeUser(@RequestParam(name = "rollNo",defaultValue="Unknown") int rollNo) {
		studentRegisterServices.removeStudent(rollNo);
	}
	
	//update a student
		@RequestMapping(method = RequestMethod.PUT, value = "/student")
		public void updateStudent(@RequestBody Student student) {
			studentRegisterServices.updateStudent(student);
		}
}

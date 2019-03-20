package com.anurag.schoolrecord.studentregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.entities.Student;

@RestController
public class StudentRegisterController {
	
	@Autowired
	private StudentRegisterServiceImpl studentRegisterServiceImpl;
	
	//add a student
	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		studentRegisterServiceImpl.addStudent(student);
		return "Success";
	}
	//get a student by its rollNo
	@GetMapping("/student/get")
	public Optional<Student> getStudentByRollNo(@RequestParam(name = "rollNo",defaultValue="Unknown") int rollNo){
		return studentRegisterServiceImpl.findStudentByRollNo(rollNo);
	}
	
	//get all students details
	@GetMapping("/student")
	public ArrayList<Student> getAllStudents() {
		return studentRegisterServiceImpl.getAllStudent();
	}
	
	@DeleteMapping("/student")
	public String removeUser(@RequestParam(name = "rollNo",defaultValue="Unknown") int rollNo) {
		studentRegisterServiceImpl.removeStudent(rollNo);
		return "Removed Successfully";
	}
	
	//update a student
		@PutMapping("/student")
		public String updateStudent(@RequestBody Student student) {
			studentRegisterServiceImpl.updateStudent(student);
			return "Updated Successfully";
		}
}

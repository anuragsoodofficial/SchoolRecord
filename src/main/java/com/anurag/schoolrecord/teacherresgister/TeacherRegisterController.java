package com.anurag.schoolrecord.teacherresgister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.entities.Teacher;

@RestController
public class TeacherRegisterController {

	@Autowired
	TeacherRegisterServiceImpl teacherRegisterServiceImpl;
	
		//add a teacher
		@RequestMapping(value = "/teacher", method = RequestMethod.POST)
		public String addTeacher(@RequestBody Teacher teacher) {
			teacherRegisterServiceImpl.addTeacher(teacher);
			return "Added Successfully";
		}
			
		//get a teacher by its id
		@RequestMapping("/teacher/get")
		public Optional<Teacher> findTeacherByItsId(@RequestParam(name="teacherId",defaultValue="Unknown") int teacherId){
			return teacherRegisterServiceImpl.findTeacherById(teacherId);
			}
		
		//get all teachers details
		@RequestMapping("/teacher")
		public ArrayList<Teacher> getAllTeachers() {
			return teacherRegisterServiceImpl.getAllTeachers();
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/teacher")
		public String removeUser(@RequestParam(name="teacherId",defaultValue="Unknown") int teacherId) {
			teacherRegisterServiceImpl.removeTeacher(teacherId);
			return "Removed Successfully";
		}
		
		//update a teacher
			@RequestMapping(value = "/teacher", method = RequestMethod.POST)
			public String updateTeacher(@RequestBody Teacher teacher) {
				teacherRegisterServiceImpl.updateTeacher(teacher);
				return "Updated Successfully";
			}
}

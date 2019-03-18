package com.anurag.schoolrecord.teacherresgister;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.Teacher;

@RestController
public class TeacherRegisterController {

	@Autowired
	TeacherRegisterService teacherRegisterService;
	
		//add a teacher
		@RequestMapping(value = "/teacher", method = RequestMethod.POST)
		public void addStudent(Teacher teacher) {
			teacherRegisterService.addTeacher(teacher);
		}
			
		//get a teacher by its id
		@RequestMapping("/teacher?tacher_id=")
		public List<Teacher> findTeacherByItsId(Iterable<Integer> teacherId){
			return teacherRegisterService.findTeacherById(teacherId);
			}
		
		//get all teachers details
		@RequestMapping("/teacher")
		public ArrayList<Teacher> getAllTeachers() {
			return teacherRegisterService.getAllTeachers();
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="\"/teacher?teacher_id=\"")
		public void removeUser(@PathVariable int teacherId) {
			teacherRegisterService.removeTeacher(teacherId);
		}
}

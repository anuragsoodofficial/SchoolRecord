package com.anurag.schoolrecord.teacherresgister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.Teacher;

@RestController
public class TeacherRegisterController {

	@Autowired
	TeacherRegisterService teacherRegisterService;
	
		//add a teacher
		@RequestMapping(value = "/teacher", method = RequestMethod.POST)
		public void addTeacher(@RequestBody Teacher teacher) {
			teacherRegisterService.addTeacher(teacher);
		}
			
		//get a teacher by its id
		@RequestMapping("/teacher/get")
		public Optional<Teacher> findTeacherByItsId(@RequestParam(name="teacherId",defaultValue="Unknown") int teacherId){
			return teacherRegisterService.findTeacherById(teacherId);
			}
		
		//get all teachers details
		@RequestMapping("/teacher")
		public ArrayList<Teacher> getAllTeachers() {
			return teacherRegisterService.getAllTeachers();
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/teacher")
		public void removeUser(@RequestParam(name="teacherId",defaultValue="Unknown") int teacherId) {
			teacherRegisterService.removeTeacher(teacherId);
		}
		
		//update a teacher
				@RequestMapping(value = "/teacher", method = RequestMethod.POST)
				public void updateTeacher(@RequestBody Teacher teacher) {
					teacherRegisterService.updateTeacher(teacher);
				}
}

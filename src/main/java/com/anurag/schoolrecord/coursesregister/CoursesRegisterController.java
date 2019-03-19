package com.anurag.schoolrecord.coursesregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.database_entities.Courses;

@RestController
public class CoursesRegisterController {

	@Autowired
	private CoursesRegisterServices coursesRegisterServices;
	
	//Get all courses
	@RequestMapping("/courses")
	public ArrayList<Courses> getAllCourses(){
		return coursesRegisterServices.getAllCourses();
	}
	
	//Add a course
	@RequestMapping(method = RequestMethod.POST,value = "/courses")
	public void addCourse(@RequestBody Courses courses) {
		coursesRegisterServices.addCourse(courses);
	}
	
	//Get a course  by its id
	@RequestMapping("/courses/get")
	public Optional<Courses> getCourseByItsId(@RequestParam(name = "courseId",defaultValue = "Unknown") String courseId){
		return coursesRegisterServices.getCourseByItsId(courseId);
	}
	
	//Delete a course
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses")
	public void removeCourse(@RequestParam(name = "courseId",defaultValue = "Unknown") String courseId) {
		coursesRegisterServices.removeCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/courses")
	public void updateCourse(@RequestBody Courses courses) {
		coursesRegisterServices.updateCourse(courses);
	}
}

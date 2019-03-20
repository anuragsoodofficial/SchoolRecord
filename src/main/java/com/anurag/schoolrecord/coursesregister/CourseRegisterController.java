package com.anurag.schoolrecord.coursesregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.schoolrecord.entities.Course;

@RestController
public class CourseRegisterController {

	@Autowired
	private CourseRegisterServicesImpl courseRegisterServicesImpl;
	
	//Get all courses
	@RequestMapping("/courses")
	public ArrayList<Course> getAllCourses(){
		return courseRegisterServicesImpl.getAllCourses();
	}
	
	//Add a course
	@RequestMapping(method = RequestMethod.POST,value = "/courses")
	public String addCourse(@RequestBody Course course) {
		courseRegisterServicesImpl.addCourse(course);
		return "Added Successfully";
	}
	
	//Get a course  by its id
	@RequestMapping("/courses/get")
	public Optional<Course> getCourseByItsId(@RequestParam(name = "courseId",defaultValue = "Unknown") String courseId){
		return courseRegisterServicesImpl.getCourseByItsId(courseId);
	}
	
	//Delete a course
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses")
	public String removeCourse(@RequestParam(name = "courseId",defaultValue = "Unknown") String courseId) {
		courseRegisterServicesImpl.removeCourse(courseId);
		return "Removed Successfully";
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/courses")
	public String updateCourse(@RequestBody Course course) {
		courseRegisterServicesImpl.updateCourse(course);
		return "Updated Successfully";
	}
}

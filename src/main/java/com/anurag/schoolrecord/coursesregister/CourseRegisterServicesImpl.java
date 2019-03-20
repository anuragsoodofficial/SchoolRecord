package com.anurag.schoolrecord.coursesregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.entities.Course;

@Service
public class CourseRegisterServicesImpl implements CourseRegisterService {
	
	@Autowired
	private CourseRegisterRepository courseRegisterRepository;

	// Add a course
	@Override
	public String addCourse(Course course) {
		courseRegisterRepository.save(course);
		return "Added";
	}
	
	//Get a course by its Id
	@Override
	public Optional<Course> getCourseByItsId(String courseId){
		return courseRegisterRepository.findById(courseId);
	}
	
	//Get all courses
	@Override
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> course = new ArrayList<>();
		courseRegisterRepository.findAll().forEach(course::add);
		return course;
	}
	
		//Delete a course
	@Override
	public String removeCourse(String courseId) {
		courseRegisterRepository.deleteById(courseId);
		return "Removed";
	}
		
		//Update a course
	@Override
	public String updateCourse(Course course) {
		courseRegisterRepository.save(course);
		return "Updated";
	}
}

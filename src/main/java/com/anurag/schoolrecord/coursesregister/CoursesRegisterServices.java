package com.anurag.schoolrecord.coursesregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.database_entities.Courses;

@Service
public class CoursesRegisterServices {
	
	@Autowired
	private CourseRegisterRepository courseRegisterRepository;

	// Add a course
	public void addCourse(Courses courses) {
		courseRegisterRepository.save(courses);
	}
	
	//Get a course by its Id
	public Optional<Courses> getCourseByItsId(String courseId){
		return courseRegisterRepository.findById(courseId);
	}
	
	//Get all courses
	public ArrayList<Courses> getAllCourses(){
		ArrayList<Courses> courses = new ArrayList<>();
		courseRegisterRepository.findAll().forEach(courses::add);
		return courses;
	}
	
		//Delete a course
		public void removeCourse(String courseId) {
			courseRegisterRepository.deleteById(courseId);
		}
		
		//Update a course
		public void updateCourse(Courses courses) {
			courseRegisterRepository.save(courses);
		}
}

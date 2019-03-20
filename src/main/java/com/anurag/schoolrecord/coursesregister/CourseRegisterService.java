package com.anurag.schoolrecord.coursesregister;

import java.util.ArrayList;
import java.util.Optional;

import com.anurag.schoolrecord.entities.Course;

public interface CourseRegisterService {
	String addCourse(Course course);
	Optional<Course> getCourseByItsId(String courseId);
	ArrayList<Course> getAllCourses();
	String removeCourse(String courseId);
	String updateCourse(Course course);
}

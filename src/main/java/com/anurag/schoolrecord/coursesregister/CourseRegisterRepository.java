package com.anurag.schoolrecord.coursesregister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.schoolrecord.entities.Course;

public interface CourseRegisterRepository extends JpaRepository<Course, String> {

}

package com.anurag.schoolrecord.coursesregister;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anurag.schoolrecord.entities.Course;

@Repository
public interface CourseRegisterRepository extends JpaRepository<Course, String> {

}

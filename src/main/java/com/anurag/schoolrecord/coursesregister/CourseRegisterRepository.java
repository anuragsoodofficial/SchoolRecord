package com.anurag.schoolrecord.coursesregister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.schoolrecord.database_entities.Courses;

public interface CourseRegisterRepository extends JpaRepository<Courses, String> {

}

package com.anurag.schoolrecord.teacherresgister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.schoolrecord.database_entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

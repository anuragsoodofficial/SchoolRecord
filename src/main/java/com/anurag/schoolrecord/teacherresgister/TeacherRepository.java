package com.anurag.schoolrecord.teacherresgister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.schoolrecord.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

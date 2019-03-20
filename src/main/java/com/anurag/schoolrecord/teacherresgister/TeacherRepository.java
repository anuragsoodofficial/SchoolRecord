package com.anurag.schoolrecord.teacherresgister;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anurag.schoolrecord.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

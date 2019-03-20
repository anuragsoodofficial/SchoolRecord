package com.anurag.schoolrecord.studentregister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.schoolrecord.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}

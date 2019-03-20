package com.anurag.schoolrecord.studentregister;

import java.util.ArrayList;
import java.util.Optional;

import com.anurag.schoolrecord.entities.Student;

public interface StudentRegisterService {
	String addStudent(Student student);
	Optional<Student> findStudentByRollNo(int rollNo);
	ArrayList<Student> getAllStudent();
	String removeStudent(int rollNo);
	String updateStudent(Student student);
}

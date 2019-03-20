package com.anurag.schoolrecord.teacherresgister;

import java.util.ArrayList;
import java.util.Optional;

import com.anurag.schoolrecord.entities.Teacher;

public interface TeacherRegisterService {
	String addTeacher(Teacher teacher);
	Optional<Teacher> findTeacherById(int teacherId);
	ArrayList<Teacher> getAllTeachers();
	String removeTeacher(int teacherId);
	String updateTeacher(Teacher teacher);
}

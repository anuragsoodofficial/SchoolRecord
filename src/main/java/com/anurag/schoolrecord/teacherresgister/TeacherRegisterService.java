package com.anurag.schoolrecord.teacherresgister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.database_entities.Teacher;

@Service
public class TeacherRegisterService {

	@Autowired
	TeacherRepository teacherRepository;
	
	//Add teacher details
	public void addTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}
	//Get a teacher details by its id
	public Optional<Teacher> findTeacherById(int teacherId){
		return teacherRepository.findById(teacherId);
	}
	//Get all teachers details
	public ArrayList<Teacher> getAllTeachers(){
		ArrayList<Teacher> teachers = new ArrayList<>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
	}
	
	//Delete a teacher details
	public void removeTeacher(int teacherId) {
		teacherRepository.deleteById(teacherId);
	}

}

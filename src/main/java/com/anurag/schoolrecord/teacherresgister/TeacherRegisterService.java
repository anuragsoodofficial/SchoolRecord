package com.anurag.schoolrecord.teacherresgister;

import java.util.ArrayList;
import java.util.List;

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
	public List<Teacher> findTeacherById(Iterable<Integer> teacherId){
		return teacherRepository.findAllById(teacherId);
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

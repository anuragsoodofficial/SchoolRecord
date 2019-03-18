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
		//first_name and last_name validations
				if(teacher.getFirstName().contains(" ") && teacher.getLastName().contains(" ")) {
					teacher.setFirstName(teacher.getFirstName().substring(0,teacher.getFirstName().indexOf(' ')));
					teacher.setLastName(teacher.getLastName().substring(0,teacher.getLastName().indexOf(' ')));
				}else if(teacher.getFirstName().contains(" ")) {
					teacher.setFirstName(teacher.getFirstName().substring(0,teacher.getFirstName().indexOf(' ')));
				}else if(teacher.getLastName().contains(" ")) {
					teacher.setLastName(teacher.getLastName().substring(0,teacher.getLastName().indexOf(' ')));
				}
				
				
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

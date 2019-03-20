package com.anurag.schoolrecord.teacherresgister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.entities.Teacher;

@Service
public class TeacherRegisterServiceImpl implements TeacherRegisterService {

	@Autowired
	TeacherRepository teacherRepository;
	
	//Add teacher details
	@Override
	public String addTeacher(Teacher teacher) {
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
		return "Added";
	}
	//Get a teacher details by its id
	@Override
	public Optional<Teacher> findTeacherById(int teacherId){
		return teacherRepository.findById(teacherId);
	}
	//Get all teachers details
	@Override
	public ArrayList<Teacher> getAllTeachers(){
		ArrayList<Teacher> teachers = new ArrayList<>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
	}
	
	//Delete a teacher details
	@Override
	public String removeTeacher(int teacherId) {
		teacherRepository.deleteById(teacherId);
		return "Removed";
	}
	
	//Update teacher details
	@Override
		public String updateTeacher(Teacher teacher) {
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
			return "Updated";
		}

}

package com.anurag.schoolrecord.subjectregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.database_entities.Subject;

@Service
public class SubjectRegisterService {

	@Autowired
	private SubjectRegisterRepository subjectRegisterRepository;
	
	//add a subject
	public void addSubject(Subject subject) {
		subjectRegisterRepository.save(subject);
	}
	
	//Get all subjects
	public ArrayList<Subject> getAllSubjects(){
		ArrayList<Subject> subjects = new ArrayList<>();
		subjectRegisterRepository.findAll().forEach(subjects::add);
		return subjects;
	}
	
	//Get subject by its id
	public Optional<Subject> getSubjectByItsId(String subjectId){
		return subjectRegisterRepository.findById(subjectId);
	}
	
	//Delete a subject
	public void removeSubject(String subjectId) {
		subjectRegisterRepository.deleteById(subjectId);
	}
}

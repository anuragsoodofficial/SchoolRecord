package com.anurag.schoolrecord.subjectregister;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.schoolrecord.entities.Subject;

@Service
public class SubjectRegisterServiceImpl implements SubjectRegisterService {

	@Autowired
	private SubjectRegisterRepository subjectRegisterRepository;
	
	//add a subject
	@Override
	public String addSubject(Subject subject) {
		subjectRegisterRepository.save(subject);
		return "Added";
	}
	
	//Get all subjects
	@Override
	public ArrayList<Subject> getAllSubjects(){
		ArrayList<Subject> subjects = new ArrayList<>();
		subjectRegisterRepository.findAll().forEach(subjects::add);
		return subjects;
	}
	
	//Get subject by its id
	@Override
	public Optional<Subject> getSubjectByItsId(String subjectId){
		return subjectRegisterRepository.findById(subjectId);
	}
	
	//Delete a subject
	@Override
	public String removeSubject(String subjectId) {
		subjectRegisterRepository.deleteById(subjectId);
		return "Removed";
	}
	
	//Update a subject
	@Override
	public String updateSubject(Subject subject) {
		subjectRegisterRepository.save(subject);
		return "Updated";
	}
}
